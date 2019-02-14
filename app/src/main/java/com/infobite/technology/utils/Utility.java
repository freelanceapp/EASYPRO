package com.infobite.technology.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.infobite.technology.R;
import com.infobite.technology.ui.activity.MainActivity;


public class Utility {
    static String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
    private static ProgressDialog dialog;


    public static void toastView(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void setFragment(Fragment fragment, Context ctx, String tag) {
        ((MainActivity) ctx).getSupportFragmentManager().beginTransaction().replace(R.id.home_contents, fragment, tag).commit();
    }

    public static void showLoader(Context ctx) {
        dialog = new ProgressDialog(ctx);
        dialog.setCancelable(true);
        dialog.setMessage("loading..");
        dialog.show();
    }

    public static void hideLoader() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public static boolean emailCheck(String email) {
        if (email.matches(emailPattern)) {
            return true;
        } else {
            return false;
        }
    }


    public static void rateUs(Context ctx) {
        Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + ctx.getPackageName()));
        ctx.startActivity(rateIntent);
    }
}
