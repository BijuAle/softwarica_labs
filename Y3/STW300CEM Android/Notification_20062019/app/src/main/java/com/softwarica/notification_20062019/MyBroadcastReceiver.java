package com.softwarica.notification_20062019;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = MyBroadcastReceiver.class.getSimpleName();
    private static final String CHANNEL_ID = "MY_NOTIFICATION";
    private Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG, "onReceive()");
        mContext = context;
        boolean isAirplaneMode = intent.getBooleanExtra("state", false);
        Log.v(TAG, String.valueOf(isAirplaneMode));
        if (isAirplaneMode) {
            Toast.makeText(context, "Airplane mode on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Airplane mode off", Toast.LENGTH_SHORT).show();
        }

        showNotification(isAirplaneMode);
    }

    public void showNotification(boolean isAirplaneMode) {

        //1. create intent that respond to notification tap
        Intent intent = new Intent(mContext, TestThisActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);

        //2. Create the NotificationChannel, but only on API 26+ because
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "notification_title";
            String description = "notification_text";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = mContext.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            // 3. create content for notification
            NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext,
                    CHANNEL_ID)
                    .setSmallIcon(android.R.drawable.ic_btn_speak_now)
                    .setContentTitle("notification title")
                    .setContentText("notification text")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent);

            //4. show notification
            NotificationManagerCompat nm = NotificationManagerCompat.from(mContext);
            // notificationId is a unique int for each notification that you must define
            nm.notify(7001, builder.build()); // id can be timestamp to skip overriding of notification.
        }
    }
}