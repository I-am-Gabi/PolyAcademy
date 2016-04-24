package polytech.unice.fr.polynews.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

/**
 * Created by cesar on 20/04/2016.
 */
public class ButtonAdapter extends ArrayAdapter<Button> {
    public ButtonAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ButtonAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ButtonAdapter(Context context, int resource, Button[] objects) {
        super(context, resource, objects);
    }

    public ButtonAdapter(Context context, int resource, int textViewResourceId, Button[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ButtonAdapter(Context context, int resource, List<Button> objects) {
        super(context, resource, objects);
    }

    public ButtonAdapter(Context context, int resource, int textViewResourceId, List<Button> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
