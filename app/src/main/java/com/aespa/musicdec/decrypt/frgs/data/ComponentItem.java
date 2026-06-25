package com.aespa.musicdec.decrypt.frgs.data;

import android.view.View;

public class ComponentItem {
    /**
     * 小方块显示的图标，例如酷狗音乐的图标
     */
    public int iconResId;
    /**
     * 小方块显示的标题，例如“酷狗音乐(kgma)”,"酷我音乐(kwm)"
     */
    public String title;
    /**
     * 小方块点击的事件，可以是null
     */
    public View.OnClickListener clickListener;
    public ComponentItem(int iconResId, String title, View.OnClickListener clickListener) {
        this.iconResId = iconResId;
        this.title = title;
        this.clickListener = clickListener;
    }
}
