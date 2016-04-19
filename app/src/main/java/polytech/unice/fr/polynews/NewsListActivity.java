package polytech.unice.fr.polynews;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import polytech.unice.fr.polynews.fragment.NewContentFragment;

/**
 * Created by user on 17/04/2016.
 */
public class NewsListActivity extends AppCompatActivity {

    //RecyclerView recyclerView;
   // Button button = null;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fg_newlist);
        //recyclerView = (RecyclerView) findViewById(R.id.nlist);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setHasFixedSize(true);

        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        //recyclerView.setAdapter(adapter);

    }

}
