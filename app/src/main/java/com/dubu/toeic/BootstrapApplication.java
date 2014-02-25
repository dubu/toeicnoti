

package com.dubu.toeic;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.FROYO;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;

import com.github.kevinsawicki.http.HttpRequest;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import dagger.ObjectGraph;
import static com.dubu.toeic.core.Constants.Http.PARSE_APP_ID;
import static com.dubu.toeic.core.Constants.Http.CLIENT_KEY;


/**
 * toeicnoti application
 */
public class BootstrapApplication extends Application {


    private static BootstrapApplication instance;

    /**
     * Create main application
     */
    public BootstrapApplication() {

        // Disable http.keepAlive on Froyo and below
        if (SDK_INT <= FROYO)
            HttpRequest.keepAlive(false);
    }

    /**
     * Create main application
     *
     * @param context
     */
    public BootstrapApplication(final Context context) {
        this();
        attachBaseContext(context);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, PARSE_APP_ID, CLIENT_KEY);
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        instance = this;

        // Perform injection
        Injector.init(getRootModule(), this);

    }

    private Object getRootModule() {
        return new RootModule();
    }


    /**
     * Create main application
     *
     * @param instrumentation
     */
    public BootstrapApplication(final Instrumentation instrumentation) {
        this();
        attachBaseContext(instrumentation.getTargetContext());
    }

    public static BootstrapApplication getInstance() {
        return instance;
    }
}
