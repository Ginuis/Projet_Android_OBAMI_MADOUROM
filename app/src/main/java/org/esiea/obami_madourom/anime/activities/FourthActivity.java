package org.esiea.obami_madourom.anime.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.esiea.obami_madourom.anime.R;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        //Back Button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Button
    public void doMapsKaze(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=MANGARAKE")));
    }

    public void doMapsKana(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Manga Story")));
    }

    public void doMapsTonkam(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Hayaku Shop Manga")));
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
