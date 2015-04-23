package com.trimble.ag.libweather.com.trimble.ag.libweather.forecastio;

/**
 * Created by aaa on 11/4/14.
 */
public class ForecastIOResponse {
    public float latitude;
    public float longitude;
    public String timezone;
    public int offset;

    ForecastIODataPoint currently;
    ForecastIODataBlock minutely;
    ForecastIODataBlock hourly;
    ForecastIODataBlock daily;
    ForecastIOAlert[] alerts;

}
