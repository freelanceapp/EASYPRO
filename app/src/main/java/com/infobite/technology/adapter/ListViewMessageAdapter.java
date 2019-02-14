package com.infobite.technology.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.modal.MessageList;

import java.util.List;

public class ListViewMessageAdapter extends ArrayAdapter<MessageList> {
    private List<MessageList> messageLists;
    private Context context;
    private View rootview;
    private TextView vendormsg,customermsg;

    public ListViewMessageAdapter(Context context,List<MessageList> messageLists) {
        super(context,R.layout.layout_messages_lv,messageLists);
        this.context = context;
        this.messageLists = messageLists;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        rootview = inflater.inflate(R.layout.layout_messages_lv,null);
        init();
        return rootview;
    }
    private void init(){
      vendormsg =  rootview.findViewById(R.id.tv_vendor_msg);
       customermsg =  rootview.findViewById(R.id.tv_vendor_msg);
       vendormsg.setText(messageLists.size());
       customermsg.setText(messageLists.size());

    }
}
