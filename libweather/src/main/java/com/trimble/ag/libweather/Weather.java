package com.trimble.ag.libweather;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.trimble.ag.libweather.com.trimble.ag.libweather.forecastio.ForecastIORequest;
import com.trimble.ag.libweather.com.trimble.ag.libweather.forecastio.ForecastIOResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by aaa on 10/27/14.
 */
public class Weather {

    private static final Gson g = new Gson();
    private String mAPIKey;
    private DataSource mSource;

    public Weather(String apikey, DataSource source) {
        if (apikey == null) {
            throw new RuntimeException("You must supply an API key for your service");
        }
        mAPIKey = apikey;
        mSource = source;
    }

    public void fioTest1(Context ctx) throws Exception {
        if (mSource != DataSource.ForecastIO) {
            throw new Exception("Unsupported data source for this test");
        }
        String jsonResponse1;

        AssetManager am = ctx.getAssets();
        BufferedReader br = new BufferedReader(new InputStreamReader(am.open("1.json")));
        StringBuilder b = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            b.append(line);
        }
        jsonResponse1 = b.toString();
        ForecastIOResponse rsp = g.fromJson(jsonResponse1, ForecastIOResponse.class);
        Log.i("D", rsp.toString());
    }

    public void fioOnlineTest1(Context ctx) throws Exception {
        if (mSource != DataSource.ForecastIO) {
            throw new Exception("Unsupported data source for this test");
        }

        ForecastIORequest rq = new ForecastIORequest.Builder(mAPIKey, 0.0d, 0.0d).build();
        rq.d(ctx);
    }

    public enum DataSource {
        ForecastIO,
        Wunderground
    }
}
