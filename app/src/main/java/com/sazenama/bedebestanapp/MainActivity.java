package com.sazenama.bedebestanapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewPerson = (Button) findViewById(R.id.addnewperson);
        addNewPerson.setOnClickListener(addNewPerson_Clicked);

        Button showList = (Button) findViewById(R.id.showlist);
        showList.setOnClickListener(showList_Clicked);

        Button about = (Button) findViewById(R.id.about);
        about.setOnClickListener(btnAbout_Clicked);
    }

    private View.OnClickListener addNewPerson_Clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,AddActivity.class));
        }
    };

    private View.OnClickListener showList_Clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,ShowPersonsList.class));
        }
    };

    private View.OnClickListener btnAbout_Clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder DialogBuilder = new AlertDialog.Builder(MainActivity.this);

            DialogBuilder.setTitle("About...");
            String htmlMSG="<h1>bedebestan</h1><br/>http://Sazenama.Com";
            DialogBuilder.setMessage(Html.fromHtml(htmlMSG));
            DialogBuilder.setCancelable(true);

            DialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog ad = DialogBuilder.create();
            ad.show();
        }
    };


}
