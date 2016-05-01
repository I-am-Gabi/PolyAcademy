package polytech.unice.fr.polynews.fragment.contact;


import android.app.Fragment;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.ContactAdapter;
import polytech.unice.fr.polynews.database.ContactPopulate;
import polytech.unice.fr.polynews.model.Contact;

//import android.support.v4.app.Fragment;

/**
 * @version 01/05/2016.
 */
public class ContactFragmentAssos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String jsondata = "";

        try {
            jsondata = jsonToStringFromFile("Contact.json", getActivity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ArrayList<Contact> array = (ArrayList<Contact>) new ContactPopulate(jsondata).getContacts();
        ContactAdapter adapter = new ContactAdapter(container.getContext(), R.id.assos_list_view, array);
        final View rootView = inflater.inflate(R.layout.layout_contact_assos, container, false);

        final ListView listView = (ListView) rootView.findViewById(R.id.assos_list_view);
        listView.setAdapter(adapter);

        return rootView;

    }

    public static ContactFragmentAssos newInstance() {
        ContactFragmentAssos fragment = new ContactFragmentAssos();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    /***
 *
 */
    public static String jsonToStringFromFile(String fileName, Context context) throws IOException {
        AssetManager manage = context.getAssets();
        InputStream file = manage.open(fileName);
        byte[] donnees = new byte[file.available()];
        file.read(donnees);
        file.close();
        return new String(donnees);
    }
}
