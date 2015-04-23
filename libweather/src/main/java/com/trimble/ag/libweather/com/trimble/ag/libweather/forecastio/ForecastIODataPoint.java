package com.trimble.ag.libweather.com.trimble.ag.libweather.forecastio;

/**
 * Created by aaa on 11/4/14.
 */
public class ForecastIODataPoint {
    public long time; // unix time seconds
    public String summary;
    public String icon;
    public long sunriseTime;
    public long sunsetTime;
    public Float moonPhase;
    public Float nearestStormDistance;
    public Float nearestStormBearing;
    public Float precipIntensity;
    public Float precipIntensityMax;
    public long precipIntensityMaxTime;
    public Float precipProbability;
    public String precipType;
    public Float precipAccumulation;
    public Float temperature;
    public Float apparentTemperature;
    public Float temperatureMin;
    public Float temperatureMax;
    public long temperatureMinTime;
    public long temperatureMaxTime;
    public Float apparentTemperatureMin;
    public Float apparentTemperatureMax;
    public long apparentTemperatureMinTime;
    public long apparentTemperatureMaxTime;
    public Float dewPoint;
    public Float windSpeed;
    public Short windBearing;
    public Float cloudCover;
    public Float humidity;
    public Float pressure;
    public Float visibility;
    public Float ozone;

}
