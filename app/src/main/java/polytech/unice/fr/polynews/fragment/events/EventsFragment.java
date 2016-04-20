package polytech.unice.fr.polynews.fragment.events;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.EventsAdapter;

/**
 * @version 02/04/16.
 */
public class EventsFragment extends Fragment {
    RecyclerView recyclerView;
    /**
     * Returns a new instance of this polytech.unice.fr.polynews.fragment for the given section
     * number.
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
        View rootView = inflater.inflate(R.layout.fragment_event, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        EventsAdapter adapter = new EventsAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
