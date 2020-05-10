package com.kelompok.worklist.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.kelompok.worklist.R;
import com.kelompok.worklist.activity.MainActivity;
import com.kelompok.worklist.database.DatabaseHelper;


public class CounterWidgetProvider extends AppWidgetProvider {


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        ComponentName thisWidget = new ComponentName(context, CounterWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

//        for (int i = 0; i < appWidgetIds.length; i++) {
        for (int widgetId : allWidgetIds) {

            RemoteViews widget = new RemoteViews(context.getPackageName(), R.layout.widget_counter_layout);

            //counter
            DatabaseHelper mDatabaseHelper = new DatabaseHelper(context);
            int count = mDatabaseHelper.getTodayTaskCount();
            Log.e("Count : ", "" + count);

            if (count > 0) {
                String strCount = String.valueOf(count);
                widget.setViewVisibility(R.id.widgetCounterLayout, View.VISIBLE);
                widget.setTextViewText(R.id.txtWidgetCounter, strCount);
            } else {
                widget.setViewVisibility(R.id.widgetCounterLayout, View.GONE);
            }

            //click event
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

            PendingIntent clickPendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            widget.setOnClickPendingIntent(R.id.widgetIconCounter, clickPendingIntent);

            appWidgetManager.updateAppWidget(widgetId, widget);
        }

    }
}
