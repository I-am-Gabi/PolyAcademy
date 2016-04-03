package polytech.unice.fr.polynews.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.RecyclerViewAdapter;
import polytech.unice.fr.polynews.database.NewsDBHelper;
import polytech.unice.fr.polynews.model.Event;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this polytech.unice.fr.polynews.fragment must implement the
 * to handle interaction events.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this polytech.unice.fr.polynews.fragment.
 */
public class EventsFragment extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this polytech.unice.fr.polynews.fragment using the provided parameters.
     *
     * @return A new instance of polytech.unice.fr.polynews.fragment EventsFragment.
     */
    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_card_view, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NewsDBHelper dbHelper = new NewsDBHelper(getActivity());
        try {
            dbHelper.createDataBase();
            dbHelper.openDataBase();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        List<Event> newsList = dbHelper.selectRecords();
       // RecyclerViewAdapter adapter = new RecyclerViewAdapter(newsList);

        RecyclerView view = (RecyclerView) getView().findViewById(R.id.recycler_view);
        //view.setAdapter(adapter);
    }
}