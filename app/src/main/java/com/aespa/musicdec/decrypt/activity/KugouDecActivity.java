package com.aespa.musicdec.decrypt.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aespa.musicdec.R;
import com.xuexiang.xui.widget.layout.linkage.view.LinkageRecyclerView;

/**
 * KugouDecActivity: 酷狗解密的Activity。
 */
public class KugouDecActivity extends AppCompatActivity {
    /** KugouDecActivity中包含的可滚动组件，是一种容器。 */
    private LinkageRecyclerView linkageRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kugou_dec);
        this.linkageRecyclerView = findViewById(R.id.kugouRecyclerView);
    }
}

