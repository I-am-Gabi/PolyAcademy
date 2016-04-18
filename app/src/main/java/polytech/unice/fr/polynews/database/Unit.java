package polytech.unice.fr.polynews.database;

import org.json.JSONObject;

/**
 * Created by cesar on 17/04/2016.
 */
public class Unit implements JSONPopulate {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");

    }
}
