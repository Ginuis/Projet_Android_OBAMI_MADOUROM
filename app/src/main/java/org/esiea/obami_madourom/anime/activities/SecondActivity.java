package org.esiea.obami_madourom.anime.activities;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.esiea.obami_madourom.anime.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.esiea.obami_madourom.anime.R.layout.activity_second;

public class SecondActivity extends AppCompatActivity {

    TextView vs;
    DatePickerDialog dpd;
    NotificationManager notMan;
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(activity_second);

        //Back Button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        vs = (TextView) findViewById(R.id.textbox);
        //Date dialog
        DatePickerDialog.OnDateSetListener odsl = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
                Date date = new Date(i-1900, i1, i2);
                vs.setText(dateFormatter.format(date));
            }
        };
        dpd = new DatePickerDialog(this, odsl, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        //Notification
        builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText(getString(R.string.notif_1));
        builder.setContentTitle(getString(R.string.notif));
        notMan = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }
    // Boutton
    public void doNext(View view){
        startActivity(new Intent(this, ThirdActivity.class));
        notMan.notify(500, builder.build());
    }
    public void doLocate(View view){
        startActivity(new Intent(this, FourthActivity.class));
        notMan.notify(500, builder.build());
    }
    public void doNotif(View view){
        vs.setText("Shops button is used to see the map of specialised shops");
        Toast.makeText(getApplicationContext(),getString(R.string.ms), Toast.LENGTH_SHORT).show();
    }
    public void doNotif1(View view){
        vs.setText("Animes button allows you to see the list of the best mangas");
        Toast.makeText(getApplicationContext(),getString(R.string.mg), Toast.LENGTH_SHORT).show();
    }
    public void doDate(View v) {
        vs.setText(R.string.dat);
        dpd.show();
    }

    // ActionBar
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == android.R.id.home){

            this.finish();
        }

        switch (item.getItemId()){
            case R.id.action_download:
                Toast.makeText(getApplicationContext(),"Downloaded",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_delete:
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_setting:
                Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
