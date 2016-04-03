package polytech.unice.fr.polynews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import polytech.unice.fr.polynews.adapter.RecyclerViewAdapter;
import polytech.unice.fr.polynews.database.NewsDBHelper;
import polytech.unice.fr.polynews.model.Event;

public class CardViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}
