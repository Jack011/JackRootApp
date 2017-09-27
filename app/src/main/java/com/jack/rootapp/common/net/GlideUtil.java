package com.jack.rootapp.common.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.youth.banner.loader.ImageLoaderInterface;
import com.jack.rootapp.R;

/**
 * Created by Administrator on 2017-08-11.
 */

public class GlideUtil implements ImageLoaderInterface {


    public static void loadImageView(Context context, String path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .error(R.color.colorGrayeee)           //设置错误图片
                .placeholder(R.color.colorGrayeee)     //设置占位图片
                .centerCrop()
                .into(imageView);
    }

    public static void loadCircleImageView(final Context context, String path, final ImageView imageView) {
        Glide.with(context)
                .load(path)
                .asBitmap()
                .centerCrop()
                .error(R.color.colorGrayeee)
                .into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public void displayImage(Context context, Object path, View imageView) {
        Glide.with(context)
                .load(path)
                .error(R.color.colorGrayeee)           //设置错误图片
                .placeholder(R.color.colorGrayeee)     //设置占位图片
                .centerCrop()
                .into((ImageView) imageView);
    }

    @Override
    public View createImageView(Context context) {
        return new ImageView(context);
    }
}
