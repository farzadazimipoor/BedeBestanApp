package com.sazenama.bedebestanapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ShowPersonsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showlist);

        Button btnBack = (Button) findViewById(R.id.back);
        btnBack.setOnClickListener(btnBack_Clicked);
    }

    View.OnClickListener btnBack_Clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
