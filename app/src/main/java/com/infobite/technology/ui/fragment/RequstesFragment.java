package com.infobite.technology.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infobite.technology.R;
import com.infobite.technology.adapter.RequestFragmentAdapter;
import com.infobite.technology.constant.Constant;
import com.infobite.technology.modal.ThreeVariableList;
import com.infobite.technology.ui.activity.HomeRequirementActivity;
import com.infobite.technology.utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.infobite.technology.ui.activity.LoginSignUpActivity.fragmentManager;

public class RequstesFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView requstrclv1, requestrclv2;
    private View rootview;
    private RequestFragmentAdapter requestAdatper1, requestAdapter2;
    private List<ThreeVariableList> requesArraylist1 = new ArrayList<>();
    private List<ThreeVariableList> requesArraylist2 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.layour_request_fragment, null);
        mContext=getActivity();
        init();
        return rootview;
    }

    private void init() {
        requstrclv1 = rootview.findViewById(R.id.rclv_request_fr1);
        requestrclv2 = rootview.findViewById(R.id.rclv_request_fr2);
        rootview.findViewById(R.id.ll_request_fr1);
        rootview.findViewById(R.id.ll_request_fr2);

        requesArraylist1.add(new ThreeVariableList(R.drawable.furniture, "Architecture", "10 Quotes"));

        requesArraylist2.add(new ThreeVariableList(R.drawable.it_image, "Architecture", "5 Quotes"));
        requesArraylist2.add(new ThreeVariableList(R.drawable.it_image, "Architecture", "25 Quotes"));

        requestAdatper1 = new RequestFragmentAdapter(mContext, requesArraylist1);
        LinearLayoutManager lm1 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        requstrclv1.setLayoutManager(lm1);
        requstrclv1.setItemAnimator(new DefaultItemAnimator());
        requstrclv1.setAdapter(requestAdatper1);

        requestAdapter2 = new RequestFragmentAdapter(mContext, requesArraylist2);
        LinearLayoutManager lm2 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        requestrclv2.setLayoutManager(lm2);
        requestrclv2.setItemAnimator(new DefaultItemAnimator());
        requestrclv2.setAdapter(requestAdapter2);
    }

     /* private void getFragmentHomeOfficeRenovation(){
          fragmentManager
                  .beginTransaction()
                  .replace(R.id.frame_container, new HomeOfficeRenovation(),
                          Constant.HOMEOFFICERENOVATION).commit();
      }*/
    @Override
    public void onClick(View v) {

    }
}
