package com.parse.tagteampi;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


import com.parse.ParseQueryAdapter;

/**
 * Created by Reynaldo on 11/21/2014.
*/
public class MainLobbyActivity extends Activity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lobby);

        final ParseQueryAdapter adapter2 = new ParseQueryAdapter(this, "Games");
        adapter2.setTextKey("user");


        list = (ListView) findViewById(R.id.GamesListView);
        list.setAdapter(adapter2);

        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                //Toast.makeText(getApplicationContext(), "You clicked on # " + position, Toast.LENGTH_SHORT).show();

                String gameSelected = adapter2.getItem(position).get("name").toString();


                // go to the selected game
                Intent goToGame = new Intent(MainLobbyActivity.this , InGameActivity.class);
                goToGame.putExtra("gameSelected", gameSelected);
                startActivity(goToGame);
            }
        });



    }
}