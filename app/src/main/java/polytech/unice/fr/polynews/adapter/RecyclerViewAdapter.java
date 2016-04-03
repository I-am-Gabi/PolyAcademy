package polytech.unice.fr.polynews.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.database.NewsDBHelper;
import polytech.unice.fr.polynews.model.Event;

/**
 * @version 03/04/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Event> mDataset;
    private Context context;
    // Provide a reference to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title_event);
            this.description = (TextView) itemView.findViewById(R.id.description_event);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewAdapter(Context context) {
        this.context = context;
        this.mDataset = setmDataset();
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_evento_row, parent, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from dataset at this position
        // - replace the contents of the view with that element
        holder.title.setText(mDataset.get(position).getTitle());
        holder.description.setText(mDataset.get(position).getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public List<Event> setmDataset() {
        NewsDBHelper dbHelper = new NewsDBHelper(context);
        try {
            dbHelper.createDataBase();
            dbHelper.openDataBase();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        List<Event> newsList = dbHelper.selectRecords();
        return newsList;
    }
}