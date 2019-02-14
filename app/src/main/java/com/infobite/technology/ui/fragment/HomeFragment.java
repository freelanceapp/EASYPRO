package com.infobite.technology.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.adapter.HomeFragmentAdapter;
import com.infobite.technology.constant.Constant;
import com.infobite.technology.modal.TwoVariableList;
import com.infobite.technology.utils.BaseFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.infobite.technology.ui.activity.LoginSignUpActivity.fragmentManager;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private HomeFragmentAdapter homeFragmentAdapter1, homeFragmentAdapter2;
    private View rootview;
    private RecyclerView homerclv1, homerclv2;
    private List<TwoVariableList> homeOfficeArrayList = new ArrayList<>();
    private TextView viewallhome;
    private boolean check = false;
    private LinearLayoutManager lm1;
    private LinearLayoutManager lm2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_home_fragment, null);
        mContext = getActivity();
        init();
        return rootview;
    }

    private void getFragmentHome() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, new HomeFragment2(),
                        Constant.HOME).commit();
    }

    private void init() {
        homerclv1 = rootview.findViewById(R.id.home_rclv1);
        homerclv2 = rootview.findViewById(R.id.home_rclv2);
        viewallhome = rootview.findViewById(R.id.view_all_home);
        viewallhome.setOnClickListener(this);
        homerclv1.setHasFixedSize(true);
        homerclv1.setLayoutManager(new LinearLayoutManager(getContext()));


        homeOfficeArrayList.add(new TwoVariableList(R.drawable.furniture, "Architecture"));
        homeOfficeArrayList.add(new TwoVariableList(R.drawable.furniture, "Architecture"));
        homeOfficeArrayList.add(new TwoVariableList(R.drawable.furniture, "Architecture"));

        homeFragmentAdapter1 = new HomeFragmentAdapter(mContext, homeOfficeArrayList, this);
        lm1 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        homerclv1.setLayoutManager(lm1);
        homerclv1.setItemAnimator(new DefaultItemAnimator());
        homerclv1.setAdapter(homeFragmentAdapter1);

        homeFragmentAdapter2 = new HomeFragmentAdapter(mContext, homeOfficeArrayList, this);
        lm2 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        homerclv2.setLayoutManager(lm2);
        homerclv2.setItemAnimator(new DefaultItemAnimator());
        homerclv2.setAdapter(homeFragmentAdapter2);
    }
    private void onclickviewall(){
        if (check){
            check = false;
             lm1.setOrientation(LinearLayoutManager.HORIZONTAL);
        }else {
            check = true;
            lm1.setOrientation(LinearLayoutManager.VERTICAL);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_all_home:
                onclickviewall();
                break;
        }
    }
}
