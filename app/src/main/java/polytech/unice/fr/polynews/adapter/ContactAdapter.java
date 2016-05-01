package polytech.unice.fr.polynews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.model.Contact;

/**
 * Created by cesar on 26/04/2016.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {



    public ContactAdapter(Context context, int resource, List<Contact> array) {
        super(context, resource, array);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.layout_contact_assos, null);
        }

        Contact p = getItem(position);
        TextView nomPres = (TextView) convertView.findViewById(R.id.nom_pres);
        TextView numPres = (TextView) convertView.findViewById(R.id.num_pres_assos);
        TextView nameAssos = (TextView) convertView.findViewById(R.id.Nom_assos);
        TextView mailPres = (TextView) convertView.findViewById(R.id.mail_assos);

        if (nomPres != null){
            nomPres.setText(p.getPrenom());
        }
        if (nameAssos != null){
            nameAssos.setText(p.getNom());
        }
        if (numPres != null){
            numPres.setText(p.getNumeros());
        }
        if (mailPres != null){
            mailPres.setText(p.getNumeros());
        }


        return convertView;
    }
}
