package polytech.unice.fr.polynews.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytech.unice.fr.polynews.R;

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
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        return rootView;
    }
}
