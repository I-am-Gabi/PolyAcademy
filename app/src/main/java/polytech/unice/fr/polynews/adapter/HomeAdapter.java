package polytech.unice.fr.polynews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import polytech.unice.fr.polynews.R;

/**
 * @version 20/04/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;
    private int[] mDataSetTypes;

    public static final int WEATHER = 0;
    public static final int INFO = 1;
    public static final int NEWS = 2;


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

    public class ScoreViewHolder extends ViewHolder {
        TextView score;

        public ScoreViewHolder(View v) {
            super(v);
            this.score = (TextView) v.findViewById(R.id.score);
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
        View v;
        if (viewType == WEATHER) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.home_card, viewGroup, false);
            return new WeatherViewHolder(v);
        } else if (viewType == INFO) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.home_card_2, viewGroup, false);
            return new ScoreViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.home_card_4, viewGroup, false);
            return new NewsViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        if (viewHolder.getItemViewType() == WEATHER) {
            WeatherViewHolder holder = (WeatherViewHolder) viewHolder;
            holder.temp.setText(mDataSet[position]);
        }
        else if (viewHolder.getItemViewType() == NEWS) {
            NewsViewHolder holder = (NewsViewHolder) viewHolder;
            holder.headline.setText(mDataSet[position]);
        }
        else {
            ScoreViewHolder holder = (ScoreViewHolder) viewHolder;
            holder.score.setText(mDataSet[position]);
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
}