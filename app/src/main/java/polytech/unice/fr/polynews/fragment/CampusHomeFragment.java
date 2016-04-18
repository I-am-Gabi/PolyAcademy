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

/*                String tmp = new String(button.getText().toString());
                System.out.println("valeur du bouton = " + tmp.toUpperCase());
                DescribeCampus value = DescribeCampus.valueOf(tmp.toUpperCase());
                View rootView = inflater.inflate(R.layout.view_campus, container, false);
                TextView t = (TextView) rootView.findViewById(R.id.Description_Campus);
                System.out.println("le textview = " + t);
                t.setText("ICI CEST PARIS");
                t = (TextView) rootView.findViewById(R.id.Nom_du_lieu);
                t.setText("ICI CEST VENISE");*/
                fragmentManager.beginTransaction().replace(R.id.layout_campus, newfragment).commit();
            }
        });

        return rootView;
    }


}
