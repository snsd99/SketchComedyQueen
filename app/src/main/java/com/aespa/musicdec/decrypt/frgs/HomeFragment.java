package com.aespa.musicdec.decrypt.frgs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aespa.musicdec.R;
import com.xuexiang.xui.widget.dialog.materialdialog.MaterialDialog;
import com.xuexiang.xui.widget.button.roundbutton.RoundButton;
import com.xuexiang.xui.widget.imageview.RadiusImageView;
import com.xuexiang.xui.widget.toast.XToast;

public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //
    private RoundButton roundButton;    // 圆圆的按钮
    private RadiusImageView giselleImgView;// Giselle抽象图片控件
    // 对话框
    private MaterialDialog aboutDialog;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        //  Log.d();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_main, container, false);
    }
    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {
        super.onViewCreated(view, savedInstanceState);
        if (this.aboutDialog == null){
            StringBuilder sb = new StringBuilder();
            sb.append("This App is powered by XUI.")
                    .append("\r\n")
                    .append("https://github.com/xuexiangjys/XUI")
                    .append("\r\n")
                    .append("\r\n")
                    .append("Developed by snsd99(K3R1Na).")
                    .append("\r\n")
                    .append("https://github.com/snsd99")
                    .append("\r\n")
                    .append("We're all fond of aespa.")

            ;
            this.aboutDialog = new MaterialDialog.Builder(getContext())
                    .title("关于")
                    .content(sb.toString())
                    .iconRes(R.drawable.karina_avatar)
                    .positiveText("OK").build();
        }
        this.roundButton = (RoundButton) view.findViewById(R.id.frg_main_roundButton);
        this.roundButton.setOnClickListener(v -> this.aboutDialog.show());
        this.giselleImgView = (RadiusImageView) view.findViewById(R.id.frg_main_radiusImageView);
        this.giselleImgView.setOnClickListener(v -> XToast.normal(requireContext(), "Giselle: What the hell??").show());
    }


}
