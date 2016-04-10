package polytech.unice.fr.polynews;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.campus.FragmentCampus;

/**
 * Created by cesar on 05/04/2016.
 */
public class ButtonActivity extends Activity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.layout_describe_project);
        final Button button = (Button) findViewById(R.id.templier);
        CharSequence name = button.getText();
        TextView t = (TextView) findViewById(R.id.Title_describe_project);
        t.setText("LES TEMPLIERS");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_card_view);
            }
        });
    }
}
