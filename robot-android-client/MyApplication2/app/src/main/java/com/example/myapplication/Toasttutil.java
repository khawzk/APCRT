package com.example.myapplication;


import android.content.Context;
import android.widget.Toast;

//** 使用这个方法 弹窗可实现短时间多次点击按钮，弹窗只弹一次； 但是不管按哪个按钮首次弹窗会显示APP名称 **//

public class Toasttutil {
    public static Toast mtoast;

    public static void showMsg(Context context, String msg) {
        if (mtoast == null) {
            mtoast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mtoast.setText(msg);
        }
        mtoast.show();

    }
}
