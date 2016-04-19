package polytech.unice.fr.polynews.database;

import org.json.JSONObject;

/**
 * Created by cesar on 17/04/2016.
 */
public class Item implements JSONPopulate {

    private Condition condition;
    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }


    public Condition getCondition() {
        return condition;
    }
}
