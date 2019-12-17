package com.zb.basework.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.luck.picture.lib.engine.ImageEngine;

/**
 * Created by zb on 2019/12/17.
 * 描述：图片选择器---图片加载框架(Glide、Picaso随意)
 */
public class GlideEngine implements ImageEngine {
    @Override
    public void loadImage(@NonNull Context context, @NonNull String url, @NonNull ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    @Override
    public void loadFolderImage(@NonNull Context context, @NonNull String url, @NonNull ImageView imageView) {
        Glide.with(context)
                .asBitmap()
                .override(180, 180)
                .centerCrop()
                .sizeMultiplier(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .load(url)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.
                                        create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(8);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @Override
    public void loadAsGifImage(@NonNull Context context, @NonNull String url, @NonNull ImageView imageView) {
        Glide.with(context)
                .asGif()
                .load(url)
                .into(imageView);
    }

    @Override
    public void loadGridImage(@NonNull Context context, @NonNull String url, @NonNull ImageView imageView) {
        Glide.with(context)
                .asBitmap()
                .override(200, 200)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .load(url)
                .into(imageView);
    }
}
