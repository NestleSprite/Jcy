package legend.nestlesprite.jcy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

import legend.nestlesprite.jcy.R;

import static legend.nestlesprite.jcy.util.CommonUtil.showToastTip;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle;
    private LinearLayout llSignal;
    private LinearLayout llData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        llSignal = (LinearLayout) findViewById(R.id.ll_signal);
        llData = (LinearLayout) findViewById(R.id.ll_data);
        txtTitle.setText("织物瑕疵监测仪");
        llData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConnectActivity.class));
            }
        });
        llSignal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DataActivity.class));

            }
        });
    }

    private static long currentTime = 0l;
    private static long lastTime = 0l;

    @Override
    public void onBackPressed() {

        currentTime = new Date().getTime();
        if (currentTime - lastTime < 2000) {
            finish();
        }
        lastTime = currentTime;
        showToastTip("再按一次退出");

    }
}
