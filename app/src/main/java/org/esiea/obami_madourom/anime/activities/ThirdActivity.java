package org.esiea.obami_madourom.anime.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.esiea.obami_madourom.anime.R;
import org.esiea.obami_madourom.anime.adapters.RecyclerViewAdapter;
import org.esiea.obami_madourom.anime.model.Animes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Animes> lstAnimes;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        lstAnimes = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }


    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null ;

                for(int i = 0; i < response.length() ; i++ ) {


                    try {

                        jsonObject = response.getJSONObject(i);
                        Animes animes = new Animes();
                        animes.setName(jsonObject.getString("name"));
                        animes.setDescription(jsonObject.getString("description"));
                        animes.setRating(jsonObject.getString("Rating"));
                        animes.setCategorie(jsonObject.getString("categorie"));
                        animes.setNbre_episode(jsonObject.getInt("episode"));
                        animes.setStudio(jsonObject.getString("studio"));
                        animes.setImage_url(jsonObject.getString("img"));
                        lstAnimes.add(animes);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                setuprecyclerview(lstAnimes);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error){

            }
        });


        requestQueue = Volley.newRequestQueue(ThirdActivity.this);
        requestQueue.add(request);

    }

    private void setuprecyclerview(List<Animes> lstAnimes) {

        RecyclerViewAdapter myadaper = new RecyclerViewAdapter(this,lstAnimes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Back Button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        recyclerView.setAdapter(myadaper);
        Toast.makeText(getApplicationContext(),getString(R.string.ml), Toast.LENGTH_SHORT).show();

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
