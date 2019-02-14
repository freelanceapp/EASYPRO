package com.infobite.technology.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.utils.BaseActivity;

public class HomeRequirementActivity extends BaseActivity implements View.OnClickListener

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_requirement);

        ((Button)findViewById(R.id.btn_back_ques)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_next_que)).setBackground(mContext.getResources().getDrawable(R.drawable.transparent_view_background));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_ques:
                finish();
                break;
        }

    }
}
