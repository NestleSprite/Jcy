package legend.nestlesprite.jcy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import legend.nestlesprite.jcy.R;
import legend.nestlesprite.jcy.util.ColorUtil;


public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {


    private Context mContext;
    private List<Integer> numbers;


    public GridAdapter(Context mContext, List<Integer> numbers) {
        this.mContext = mContext;
        this.numbers = numbers;


    }


    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_grid, parent, false);
        return new LinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LinearViewHolder holder, final int position) {
        int num = numbers.get(position);

        int color=ColorUtil.getDegreeColor(num);
        holder.grid.setBackgroundColor(color);
        holder.txtValue.setText(""+num);
        holder.txtPosition.setText("传感器 "+(position+1));


    }

    @Override
    public int getItemCount() {
        return numbers.size();

    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout grid;
        private TextView txtValue;
        private TextView txtPosition;


        public LinearViewHolder(View itemView) {
            super(itemView);
            grid = (LinearLayout) itemView.findViewById(R.id.grid);
            txtPosition = (TextView) itemView.findViewById(R.id.txt_position);
            txtValue= (TextView) itemView.findViewById(R.id.txt_value);
        }
    }
}
