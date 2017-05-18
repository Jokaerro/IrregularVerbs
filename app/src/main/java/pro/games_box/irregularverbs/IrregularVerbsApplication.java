package pro.games_box.irregularverbs;

import android.app.Application;
import android.content.Context;

/**
 * Created by Tesla on 18.05.2017.
 */

public class IrregularVerbsApplication extends Application {
    private static IrregularVerbsApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static IrregularVerbsApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return getInstance().getApplicationContext();
    }
}
