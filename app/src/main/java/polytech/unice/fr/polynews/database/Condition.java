package polytech.unice.fr.polynews.database;

import org.json.JSONObject;

/**
 * Created by cesar on 17/04/2016.
 */
public class Condition implements JSONPopulate {
    private int code;
    private int temperature;
    private String description;

    @Override
    public void populate(JSONObject data) {
        code = data.optInt("code");
        temperature= data.optInt("temp");
        description = data.optString("text");

    }

    public int getCode() {
        return code;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

}
