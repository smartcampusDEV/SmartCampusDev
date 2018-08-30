package co.edu.bosque.unbosque.smartcampus.addons;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Date;

import co.edu.bosque.unbosque.smartcampus.R;

/**
 * Created by BriterAndres on 17/07/2018.
 */

public class Receptor extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Date date = new Date();

        Date date2 = new Date();
        date2.setHours(14);
        date2.setMinutes(0);
        date2.setSeconds(0);

        int com = date.compareTo(date2);
        if(com<0){
            NotificationCompat.Builder notific = new NotificationCompat.Builder(context)
                    .setContentTitle("¿Tienes hambre?")
                    .setSmallIcon(R.drawable.uni)
                    .setContentText("Mira todos los restaurantes disponibles")
                    .setContentInfo("Restaurantes")
                    .setDefaults(Notification.DEFAULT_ALL);

            Bitmap contactPic = BitmapFactory.decodeResource(context.getResources(),R.drawable.logo);

            Resources res = context.getResources();
            int height = (int) res.getDimension(android.R.dimen.notification_large_icon_height);
            int width = (int) res.getDimension(android.R.dimen.notification_large_icon_width);
            contactPic = Bitmap.createScaledBitmap(contactPic, width, height, false);

            notific.setLargeIcon(contactPic);
            NotificationManager nM = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);


            nM.notify(1,notific.build());
        }

    }
}
