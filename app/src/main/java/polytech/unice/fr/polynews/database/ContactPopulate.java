package polytech.unice.fr.polynews.database;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import polytech.unice.fr.polynews.model.Contact;

/**
 * Created by cesar on 26/04/2016.
 */
public class ContactPopulate  {
    List<Contact> contacts;
    private JsonObject jsonObject;

    public ContactPopulate (String data) {

        this.jsonObject = new JsonParser().parse(data).getAsJsonObject();
        contacts = new ArrayList<>();
        JsonArray companyList = (JsonArray) this.jsonObject.get("identite");


        for (int i = 0; i < companyList.size(); i++) {
            JsonObject tmp = companyList.get(i).getAsJsonObject();
            JsonElement nom = tmp.get("nom");
            JsonElement mail = tmp.get("mail");
            JsonElement numeros = tmp.get("numeros");
            JsonElement prenom = tmp.get("prenom");

            String name = "";
            String first = "";
            String mailed = "";
            String number = "";

            if (nom != null) {
                name = nom.getAsString();
            }
            if (mail != null) {
                mailed = mail.getAsString();
            }
            if (numeros != null) {
                number = numeros.getAsString();
            }
            if (prenom != null) {
                first = prenom.getAsString();
            }
            contacts.add(new Contact(name, first, mailed, number));
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
