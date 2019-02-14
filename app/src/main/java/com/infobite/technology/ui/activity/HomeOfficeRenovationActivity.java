package com.infobite.technology.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.infobite.technology.R;
import com.infobite.technology.adapter.HomeFragmentAdapter;
import com.infobite.technology.utils.BaseActivity;
import com.infobite.technology.utils.BaseFragment;

public class HomeOfficeRenovationActivity extends BaseActivity implements View.OnClickListener

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_office_renovation);
        findViewById(R.id.btn_view_quote).setOnClickListener(this);
        findViewById(R.id.btn_cencel).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_view_quote:
                Intent intent = new Intent(this,VendorInformationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_cencel:
                finish();

        }
    }
}
