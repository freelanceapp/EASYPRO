package com.infobite.technology.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.infobite.technology.R;
import com.infobite.technology.adapter.ListViewMessageAdapter;
import com.infobite.technology.modal.MessageList;
import com.infobite.technology.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity {
    private ListViewMessageAdapter listViewAdapter1, listViewAdapter2;
    private ListView vendormessagelist, customermesssagelist;
    private List<MessageList> messagesvendorArraylist = new ArrayList<>();
    private List<MessageList> messagecustomerArraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        vendormessagelist = findViewById(R.id.lv_messages1);
        customermesssagelist = findViewById(R.id.lv_messages2);
       /* messagesvendorArraylist.add(new MessageList("Hii friend how are you?"));
        messagesvendorArraylist.add(new MessageList("I am fine"));*/

        listViewAdapter1 = new ListViewMessageAdapter(mContext, messagesvendorArraylist);
        vendormessagelist.setAdapter(listViewAdapter1);
        listViewAdapter2 = new ListViewMessageAdapter(mContext, messagecustomerArraylist);
        customermesssagelist.setAdapter(listViewAdapter2);
    }
}
