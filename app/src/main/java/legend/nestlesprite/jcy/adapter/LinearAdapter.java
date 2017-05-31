package legend.nestlesprite.jcy.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import legend.nestlesprite.jcy.R;
import legend.nestlesprite.jcy.util.ColorUtil;


public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context mContext;
    private List<Integer> numbers;

    public LinearAdapter(Context mContext, List<Integer> numbers) {
        this.mContext = mContext;
        this.numbers = numbers;
    }


    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_liner, parent, false);
        return new LinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LinearViewHolder holder, final int position) {
        final int num = numbers.get(position);
        final int color = ColorUtil.getDegreeColor(num);
        holder.ll.setBackgroundColor(color);
        holder.textView.setText("信号强度： " + num);
        holder.pos.setText("传感器 " + (position + 1));
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View layout = ((Activity) mContext).getLayoutInflater().inflate(R.layout.dialog, null);
                TextView txtNum = (TextView) layout.findViewById(R.id.txt_num);
                TextView txtSignal = (TextView) layout.findViewById(R.id.txt_signal);
                TextView txtStatus = (TextView) layout.findViewById(R.id.txt_status);
                txtNum.setText("传感器编号：" + (position + 1));
                txtSignal.setText("信号强度： " + num);
                if (num <= 50) {
                    txtStatus.setTextColor(((Activity) mContext).getResources().getColor(R.color.red));
                    txtStatus.setText("不合格");
                } else {
                    txtStatus.setTextColor(((Activity) mContext).getResources().getColor(R.color.green));
                    txtStatus.setText("合格");
                }
                AlertDialog dialog = new AlertDialog.Builder(mContext).setView(layout).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout ll;
        private TextView textView;
        private TextView pos;

        public LinearViewHolder(View itemView) {
            super(itemView);
            ll = (RelativeLayout) itemView.findViewById(R.id.ll);
            textView = (TextView) itemView.findViewById(R.id.text);
            pos = (TextView) itemView.findViewById(R.id.txt_position);
        }
    }
}
