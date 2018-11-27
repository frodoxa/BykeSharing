package com.example.giselamercade.bykesharing;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddBikeSharingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike_sharing);

        Button afegir = (Button) findViewById(R.id.afegir);
        afegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                // .setAction("Action", null).show();
                View focusView = null;

                TextView newId = (TextView) findViewById(R.id.TextInputLayout);
                String newIdString = newId.getText().toString();

                TextView newBike = (TextView) findViewById(R.id.TextInputEditText);
                String newBikeString = newBike.getText().toString();

                boolean validacio = true;

                if (TextUtils.isEmpty(newIdString)) {
                    newId.setError("El nom de la bicileta no pot estar buit");
                    focusView = newId;
                    validacio = false;
                }

                if (validacio && TextUtils.isEmpty(newBikeString)) {
                    newBike.setError("El detall de la bicileta no pot estar buit");
                    focusView = newBike;
                    validacio = false;
                }

                if(validacio){
                    Intent intent = new Intent(AddBikeSharingActivity.this,BykeSharingListActivity.class);
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra("id", newIdString);
                    intent.putExtra("detail", newBikeString);

                    intent.setType("text/plain");
                    startActivity(intent);
                }else {

                    focusView.requestFocus();
                }



            }
        });



    }
}
