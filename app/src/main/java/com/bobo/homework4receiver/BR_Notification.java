package com.bobo.homework4receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

/**
 * Created by User on 2017/4/25.
 */

public class BR_Notification extends BroadcastReceiver {
    static int id = 7000;
    public static final String KEY_MSG = "KEY_MSG";
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra(KEY_MSG);
        Intent note = new Intent();
        note.setClass(context, ActivityNotification.class);
        note.putExtra(KEY_MSG, message);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,note,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = null;
        notification = newNotification(context, pendingIntent, "messaage:", message);
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id++, notification);
    }

    private Notification newNotification(Context context, PendingIntent pendingIntent, String s, String message) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(s+message);
        builder.setContentText("Hello");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setWhen(System.currentTimeMillis());
        Notification notification = builder.build();
        return notification;
    }
}
