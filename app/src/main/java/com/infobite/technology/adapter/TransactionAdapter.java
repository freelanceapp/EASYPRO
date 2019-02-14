package com.infobite.technology.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.modal.TransactionModal;
import com.infobite.technology.ui.fragment.TransactionsFragment;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHOlder> implements View.OnClickListener{
        private View rootview;
        private Context context;
        private List<TransactionModal> transactionModalsList;

    public TransactionAdapter(Context context, List<TransactionModal> transactionModalsList) {
        this.context = context;
        this.transactionModalsList = transactionModalsList;
    }

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(context);
        rootview = li.inflate(R.layout.layout_rclv_transaction,null);
        return new ViewHOlder(rootview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder viewHOlder, int i) {
        TransactionModal transactionmodalist = transactionModalsList.get(i);

        viewHOlder.invoiceno.setText(transactionmodalist.getInvoiceno());
        viewHOlder.date.setText(transactionmodalist.getDate());
        viewHOlder.packages.setText(transactionmodalist.getPackages());
        viewHOlder.paymentmode.setText(transactionmodalist.getPaymentmethod());
        viewHOlder.imageviewmore.setImageDrawable(context.getResources().getDrawable(transactionmodalist.getViewdetailimage()));
    }

    @Override
    public int getItemCount() {
        return transactionModalsList.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_image_viewmore:

        }
    }

    public  class ViewHOlder extends RecyclerView.ViewHolder{
        private TextView invoiceno,date,packages,paymentmode;
        private ImageView imageviewmore;

        public ViewHOlder(@NonNull final View itemView) {
            super(itemView);
            invoiceno = itemView.findViewById(R.id.tv_invoice_no);
            date = itemView.findViewById(R.id.tv_transaction_date);
            packages = itemView.findViewById(R.id.tv_package);
            paymentmode = itemView.findViewById(R.id.tv_payment_mode);
            imageviewmore = itemView.findViewById(R.id.iv_image_viewmore);
            imageviewmore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.layout_transaction_status);
                    dialog.show();
                    dialog.findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }});
                }});


        }
    }
}
