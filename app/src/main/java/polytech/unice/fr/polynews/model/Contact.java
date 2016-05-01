package polytech.unice.fr.polynews.model;

import org.json.JSONObject;

/**
 * Created by cesar on 26/04/2016.
 */
public class Contact {
    String nom;
    String prenom;
    String mail;
    String numeros;

    public Contact(String nom, String prenom, String mail, String numeros) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numeros = numeros;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getNumeros() {
        return numeros;
    }

    public Contact(JSONObject data){
        this.nom = data.optString("nom");
        this.prenom = data.optString("prenom");
        this.mail = data.optString("mail");
        this.numeros = data.optString("numeros");

    }
}
