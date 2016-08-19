package com.cloudfit_tech.cloudfitc.activity.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cloudfit_tech.cloudfitc.R;


/**
 * 项目名称：CloudFitB
 * 类描述：自定义头像+性别
 * 创建人：Terry
 * 创建时间：2016/5/11 15:06
 * 修改人：Terry
 * 修改时间：2016/5/11 15:06
 * 修改备注：
 */
public class HeadSexImage extends RelativeLayout {


    private CircleImageView headView;
    private ImageView sexView;

    public HeadSexImage(Context context) {
        super(context);
    }

    public HeadSexImage(Context context, AttributeSet attrs) {
        super(context, attrs);

        View view = LayoutInflater.from(context).inflate(R.layout.custom_head_sex, null, false);
        headView = (CircleImageView) view.findViewById(R.id.custom_head_civ);
        sexView = (ImageView) view.findViewById(R.id.custom_sex_iv);
        addView(view);

    }

    public HeadSexImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setHeadViewImage(Drawable drawable) {
        headView.setImageDrawable(drawable);
    }

    public void setHeadViewImage(int i) {
        headView.setImageResource(i);
    }

    public void setHeadViewImage(Bitmap bitmap) {
        headView.setImageBitmap(bitmap);
    }


    /**
     * 设置性别图片
     *
     * @param bool true显示女 ，false 显示男
     */
    public void setSexView(boolean bool) {
        if (bool) {
            sexView.setBackgroundResource(R.drawable.head_sex_female);
        } else {
            sexView.setBackgroundResource(R.drawable.head_sex_male);
        }
    }


}
