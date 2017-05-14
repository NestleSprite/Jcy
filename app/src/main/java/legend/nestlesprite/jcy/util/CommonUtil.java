package legend.nestlesprite.jcy.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import legend.nestlesprite.jcy.core.GenApplication;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class CommonUtil {




    private static Toast mToast;
    public static void showToastTip(String tip){
        if(TextUtils.isEmpty(tip))
            return;
        if(null == mToast){
            mToast = Toast.makeText(GenApplication.getApplication(),tip,Toast.LENGTH_SHORT);
        } else {
            mToast.setText(tip);
        }
        mToast.show();

    }
    public static void startActivity(Activity activity, View view, Class clazz, Bundle bundle) {
        Intent intent = new Intent(activity, clazz);
        if (null != bundle)
            intent.putExtras(bundle);
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeScaleUpAnimation(view,
                        (int) view.getWidth() / 2, (int) view.getHeight() / 2,
                        0, 0);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
