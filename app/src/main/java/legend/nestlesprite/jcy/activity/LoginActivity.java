package legend.nestlesprite.jcy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import legend.nestlesprite.jcy.R;

import static legend.nestlesprite.jcy.util.CommonUtil.showToastTip;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle;
    private EditText editAccount, editPwd, editCompany;
    private Button button;
    private boolean hasAccount;
    private boolean hasPwd;
    private boolean hasCom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        txtTitle.setText("登录");
        editAccount = (EditText) findViewById(R.id.edit_account);
        editPwd = (EditText) findViewById(R.id.edit_pwd);
        editCompany = (EditText) findViewById(R.id.edit_company);
        button = (Button) findViewById(R.id.btn_login);
        button.setEnabled(false);
        button.setAlpha(0.54f);
        editAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String info = s.toString().trim();
                if (!TextUtils.isEmpty(info))
                    hasAccount = true;
                else hasAccount = false;
                enableBtn(hasAccount && hasPwd && hasCom);

            }
        });
        editPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String info = s.toString().trim();
                if (!TextUtils.isEmpty(info))
                    hasPwd = true;
                else hasPwd = false;
                enableBtn(hasAccount && hasPwd && hasCom);

            }
        });
        editCompany.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String info = s.toString().trim();
                if (!TextUtils.isEmpty(info))
                    hasCom = true;
                else hasCom = false;
                enableBtn(hasAccount && hasPwd && hasCom);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

                showToastTip("登录成功");
            }
        });
    }

    private void enableBtn(boolean b) {
        if (b) {
            button.setEnabled(true);
            button.setAlpha(1f);
        } else {
            button.setEnabled(false);
            button.setAlpha(0.54f);
        }
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
