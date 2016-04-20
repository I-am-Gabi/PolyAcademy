package polytech.unice.fr.polynews.fragment.campus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytech.unice.fr.polynews.R;

/**
 * Created by cesar on 19/04/2016.
 */
public class LearningFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.layout_learning, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static LearningFragment newInstance(){
        LearningFragment fragment = new LearningFragment();

        return fragment;
    }
}
