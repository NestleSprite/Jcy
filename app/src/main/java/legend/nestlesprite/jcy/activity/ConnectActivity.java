package legend.nestlesprite.jcy.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
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
    private Button button;


    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        rlConnect = (RelativeLayout) findViewById(R.id.rl_connect);
        rlFailure = (RelativeLayout) findViewById(R.id.rl_failure);
        button = (Button) findViewById(R.id.button);

        final BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        txtTitle.setText("信号强度检测");
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ConnectActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();

            }
        };
        if (adapter.isEnabled()) {
            rlConnect.setVisibility(View.VISIBLE);
            rlFailure.setVisibility(View.GONE);
            enableBlueTh(adapter);
            handler.postDelayed(runnable, 5000);
        } else {
            rlConnect.setVisibility(View.GONE);
            rlFailure.setVisibility(View.VISIBLE);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlConnect.setVisibility(View.VISIBLE);
                rlFailure.setVisibility(View.GONE);
                enableBlueTh(adapter);
                handler.postDelayed(runnable, 5000);

            }
        });

    }

    private void enableBlueTh(BluetoothAdapter adapter) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        intentFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {//每扫描到一个设备，系统都会发送此广播。

                    BluetoothDevice scanDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    if (scanDevice == null || scanDevice.getName() == null) return;
                } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                    rlConnect.setVisibility(View.GONE);
                    rlFailure.setVisibility(View.VISIBLE);
                }
            }
        };
        registerReceiver(broadcastReceiver, intentFilter);

    }

}
