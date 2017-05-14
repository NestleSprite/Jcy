package legend.nestlesprite.jcy.util;

import android.text.TextUtils;
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

}
