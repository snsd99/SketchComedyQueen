package com.aespa.musicdec.decrypt.frgs.data;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aespa.musicdec.R;

import java.util.List;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ViewHolder> {

    /**
     * List<ComponentItem>：每个小方块儿，元素是ComponentItem
     */
    private final List<ComponentItem> itemList;
    public ComponentAdapter(List<ComponentItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item_component.xml是每个小方块的样式
        // 设置每个小方块的样式，都是上面图标，下面文字。
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_component, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 获取点击的方块对象
        ComponentItem item = itemList.get(position);
        holder.icon.setImageResource(item.iconResId);
        holder.title.setText(item.title);
        // 点击事件设置
        holder.itemView.setOnClickListener(item.clickListener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
    /** 定义的内部类ComponentAdapter.ViewHolder */
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.itemIcon);
            title = itemView.findViewById(R.id.itemTitle);
        }
    }
}