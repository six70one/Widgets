package com.trimble.ag.libweather.com.trimble.ag.libweather.forecastio;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.Locale;

/**
 * Created by aaa on 11/5/14.
 */
public class ForecastIORequest {
    private final String mAPIkey;
    private final double latitude;  // decimal degrees, probably want %.8f precision
    private final double longitude;
    //units
    //exclude
    //extend-hourly
    //lang
    AsyncHttpClient httpClient = new AsyncHttpClient();
    private String TAG = ForecastIORequest.class.getSimpleName();
    public AsyncHttpResponseHandler responseHandler = new AsyncHttpResponseHandler() {

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            debugHeaders(TAG, headers);
            Log.d(TAG, String.format(Locale.US, "Return Status Code: %d", statusCode));
            Log.d(TAG, String.format(Locale.US, "Return response: %d", new String(responseBody)));
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            debugHeaders(TAG, headers);
            Log.e(TAG, String.format(Locale.US, "Return Status Code: %d", statusCode));
        }


        private final void debugHeaders(String TAG, Header[] headers) {
            if (headers != null) {
                Log.d(TAG, "Return Headers:");
                for (Header h : headers) {
                    String _h = String.format(Locale.US, "%s : %s", h.getName(), h.getValue());
                    Log.d(TAG, _h);
                }

            }
        }
    };

    private ForecastIORequest(Builder b) {
        this.mAPIkey = b.mAPIkey;
        this.latitude = b.latitude;
        this.longitude = b.longitude;


    }

    public void d(Context ctx) {
        Log.i(TAG, "running get");
        httpClient.get("https://api.forecast.io/forecast/APIKEY/37.8267,-122.423", this.responseHandler);
        Log.i(TAG, "done got getted");
    }

    public static class Builder {
        private final String mAPIkey;
        private final double latitude;
        private final double longitude;

        public Builder(String apiKey, double latitude, double longitude) {
            this.mAPIkey = apiKey;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public ForecastIORequest build()
        {
            return new ForecastIORequest(this);
        }
    }


}
