package com.example.d_popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

public class PopupWindowUtils {
    private PopupWindow ppupWindow;
    private View viewContainer, layoutView;
    private Context context;

    public PopupWindowUtils(Context context, View viewContainer, int layoutId) {
        this.context = context;
        this.viewContainer = viewContainer;
        this.layoutView = LayoutInflater.from(context).inflate(layoutId, null);
        ppupWindow = new PopupWindow(layoutView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        initTouch();
    }


    public View getLayoutView() {
        return layoutView;
    }

    public void showLocation (int gravity) {
        if (this.ppupWindow != null) {
            ppupWindow.showAtLocation(viewContainer, gravity, 0, 0);
        }
    }

    public PopupWindow setTouchModel(boolean touchModel){
        if(ppupWindow != null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                ppupWindow.setTouchModal(touchModel);
            }
        }
        return ppupWindow;
    }

    private void initTouch() {
        this.setTouchModel(true);
        this.ppupWindow.setFocusable(true);
        this.ppupWindow.setOutsideTouchable(true);
        this.ppupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
