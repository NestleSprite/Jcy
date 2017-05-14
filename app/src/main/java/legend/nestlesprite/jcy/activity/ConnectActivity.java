package legend.nestlesprite.jcy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import legend.nestlesprite.jcy.R;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class ConnectActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText("信号强度检测");
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ConnectActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();

            }
        };
        handler.postDelayed(runnable,5000);
    }
}
