package com.infobite.technology.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.infobite.technology.R;
import com.infobite.technology.utils.BaseActivity;

public class HomeFragmentActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fragment);

        findViewById(R.id.btn_next_que).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next_que:
                Intent intent = new Intent(this,HomeRequirementActivity.class);
                startActivity(intent);
        }
    }
}
