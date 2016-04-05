package polytech.unice.fr.polynews.campus;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import polytech.unice.fr.polynews.R;

/**
 * Created by cesar on 02/04/2016.
 */
public class CampusActivity extends Activity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            TextView text = new TextView(this);
            text.setText("hello world, i'm here");
            setContentView(text);
        }

}
