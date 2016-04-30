package polytech.unice.fr.polynews.database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import polytech.unice.fr.polynews.model.Contact;

/**
 * Created by cesar on 26/04/2016.
 */
public class ContactPopulate implements JSONPopulate {
    List<Contact> contacts;
    @Override
    public void populate(JSONObject data) throws JSONException {
        contacts = new ArrayList<Contact>();
        if (data.optString("type").equals("contact")){
            throw new JSONException("not the good file");
        }
        JSONArray arr = data.getJSONArray("identite");
        for (int i = 0; i < arr.length(); i++){
            contacts.add(new Contact(arr.getJSONObject(i)));
        }


    }
}
