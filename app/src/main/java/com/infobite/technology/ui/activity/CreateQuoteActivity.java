package com.infobite.technology.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.infobite.technology.R;

public class CreateQuoteActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvfaq;
    private  boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quote);

        tvfaq =  findViewById(R.id.tv_faq);
       tvfaq.setOnClickListener(this);
        findViewById(R.id.btn_buy_credits).setOnClickListener(this);

    }

    private void showFaq(){
            if (check){
                check = false;
                tvfaq.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_more, 0);
                findViewById(R.id.ll_faq).setVisibility(View.GONE);
                findViewById(R.id.ll_pkr_code).setVisibility(View.VISIBLE);
            }else {
                check = true;
                tvfaq.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_, 0);
                findViewById(R.id.ll_faq).setVisibility(View.VISIBLE);
                findViewById(R.id.ll_pkr_code).setVisibility(View.GONE);
            }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_faq:
                showFaq();
                break;
        }
    }
}
