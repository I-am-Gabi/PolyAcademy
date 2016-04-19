package polytech.unice.fr.polynews.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.layout_campus_home, container, false);
        //TextView textView = (TextView) rootView.findViewById(R.id.Title);
        //textView.setText("les templiers");

        final Button button = (Button) rootView.findViewById(R.id.buttonTemplier);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CampusFragment newfragment = CampusFragment.newInstance();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, newfragment).commit();
            }
        });
        final Button button1 = (Button) rootView.findViewById(R.id.buttonLearning);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LearningFragment newfragment = LearningFragment.newInstance();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, newfragment).commit();
            }
        });

        final Button button2 = (Button) rootView.findViewById(R.id.buttoncantine);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CantineFragment newfragment = CantineFragment.newInstance();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content ,newfragment).commit();
            }
        });


        return rootView;
    }


}
