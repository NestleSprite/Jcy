package legend.nestlesprite.jcy.util;

import android.graphics.Color;

/**
 * Created by Administrator on 2017/5/14 0014.
 */

public class ColorUtil {
    public static int getDegreeColor(int num) {
        float totalColor = (255 + 255) / 100;
        int red = 0, green = 0, blue = 0;
        if (num == 0) {
            red = 255;
        } else if ((num > 0) && (num <= 50)) {
            red = 255;
            green = 255 - (int) (totalColor * (50-num));
        } else {

            red = (int) (totalColor * (100-num));
            green = 255;
        }
        return Color.rgb(red, green, blue);
    }

}
