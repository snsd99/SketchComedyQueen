package com.aespa.musicdec;
//
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
//
import com.aespa.musicdec.decrypt.frgs.HomeFragment;
import com.aespa.musicdec.decrypt.frgs.MenuFragment;
import com.aespa.musicdec.decrypt.frgs.ToolsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.aespa.musicdec.databinding.ActivityMainBinding;
//
import com.xuexiang.xui.widget.toast.XToast;

public class MainActivity extends AppCompatActivity {
    // Used to load the 'musicdec' library on application startup.
    static {
        System.loadLibrary("musicdec");
    }
    private ActivityMainBinding binding;
    private BottomNavigationView btmSV; // 底部的导航栏，显示“首页”、“菜单”和“工具”。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Example of a call to a native method
        //TextView tv = binding.textView;
        //tv.setText(stringFromJNI());
        // Btm navi
        this.btmSV = (BottomNavigationView) findViewById(R.id.bottomNav);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new HomeFragment())
                    .commit();
        }
        //
        this.btmSV.setSelectedItemId(R.id.nav_menu);
        // 设置首次选定的
        this.btmSV.setSelectedItemId(R.id.nav_home);
        XToast.normal(getApplicationContext(), "恭喜你用上了这款软件！").show();
        // 切换监听
        btmSV.setOnItemSelectedListener(item -> {
            Fragment selected = null;
            int id = item.getItemId();
            if (id == R.id.nav_menu) {
                selected = new MenuFragment();
            } else if (id == R.id.nav_tools) {
                selected = new ToolsFragment();
            }else{
                selected = new HomeFragment();
            }
            if (selected != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, selected)
                        .commit();
            }
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    /**
     * A native method that is implemented by the 'musicdec' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}