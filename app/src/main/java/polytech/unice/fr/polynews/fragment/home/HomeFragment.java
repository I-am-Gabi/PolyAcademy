package polytech.unice.fr.polynews.fragment.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.HomeAdapter;
import polytech.unice.fr.polynews.service.YahooWeatherService;

/**
 * @version 02/04/16.
 */
public class HomeFragment extends Fragment {
    public static final int POLYTECH = 0;
    public static final int WEATHER = 1;
    public static final int INFO = 2;
    public static final int NEWS = 3;

    private YahooWeatherService service;
    RecyclerView recyclerView;
    private String[] mDataset = {"a", "no service",
            "Know more about SI!!!" /*getContext.getResources().getString(R.string.home_info)*/,
            "Flash missing, vanishes in crisis"};

    private int mDatasetTypes[] = {POLYTECH, WEATHER, INFO, NEWS}; //view types

    /**
     * Returns a new instance of this polytech.unice.fr.polynews.fragment for the given section
     * number.
     *
     * This fragment is responsible to the main page: Present the school, show the image gallery too.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        HomeAdapter adapter = new HomeAdapter(mDataset, mDatasetTypes);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
