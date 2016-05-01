package polytech.unice.fr.polynews.fragment.contact;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.HomeAdapter;
import polytech.unice.fr.polynews.database.Channel;
import polytech.unice.fr.polynews.database.Item;
import polytech.unice.fr.polynews.service.WeatherServiceCallBak;

/**
 * @version 02/04/16.
 */
public class HomeFragment extends Fragment implements WeatherServiceCallBak {
    public static final int WEATHER = 0;
    public static final int INFO = 1;
    public static final int NEWS = 2;

    RecyclerView recyclerView;
    private String[] mDataset = {"no service", "Know more about our University!",
            "Flash missing, vanishes in crisis"};
    private int mDatasetTypes[] = {WEATHER, INFO, NEWS}; //view types

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

    @Override
    public void serviceSucces(Channel c) {
        Item item = c.getItem();

        String temperatureTextView = item.getCondition().getTemperature()+ " " + c.getUnit().getTemperature();
        String conditionTextView = item.getCondition().getDescription();
        mDataset[0] = temperatureTextView + " " + conditionTextView;
    }

    @Override
    public void serviceFaillure(Exception e) {
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
