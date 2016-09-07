package com.sam_chordas.android.stockhawk.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sam_chordas.android.stockhawk.service.StockIntentService;

/**
 * Created by gunjit on 21/08/16.
 */
public class StockWidgetProvider extends AppWidgetProvider{

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.e("8888uugj", "onUpdate method called");
//        ComponentName thisWidget = new ComponentName(context,
//                StockWidgetProvider.class);
        //int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

    //     Build the intent to call the service
        Intent intent = new Intent(context,
                StockIntentService.class);
        intent.putExtra("tag", "init");
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        // Update the widgets via the service
        context.startService(intent);

//        Log.e("appWidgetIds", appWidgetIds + "---");
//
//        for (int appWidgetId : appWidgetIds) {
//            Log.e("appWidgetId -- -", appWidgetId + "---");
//
//            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
//                    R.layout.widget_layout);
////                    remoteViews.setTextViewText(R.id.stock_name,
////                            String.valueOf(stockName));
////
////                    remoteViews.setTextViewText(R.id.stock_price,
////                            String.valueOf(stockPrice));
//
//            Intent serviceIntent = new Intent(context, StockIntentService.class);
//            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
//            serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME))); // embed extras so they don't get ignored
//            remoteViews.setRemoteAdapter(R.id.widgetCollectionList, serviceIntent);
//            remoteViews.setEmptyView(R.id.widgetCollectionList, R.id.stackWidgetEmptyView);
//            //context.startService(serviceIntent);
//
//            // set intent for item click (opens main activity)
//            Intent viewIntent = new Intent(context, MyStocksActivity.class);
//            //viewIntent.setAction(MyStocksActivity.ACTION_VIEW);
//            viewIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
//            viewIntent.setData(Uri.parse(viewIntent.toUri(Intent.URI_INTENT_SCHEME)));
//
//            PendingIntent viewPendingIntent = PendingIntent.getActivity(context, 0, viewIntent, 0);
//            remoteViews.setPendingIntentTemplate(R.id.stackWidgetView, viewPendingIntent);
//
//            // update widget
//            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
//            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.stackWidgetView);
//        }

//        for (int widgetId : allWidgetIds) {
//
//            RemoteViews remoteViews = initViews(context, appWidgetManager, widgetId);
//

//            Intent clickIntent = new Intent(context.getApplicationContext(),
//                    StockWidgetProvider.class);
//
//            clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
//            clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,
//                    allWidgetIds);
//
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(context.
//                            getApplicationContext(), 0, clickIntent,
//                    PendingIntent.FLAG_UPDATE_CURRENT);
//            remoteViews.setOnClickPendingIntent(R.id.widgetCollectionList, pendingIntent);
//
//            Log.e("--", "befUp");
//            appWidgetManager.updateAppWidget(widgetId, remoteViews);

 //       }
        super.onUpdate(context, appWidgetManager, appWidgetIds);

}


}
