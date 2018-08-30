package co.edu.bosque.unbosque.smartcampus.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

import co.edu.bosque.unbosque.smartcampus.R;
import co.edu.bosque.unbosque.smartcampus.addons.Receptor;

public class MainActivity extends AppCompatActivity {

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);

        Intent _myIntent = new Intent(this, Receptor.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, _myIntent, 0);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000*60*60*24, pendingIntent);

    }

    public void iniciarSesion(View v){
        Intent i = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(i);
    }




}
