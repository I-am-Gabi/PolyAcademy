package polytech.unice.fr.polynews.database;

import org.json.JSONObject;

/**
 * Created by cesar on 17/04/2016.
 */
public class Channel implements JSONPopulate {
    private Unit unit;
    private Item item;
    @Override
    public void populate(JSONObject data) {
        unit = new Unit();
        unit.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate(data.optJSONObject("item"));
    }

    public Unit getUnit() {
        return unit;
    }

    public Item getItem() {
        return item;
    }
}
