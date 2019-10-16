package com.aya.footballleague.utils;

import android.content.Context;
import android.net.Uri;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


/**
 * Created by aya mohamed on 08/02/18.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }
    

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

}
