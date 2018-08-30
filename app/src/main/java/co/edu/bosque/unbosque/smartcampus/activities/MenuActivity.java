package co.edu.bosque.unbosque.smartcampus.activities;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.widget.ImageButton;

import co.edu.bosque.unbosque.smartcampus.R;


public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int anchoPantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        toolbar.setTitle("INTRODUsssssCCIssÓN");


        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        anchoPantalla = getWindowManager().getDefaultDisplay().getWidth();


        ImageButton button1 = (ImageButton)findViewById(R.id.bmapa);
        Bitmap bitmapImage1 = BitmapFactory.decodeResource(getResources(),R.drawable.mapa);
        Bitmap scaled1 = Bitmap.createScaledBitmap(bitmapImage1,(anchoPantalla-120)/2,(anchoPantalla-120)/2,false);
        button1.setImageBitmap(scaled1);

        ImageButton button2 = (ImageButton)findViewById(R.id.brestaurantes);
        Bitmap bitmapImage2 = BitmapFactory.decodeResource(getResources(),R.drawable.restaurantes);
        Bitmap scaled2 = Bitmap.createScaledBitmap(bitmapImage2,(anchoPantalla-120)/2,(anchoPantalla-120)/2,false);
        button2.setImageBitmap(scaled2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent i = new Intent(getApplicationContext(),ScrollingActivity.class);
             startActivity(i);
            }
        });

        ImageButton button3 = (ImageButton)findViewById(R.id.bcomentarios);
        Bitmap bitmapImage3 = BitmapFactory.decodeResource(getResources(),R.drawable.comenatrios);
        Bitmap scaled3 = Bitmap.createScaledBitmap(bitmapImage3,(anchoPantalla-120)/2,(anchoPantalla-120)/2,false);
        button3.setImageBitmap(scaled3);

        ImageButton button4 = (ImageButton)findViewById(R.id.bcafeteria);
        Bitmap bitmapImage4 = BitmapFactory.decodeResource(getResources(),R.drawable.cafeterias);
        Bitmap scaled4 = Bitmap.createScaledBitmap(bitmapImage4,(anchoPantalla-120)/2,(anchoPantalla-120)/2,false);
        button4.setImageBitmap(scaled4);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean d1o(){
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mapa) {
            // Handle the camera action
        } else if (id == R.id.nav_restaurantes) {

            android.support.v4.app.NotificationCompat.Builder notific = new android.support.v4.app.NotificationCompat.Builder(this)
                    .setContentTitle("¿Tienes hambre?")
                    .setSmallIcon(R.drawable.uni)
                    .setContentText("Mira todos los restaurantes disponibles")
                    .setContentInfo("Restaurantes")
                    .setDefaults(Notification.DEFAULT_ALL);

            Bitmap contactPic = BitmapFactory.decodeResource(this.getResources(),R.drawable.logo);

            Resources res = this.getResources();
            int height = (int) res.getDimension(android.R.dimen.notification_large_icon_height);
            int width = (int) res.getDimension(android.R.dimen.notification_large_icon_width);
            contactPic = Bitmap.createScaledBitmap(contactPic, width, height, false);

            notific.setLargeIcon(contactPic);
            NotificationManager nM = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
            nM.notify(1,notific.build());

        } else if (id == R.id.nav_comentarios) {

        } else if (id == R.id.nav_cafeterias) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
