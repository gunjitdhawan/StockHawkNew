package com.sam_chordas.android.stockhawk.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sam_chordas.android.stockhawk.service.StockIntentService;

/**
 * Created by gunjit on 21/08/16.
 */
public class StockWidgetProvider extends AppWidgetProvider{

    private static final int CURSOR_LOADER_ID = 0;
    String topShareName = "Loading";
    String topSharePrice = "Loading";
    private Context mContext;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int count = appWidgetIds.length;
        mContext = context;


        Log.e("8888uugj", "onUpdate method called");
        // Get all ids
        ComponentName thisWidget = new ComponentName(context,
                StockWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        // Build the intent to call the service
        Intent intent = new Intent(context,
                StockIntentService.class);
        intent.putExtra("tag", "init");
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);

        // Update the widgets via the service
        context.startService(intent);

    }

}
