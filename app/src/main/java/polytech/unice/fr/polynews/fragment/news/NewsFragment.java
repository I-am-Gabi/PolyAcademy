package polytech.unice.fr.polynews.fragment.news;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.NewsAdapter;

/**
 * @version 17/04/2016.
 */
public class NewsFragment extends Fragment {
    RecyclerView recyclerView;
    /**
     * Returns a new instance of this polytech.unice.fr.polynews.fragment for the given section
     * number.
     */
    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_new, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.nlist);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        assert recyclerView != null;
        setupRecyclerView(recyclerView);

        return rootView;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new NewsAdapter(getActivity()));
    }
}
