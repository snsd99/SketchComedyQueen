package com.aespa.musicdec.decrypt.frgs.ui;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.aespa.musicdec.decrypt.activity.KugouDecActivity;

/**
 * KugouBlockOnClickListener: 点击事件，点击方块“酷狗音乐”时的事件。
 */
public class KugouBlockOnClickListener implements View.OnClickListener{
    private Activity hostActivity;
    //
    public KugouBlockOnClickListener(Activity hostActivity){
        this.hostActivity = hostActivity;
    }
    @Override
    public void onClick(View v) {
        Log.d("KugouBlockOnClickListener","2222222");
        // TODO: 跳转至新的Activity，让用户选择并解密酷狗的加密文件
        // 以及不能让ui卡死
        Intent it = new Intent(this.hostActivity, KugouDecActivity.class);
        this.hostActivity.startActivity(it);
    }
}
