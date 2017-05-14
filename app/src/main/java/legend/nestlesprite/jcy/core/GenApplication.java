package legend.nestlesprite.jcy.core;

import android.app.Application;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class GenApplication extends Application {
    private static Application sApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;


    }


    public static Application getApplication() {
        return sApplication;
    }


}
