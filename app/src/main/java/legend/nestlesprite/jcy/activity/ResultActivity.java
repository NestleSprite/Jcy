package legend.nestlesprite.jcy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import legend.nestlesprite.jcy.R;
import legend.nestlesprite.jcy.fragment.GridFragment;
import legend.nestlesprite.jcy.fragment.LinearFragment;

/**
 * Created by Administrator on 2017/5/14 0014.
 */

public class ResultActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtTitle;
    private LinearFragment linearFragment;
    private GridFragment gridFragment;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        txtTitle.setText("检测结果");
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        linearFragment = new LinearFragment();
        gridFragment = new GridFragment();
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0)
                    return linearFragment;
                else return gridFragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
    }
}
