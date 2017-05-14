package legend.nestlesprite.jcy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import legend.nestlesprite.jcy.R;
import legend.nestlesprite.jcy.adapter.GridAdapter;


/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class GridFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Integer> values = new ArrayList<>();
    private GridAdapter mAdapter;
    private TextView txtSensor;
    private List<Integer> positions = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_result, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        txtSensor = (TextView) view.findViewById(R.id.txt_sensors);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(layoutManager);
        for (int i = 0; i < 32; i++) {
            double dVal = Math.random();

            int iVal = (int) (dVal * 100);
            if (iVal < 50)
                positions.add((i + 1));
            values.add(iVal);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < positions.size(); i++) {
            if (i < (positions.size() - 1)) {
                builder.append(positions.get(i) + " , ");
            } else builder.append(positions.get(i) + "");


        }
        txtSensor.setText(builder.toString());
        mAdapter = new GridAdapter(getContext(), values);
        recyclerView.setAdapter(mAdapter);
        return view;
    }
}
