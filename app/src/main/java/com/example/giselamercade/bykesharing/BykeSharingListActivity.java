package com.example.giselamercade.bykesharing;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.giselamercade.bykesharing.bike.BikeContent;

public class BykeSharingListActivity extends FragmentActivity implements ItemFragment.OnListFragmentInteractionListener {


    MyItemRecyclerViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byke_sharing_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();

                Intent intent = new Intent(BykeSharingListActivity.this,AddBikeSharingActivity.class);
                startActivity(intent);
            }
        });


        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        String idBike = null;
        String newBike = null;

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {

                String sharedText = intent.getStringExtra("id");
                if (sharedText != null) {

                    idBike = sharedText;
                }
                sharedText = intent.getStringExtra("detail");
                if (sharedText != null) {

                    newBike = sharedText;
                }


            }

            if(idBike != null && newBike != null){
                BikeContent.Bike bike = new BikeContent.Bike(idBike,newBike, "");

                ItemFragment itemFragment = (ItemFragment)
                        getSupportFragmentManager().findFragmentById(R.id.article_fragment);

                itemFragment.newBike(bike);
            }
        }


    }

    @Override
    public void onListFragmentInteraction(BikeContent.Bike item) {

    }



}
