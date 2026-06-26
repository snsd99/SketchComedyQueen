package com.aespa.musicdec.decrypt.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aespa.musicdec.R;
import com.xuexiang.xui.widget.layout.linkage.view.LinkageRecyclerView;
import java.util.ArrayList;
import java.util.List;
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
        // linkageRecyclerView设置适配器
        List<KugouViewsItem> kugouViewsItems = new ArrayList<>();
        kugouViewsItems.add(new KugouViewsItem(null));
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        linkageRecyclerView.setLayoutManager(layoutManager);
        KugouRecyclerViewAdapter kugouRecyclerViewAdapter = new KugouRecyclerViewAdapter(kugouViewsItems);
        this.linkageRecyclerView.setAdapter(kugouRecyclerViewAdapter);

    }
    // TODO：KugouDecActivity的界面设计需要完成了。
}

