package polytech.unice.fr.polynews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.activity.ItemDetailActivity;
import polytech.unice.fr.polynews.database.Channel;
import polytech.unice.fr.polynews.database.Item;
import polytech.unice.fr.polynews.database.NewsDBHelper;
import polytech.unice.fr.polynews.fragment.news.ItemDetailFragment;
import polytech.unice.fr.polynews.model.Event;
import polytech.unice.fr.polynews.service.WeatherServiceCallBak;
import polytech.unice.fr.polynews.service.YahooWeatherService;

/**
 * @version 20/04/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> implements WeatherServiceCallBak {
    private static final String TAG = "CustomAdapter";

    private YahooWeatherService service;

    private String[] mDataSet;
    private int[] mDataSetTypes;

    public static final int WEATHER = 0;
    public static final int INFO = 1;
    public static final int NEWS = 2;

    WeatherViewHolder holder_weather;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class WeatherViewHolder extends ViewHolder {
        TextView temp;

        public WeatherViewHolder(View v) {
            super(v);
            this.temp = (TextView) v.findViewById(R.id.temp);
        }
    }

    public class InfoViewHolder extends ViewHolder {
        TextView info;
        Button read_more;

        public InfoViewHolder(View v) {
            super(v);
            this.info = (TextView) v.findViewById(R.id.info);
            this.read_more = (Button) v.findViewById(R.id.read_more_info);
        }
    }

    public class NewsViewHolder extends ViewHolder {
        TextView headline;
        Button read_more;

        public NewsViewHolder(View v) {
            super(v);
            this.headline = (TextView) v.findViewById(R.id.headline);
            this.read_more = (Button) v.findViewById(R.id.read_more);
        }
    }


    public HomeAdapter(String[] dataSet, int[] dataSetTypes) {
        mDataSet = dataSet;
        mDataSetTypes = dataSetTypes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        service = new YahooWeatherService(this);
        service.refreshWeather("Nice, FR");

        View v;
        if (viewType == WEATHER) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.weather, viewGroup, false);
            return new WeatherViewHolder(v);
        } else if (viewType == INFO) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.information, viewGroup, false);
            return new InfoViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.news, viewGroup, false);
            return new NewsViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        if (viewHolder.getItemViewType() == WEATHER) {
            holder_weather = (WeatherViewHolder) viewHolder;
            holder_weather.temp.setText(mDataSet[position]);
        }
        else if (viewHolder.getItemViewType() == NEWS) {
            NewsViewHolder holder = (NewsViewHolder) viewHolder;
            NewsDBHelper dbHelper = new NewsDBHelper(holder.headline.getContext());
            try {
                dbHelper.createDataBase();
                dbHelper.openDataBase();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

            final Event event = dbHelper.selectTopRecord();
            holder.headline.setText(event.getTitle());

            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_TITLE, event.getTitle());
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_CONTENT, event.getDescription());
                    context.startActivity(intent);
                }
            };
            holder.read_more.setOnClickListener(listener);
        }
        else {
            InfoViewHolder holder = (InfoViewHolder) viewHolder;
            holder.info.setText(mDataSet[position]);

            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    //Intent intent = new Intent(context, ItemDetailActivity.class);
                    //context.startActivity(intent);
                    Toast toast = Toast.makeText(context, "READ MORE", Toast.LENGTH_SHORT);
                    toast.show();
                }
            };
            holder.read_more.setOnClickListener(listener);
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSetTypes[position];
    }

    @Override
    public void serviceSucces(Channel c) {
        Item item = c.getItem();

        String temperatureTextView = item.getCondition().getTemperature()+ " " + c.getUnit().getTemperature();
        String conditionTextView = item.getCondition().getDescription();
        mDataSet[0] = temperatureTextView + " " + conditionTextView;
        holder_weather.temp.setText(mDataSet[0]);
    }

    @Override
    public void serviceFaillure(Exception e) {

    }
}