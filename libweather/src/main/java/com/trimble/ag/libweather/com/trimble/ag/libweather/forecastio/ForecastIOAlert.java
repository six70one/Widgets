package com.trimble.ag.libweather.com.trimble.ag.libweather.forecastio;

import android.net.Uri;

import java.util.Locale;

/**
 * Created by aaa on 11/4/14.
 */
public class ForecastIOAlert {
    public String title;
    public long expires;
    public String description;
    public Uri alertUri;

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("AlertData:\n");
        b.append(String.format(Locale.US, "   title: %s\n", title));
        b.append(String.format(Locale.US, "   expires: %d\n", expires));
        b.append(String.format(Locale.US, "   description: %s\n", description));
        b.append(String.format(Locale.US, "   alertUri: %s\n", alertUri.toString()));
        return b.toString();
    }
}
