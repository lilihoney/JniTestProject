package test.jni.up.day.day.com.jnitestproject.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.jni.up.day.day.com.jnitestproject.R;
import test.jni.up.day.day.com.jnitestproject.type.TargetClass;

/**
 * Created on 2017/10/19 14:43.
 *
 * @author xiao qiang
 */

public class TargetAdapter extends RecyclerView.Adapter<TargetAdapter.ViewHolder>{
    private TargetClass[] mData = null;
    private TargetAdapter.OnItemClickListener mOnItemClickListener = null;

    public TargetAdapter(TargetClass[] data){
        mData = data;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //指定holder的动作
        holder.mTextView.setText(mData[position].getName());
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(holder.mTextView, position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.length;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //在此绑定布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.target_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView = null;
        public ViewHolder(View view){
            super(view);
            mTextView = view.findViewById(R.id.tv_item_name);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
