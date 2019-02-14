package com.infobite.technology.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infobite.technology.R;
import com.infobite.technology.adapter.HomeFragmentAdapter;
import com.infobite.technology.adapter.MessagerFragmentAdapter;
import com.infobite.technology.adapter.RequestFragmentAdapter;
import com.infobite.technology.modal.MessageFragmentModal;
import com.infobite.technology.modal.ThreeVariableList;
import com.infobite.technology.utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends BaseFragment implements View.OnClickListener {
    private MessagerFragmentAdapter messageAdapter;
    private View rootview;
    private RecyclerView frmessagerclv;
    private List<MessageFragmentModal> messagePersonList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_messages_fragment,null);
        init();
        return rootview;
    }

    private void init() {
        mContext = getActivity();
        frmessagerclv = rootview.findViewById(R.id.rclv_message_fr);

        messagePersonList.add(new MessageFragmentModal(R.drawable.image_profile,"person name","date time"));
        messagePersonList.add(new MessageFragmentModal(R.drawable.image_profile,"person name","date time"));
        messagePersonList.add(new MessageFragmentModal(R.drawable.image_profile,"person name","date time"));

        frmessagerclv.setHasFixedSize(true);
        frmessagerclv.setLayoutManager(new LinearLayoutManager(mContext));

        messageAdapter = new MessagerFragmentAdapter(getActivity().getApplicationContext(),messagePersonList,this);
        LinearLayoutManager lm1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        frmessagerclv.setLayoutManager(lm1);
        frmessagerclv.setItemAnimator(new DefaultItemAnimator());
        frmessagerclv.setAdapter(messageAdapter);

    }

    @Override
    public void onClick(View v) {

    }
}
