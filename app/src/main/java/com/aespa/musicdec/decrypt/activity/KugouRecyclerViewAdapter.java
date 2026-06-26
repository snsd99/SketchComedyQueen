package com.aespa.musicdec.decrypt.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aespa.musicdec.R;

import java.util.List;

/** KugouRecyclerViewAdapter适配器 */
public class KugouRecyclerViewAdapter extends RecyclerView.Adapter<KugouRecyclerViewAdapter.ViewHolder>{
    private final List<KugouViewsItem> itemList;
    public KugouRecyclerViewAdapter(List<KugouViewsItem> itemList) {
        this.itemList = itemList;
    }
    @NonNull
    @Override
    public KugouRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 设置KugouRecyclerViewAdapter的布局文件
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kugou_dec_normal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KugouRecyclerViewAdapter.ViewHolder holder, int position) {
        KugouViewsItem item = itemList.get(position);
       // holder.txt.setText(item.t1Str);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
    // 定义一个内部类 KugouRecyclerViewAdapter.ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.textView);
        }
    }
}
