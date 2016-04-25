package polytech.unice.fr.polynews.service;

import polytech.unice.fr.polynews.database.Channel;

/**
 * Created by cesar on 17/04/2016.
 */
public interface WeatherServiceCallBak {
    void serviceSucces(Channel c);
    void serviceFaillure(Exception e);
}
