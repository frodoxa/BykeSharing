package com.example.giselamercade.bykesharing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
        boolean success = sharedPref.getBoolean("registered", false);
        sharedPref.getString("username", null);
        sharedPref.getString("password", null);

        if (success) {
                //finish();
                Intent intentBikeList = new Intent(this,BykeSharingListActivity.class);
                startActivity(intentBikeList);
                finish();
            } else {
                Intent intentLogin = new Intent(this, LoginActivity.class);
                startActivity(intentLogin);
                finish();
            }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
