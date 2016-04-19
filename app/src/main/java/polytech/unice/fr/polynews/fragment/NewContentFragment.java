package polytech.unice.fr.polynews.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytech.unice.fr.polynews.R;


/**
 * Created by user on 17/04/2016.
 */
public class NewContentFragment extends Fragment {
    RecyclerView recyclerView;
    /**
     * Returns a new instance of this polytech.unice.fr.polynews.fragment for the given section
     * number.
     */
    public static NewContentFragment newInstance() {
        NewContentFragment fragment = new NewContentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fg_newcontext, container, false);
        return rootView;
    }

}
