package polytech.unice.fr.polynews.service;

import android.os.Bundle;
import android.support.annotation.Nullable;

import polytech.unice.fr.polynews.database.Channel;

/**
 * Created by cesar on 17/04/2016.
 */
public interface WeatherServiceCallBak {
    void OnCreate(@Nullable Bundle OnSavedView);

    void serviceSucces(Channel c);
    void serviceFaillure(Exception e);
}
