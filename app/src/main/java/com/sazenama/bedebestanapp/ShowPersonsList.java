package com.sazenama.bedebestanapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sazenama.bedebestanapp.DB.DBHelper;
import com.sazenama.bedebestanapp.Models.Person;


public class ShowPersonsList extends AppCompatActivity {

    class PersonAdapter extends CursorAdapter{

        public PersonAdapter(Cursor c){
            super(ShowPersonsList.this,c);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            Person p = helper.getPerson(cursor);

            int position = cursor.getPosition();
            if(position%2==0){
                view.setBackgroundColor(Color.parseColor("#6BC961"));
            }else{
                view.setBackgroundColor(Color.parseColor("#30BF83"));
            }

            ImageView item_gender=(ImageView) view.findViewById(R.id.item_gender_img);
            TextView item_name=(TextView)view.findViewById(R.id.item_name);
            TextView item_lastName=(TextView)view.findViewById(R.id.item_lastname);

            if(p.getGender()==0){
                item_gender.setImageResource(R.drawable.user_male);
            }else{
                item_gender.setImageResource(R.drawable.user_female);
            }

            item_name.setText(p.getName());
            item_lastName.setText(p.getLastname());
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View newItem=inflater.inflate(R.layout.list_item, parent,false);
            return (newItem);
        }
    }


    DBHelper helper;
    Cursor personsList;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showlist);

        Button btnBack = (Button) findViewById(R.id.back);
        btnBack.setOnClickListener(btnBack_Clicked);

        helper=new DBHelper(this);

        personsList=helper.getAllPersons();
        startManagingCursor(personsList);
        ListView listView=(ListView)findViewById(R.id.persons);
        adapter=new PersonAdapter(personsList);
        listView.setAdapter(adapter);
    }

    View.OnClickListener btnBack_Clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //اکتیویتی فعلی را بسته و به اکتیویتی که آن را فراخوانی نموده بازمیگردد
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.close();
    }


}
