package polytech.unice.fr.polynews.service;

import android.net.Uri;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import polytech.unice.fr.polynews.database.Channel;

/**
 * Created by cesar on 17/04/2016.
 */
public class YahooWeatherService {
    private WeatherServiceCallBak serviceCallBak;
    protected  String location;

    private Exception error;


    public YahooWeatherService(WeatherServiceCallBak serviceCallBak) {
        this.serviceCallBak = serviceCallBak;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public Exception getError() {
        return error;
    }

    public void refreshWeather(String l){
        this.location = l;
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")", params[0]);
               String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));

                try {
                    URL url = new URL(endpoint);

                    URLConnection connection = url.openConnection();

                    InputStream inputStream = connection.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    StringBuilder result = new StringBuilder();
                    String line;

                    while( (line = reader.readLine()) != null){
                        result.append(line);
                    }
                    return result.toString();

                } catch (Exception e) {
                    error = e;
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String s) {
                if (s == null && error != null){
                    serviceCallBak.serviceFaillure(error);
                    return;
                }
                try {
                    JSONObject data = new JSONObject(s);


                    JSONObject query = data.getJSONObject("query");
                    int count = query.optInt("count");


                    if (count == 0){
                        serviceCallBak.serviceFaillure(new Exception("erreur saisie de ville"));
                        return;
                    }

                    Channel channel = new Channel();
                    channel.populate(query.optJSONObject("results").optJSONObject("channel"));
                    serviceCallBak.serviceSucces(channel);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }.execute(l);
    }
}
