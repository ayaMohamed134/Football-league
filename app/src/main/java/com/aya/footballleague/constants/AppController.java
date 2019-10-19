package com.aya.footballleague.constants;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

import androidx.multidex.MultiDexApplication;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.aya.footballleague.di.component.DaggerAppComponent;
import com.bumptech.glide.Glide;

import java.util.Objects;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public final class AppController extends MultiDexApplication implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    private RequestQueue requestQueue;
    private static final String TAG = AppController.class.getSimpleName();
    private static AppController controller;
    private ImageLoader imageLoader;
    

    @Override
    public void onCreate() {
        super.onCreate();

       DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        controller = this;

    }


    @Override
    public void onTrimMemory(int level)
    {
        super.onTrimMemory(level);
        Glide.get(this).trimMemory(level);
    }

    public static AppController getInstance(){
        return controller;
    }
    

    private RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
            imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {

                private final LruCache<String, Bitmap>
                        cache = new LruCache<String, Bitmap>(20);
                @Override
                public Bitmap getBitmap(String url) {
                    return cache.get(url);
                }

                @Override
                public void putBitmap(String url, Bitmap bitmap) {
                    cache.put(url, bitmap);
                }
            });
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String tag){
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request){
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void cancelRequest(Objects tag){
        if (requestQueue != null){
            requestQueue.cancelAll(tag);
        }
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
