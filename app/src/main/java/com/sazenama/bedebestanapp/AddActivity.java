package com.sazenama.bedebestanapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sazenama.bedebestanapp.DB.DBHelper;
import com.sazenama.bedebestanapp.Models.Person;

import java.util.concurrent.ExecutionException;

public class AddActivity extends AppCompatActivity {

    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        Button btnAddandNew = (Button) findViewById(R.id.addAndNew);
        btnAddandNew.setOnClickListener(AddandNew_Clicked);

        Button btnAddandBack = (Button) findViewById(R.id.addAndBack);
        btnAddandBack.setOnClickListener(AddandBack_Clicked);

        helper = new DBHelper(this);
    }

    View.OnClickListener AddandNew_Clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            add();
            clear();
        }
    };

    View.OnClickListener AddandBack_Clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            add();
            finish();
        }
    };

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private void add() {
        Person p = new Person();
        EditText etName = (EditText) findViewById(R.id.name);
        EditText etLastName = (EditText) findViewById(R.id.lastname);
        RadioGroup rgGender = (RadioGroup) findViewById(R.id.item_gender);
        p.setName(etName.getText().toString());
        p.setLastname(etLastName.getText().toString());
        switch (rgGender.getCheckedRadioButtonId()) {
            case R.id.male:
                p.setGender(0);
                break;
            case R.id.female:
                p.setGender(1);
                break;
        }


        if (!isEmpty(etName) && !isEmpty(etLastName)) {
            helper.insertPerson(p);
            String message = "درج شد";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        } else {
            String errmessage = "Please Fill all needed fileds!";
            Toast.makeText(getApplicationContext(), errmessage, Toast.LENGTH_LONG).show();
        }
        
    }

    private void clear() {
        EditText etName = (EditText) findViewById(R.id.name);
        EditText etLastName = (EditText) findViewById(R.id.lastname);
        etName.setText("");
        etLastName.setText("");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.close();
    }
}
