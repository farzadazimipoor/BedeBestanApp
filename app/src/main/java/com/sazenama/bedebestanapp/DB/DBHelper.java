package com.sazenama.bedebestanapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sazenama.bedebestanapp.Models.Person;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "bedebestan.db";
    public static final int VERSION = 1;

    public DBHelper(Context context){
        super(context,DBNAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String command = "CREATE TABLE persons (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT , lastname TEXT , gender INTEGER);";
        db.execSQL(command);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int odlVersion, int newVersion) {

    }

    public void insertPerson(Person person){
        ContentValues cv = new ContentValues();

        cv.put("name",person.getName());
        cv.put("lastname",person.getLastname());
        cv.put("gender",person.getGender());

        getWritableDatabase().insert("persons","name",cv);

    }

    public Cursor getAllPersons() {
        return(getReadableDatabase().rawQuery("SELECT _id, name, lastname, gender FROM persons ORDER BY name",null));
    }

    public Person getPerson(Cursor c){
        Person p=new Person();
        p.setName(c.getString(1));
        p.setLastname(c.getString(2));
        p.setGender(c.getInt(3));
        return p;
    }
}
