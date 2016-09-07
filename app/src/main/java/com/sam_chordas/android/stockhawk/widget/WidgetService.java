package com.sam_chordas.android.stockhawk.widget;

/**
 * Created by gunjit on 03/09/16.
 */

import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViewsService;

public class WidgetService extends RemoteViewsService {

    public WidgetService() {
        super();
        Log.e("WidgetService", "cons");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("WidgetService", "onBind");
        return super.onBind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("WidgetService", "onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("WidgetService", "onstart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("WidgetService", "onstartcommand");

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("WidgetService", "ondes");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("WidgetService", "onConfig");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e("WidgetService", "onLowMem");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);Log.e("WidgetService", "onTrim");

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("WidgetService", "onUnbind");
        return super.onUnbind(intent);

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e("WidgetService", "onrebind");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.e("WidgetService", "onTaskRem");
    }

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Log.e("--", "RemoteViewsFactory");
        WidgetDataProvider dataProvider = new WidgetDataProvider(this.
                getApplicationContext(), intent);
        return dataProvider;
    }
}
