package com.example.liangmutian.linkscrollmsky;

import android.content.Context;
import android.os.Message;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by lmt on 16/12/20.
 */

public class RelativelayoutBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {
    Context mContext;

    public RelativelayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        mContext = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {

        float maxL = DensityUtil.dip2px(mContext, 150) + DensityUtil.getZhuangtai(mContext);

        Log.d("AAAAAAA", dependency.getY() + "拢共" + DensityUtil.dip2px(mContext, 356) + "toolsbar" + maxL);

        Message message = new Message();

        if (dependency.getY() > 0) {


            float a = ((dependency.getY() - maxL) / (DensityUtil.dip2px(mContext, 356) - maxL));

            Log.d("aaaa", "" + a);
            message.what = (int) (a * 100f);


            if (MyActivity.mHandler != null)
                MyActivity.mHandler.sendMessage(message);
        }
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RelativeLayout child, View dependency) {

        Log.d("BBBBBBB", dependency.getY() + "");
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
