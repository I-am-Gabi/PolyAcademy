package polytech.unice.fr.polynews.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import polytech.unice.fr.polynews.R;

/**
 * Created by cesar on 05/04/2016.
 */
public class CampusHomeFragment extends Fragment {

    public static CampusHomeFragment newInstance() {

        CampusHomeFragment fragment = new CampusHomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_campus_home, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.Title);
        textView.setText("les templiers");
        return rootView;
    }
}
