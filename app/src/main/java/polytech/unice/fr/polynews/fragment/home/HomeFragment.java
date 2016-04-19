package polytech.unice.fr.polynews.fragment.home;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytech.unice.fr.polynews.R;

/**
 * @version 02/04/16.
 */
public class HomeFragment extends Fragment {
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
       // TextView textView = (TextView) rootView.findViewById(R.id.text_home);
       // textView.setText(Html.fromHtml(getResources().getString(R.)));
        return rootView;
       // return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
