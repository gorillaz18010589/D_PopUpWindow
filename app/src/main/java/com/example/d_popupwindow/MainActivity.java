package com.example.d_popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {
    private LinearLayout lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lin = findViewById(R.id.Line);
        Log.v("hank","onCrate");
    }

    public void testCustomPopupWindow(View view) {
        test();

//        initTopNavigation();
    }

    private void test() {
        PopupWindowUtils popupWindowUtils = new PopupWindowUtils(this, lin, R.layout.top_navigation);
        View layoutView = popupWindowUtils.getLayoutView();
        final Button btn1 = layoutView.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setText("哈摟");
                Log.v("hank", "btn1");
            }
        });
        popupWindowUtils.showLocation(Gravity.TOP);

        AnimationViewUtils.getInstance().initShadow(getWindow());
        StatusBarUtils.setStatusBarColor(this,Color.RED);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


    }

    private void initTopNavigation() {
        View viewNavigation = LinearLayout.inflate(MainActivity.this, R.layout.top_navigation, null);
        PopupWindow popupWindow = new PopupWindow(viewNavigation, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popupWindow.setTouchModal(true);
        }
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        popupWindow.showAtLocation(lin, Gravity.BOTTOM, 0, 0);
    }
}
