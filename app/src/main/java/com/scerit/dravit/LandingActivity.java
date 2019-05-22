package com.scerit.dravit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LandingActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


    }

    public void logClick (View view)
    {
        Intent myIntent = new Intent(getApplicationContext(), LogInActivity.class);
        // myIntent.putExtra("key", value); //Optional parameters
        LandingActivity.this.startActivity(myIntent);
    }

    public void signClick (View view)
    {
        Intent myIntent = new Intent(getApplicationContext(), SignUpActivity.class);
        // myIntent.putExtra("key", value); //Optional parameters
        LandingActivity.this.startActivity(myIntent);
    }
}
