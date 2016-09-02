package com.example.mdd23.myapplication;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class ToastUtil {
    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
