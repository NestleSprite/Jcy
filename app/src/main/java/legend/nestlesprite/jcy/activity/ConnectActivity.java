package legend.nestlesprite.jcy.activity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import legend.nestlesprite.jcy.R;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class ConnectActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle;
    private RelativeLayout rlConnect;
    private RelativeLayout rlFailure;


    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        rlConnect = (RelativeLayout) findViewById(R.id.rl_connect);
        rlFailure = (RelativeLayout) findViewById(R.id.rl_failure);
        BluetoothAdapter adapter=BluetoothAdapter.getDefaultAdapter();
        txtTitle.setText("信号强度检测");
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ConnectActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();

            }
        };
        if(adapter.isEnabled()){
            rlConnect.setVisibility(View.VISIBLE);
            rlFailure.setVisibility(View.GONE);
            handler.postDelayed(runnable, 5000);
        }else{
            rlConnect.setVisibility(View.GONE);
            rlFailure.setVisibility(View.VISIBLE);
        }

    }
}
