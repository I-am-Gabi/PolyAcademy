package polytech.unice.fr.polynews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.activity.ItemDetailActivity;
import polytech.unice.fr.polynews.database.EventsDBHelper;
import polytech.unice.fr.polynews.fragment.news.ItemDetailFragment;
import polytech.unice.fr.polynews.model.Event;

/**
 * @version 19/04/16.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<Event> dataSet;
    private Context context;

    // Provide a reference to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView title;
        public TextView description;
        public TextView date_time;
        public Context context;
        private ItemClickListener clickListener;
        public final View mView;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            mView = itemView;
            this.context = context;
            this.title = (TextView) itemView.findViewById(R.id.title_new);
            this.description = (TextView) itemView.findViewById(R.id.description_new);
            this.date_time = (TextView) itemView.findViewById(R.id.date_time_new);
            itemView.setOnClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }
    }

    public interface ItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsAdapter(Context context) {
        this.context = context;
        this.dataSet = setDataSet();
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_new, parent, false);
        return new ViewHolder(v, context);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from dataset at this position
        // - replace the contents of the view with that element
        holder.title.setText(dataSet.get(position).getTitle());
        holder.description.setText(dataSet.get(position).getDescription());
        holder.date_time.setText(dataSet.get(position).getDateTime());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra(ItemDetailFragment.ARG_ITEM_TITLE, dataSet.get(position).getTitle());
                intent.putExtra(ItemDetailFragment.ARG_ITEM_CONTENT, dataSet.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private List<Event> setDataSet() {
        EventsDBHelper dbHelper = new EventsDBHelper(context);
        try {
            dbHelper.createDataBase();
            dbHelper.openDataBase();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return dbHelper.selectRecords();
    }

    public List<Event> getDataSet(){
        return dataSet;
    }
}