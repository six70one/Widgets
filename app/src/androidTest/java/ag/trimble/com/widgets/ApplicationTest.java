package ag.trimble.com.widgets;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.trimble.ag.libweather.Weather;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private Application mApplication;

    public ApplicationTest() {
        super(Application.class);
    }
    protected void setUp() throws Exception
    {
        super.setUp();

        createApplication();
        mApplication = getApplication();
    }

    @Override
    protected void runTest() throws Throwable {
        super.runTest();
        Weather w = new Weather("APIKEY", Weather.DataSource.ForecastIO);
        w.fioTest1(mApplication);
        w.fioOnlineTest1(mApplication);
    }
}