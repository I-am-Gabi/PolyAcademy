package polytech.unice.fr.polynews.activity;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.database.Channel;
import polytech.unice.fr.polynews.database.Item;
import polytech.unice.fr.polynews.service.WeatherServiceCallBak;
import polytech.unice.fr.polynews.service.YahooWeatherService;

/**
 * Created by cesar on 17/04/2016.
 */
public class WeatherActivity extends AppCompatActivity implements WeatherServiceCallBak{

    private ImageView imageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;
    private ProgressDialog dialog;

    private YahooWeatherService service;

    protected void OnCreate(Bundle OnSavedView){
        super.onCreate(OnSavedView);
        setContentView(R.layout.layout_weather);

        imageView = (ImageView) findViewById(R.id.imageWeather);
        temperatureTextView = (TextView) findViewById(R.id.temperature);
        conditionTextView = (TextView) findViewById(R.id.condition);
        locationTextView = (TextView) findViewById(R.id.location);
        service = new YahooWeatherService(this);
        service.refreshWeather("austin, TX");
        dialog = new ProgressDialog(this);
        dialog.setMessage("loading...");
        dialog.show();
    }

    @Override
    public void serviceSucces(Channel c) {
        dialog.hide();
        Item item = c.getItem();

        int ressource = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());
        @SuppressWarnings("deprecation")
        Drawable iconDrawable = getResources().getDrawable(ressource);

        imageView.setImageDrawable(iconDrawable);
        temperatureTextView.setText(item.getCondition().getTemperature()+ " "+ c.getUnit().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());

    }

    @Override
    public void serviceFaillure(Exception e) {
        dialog.hide();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
