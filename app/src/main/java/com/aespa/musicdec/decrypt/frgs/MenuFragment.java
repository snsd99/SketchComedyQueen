package com.aespa.musicdec.decrypt.frgs;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aespa.musicdec.R;
import com.aespa.musicdec.decrypt.frgs.data.ComponentAdapter;
import com.aespa.musicdec.decrypt.frgs.data.ComponentItem;
import com.aespa.musicdec.decrypt.frgs.ui.KugouBlockOnClickListener;
import com.xuexiang.xui.widget.grouplist.XUIGroupListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.<br/>
 * 菜单Fragment
 */
public class MenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //
    XUIGroupListView mGroupListView;

    public MenuFragment() {
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

        return inflater.inflate(R.layout.frg_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.componentRecyclerView);
        // 每行 3 列
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        List<ComponentItem> list = new ArrayList<>();
        list.add(new ComponentItem(R.drawable.item_icon_kugou, "酷狗音乐(kgma)", new KugouBlockOnClickListener((Activity) requireContext())));
        list.add(new ComponentItem(R.drawable.item_icon_kuwo, "酷我音乐(kwm)", null));
        list.add(new ComponentItem(R.drawable.item_icon_qqmusic, "QQ音乐(qmc等)", null));
        ComponentAdapter adapter = new ComponentAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}