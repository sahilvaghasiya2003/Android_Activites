package com.example.databasesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    private static final String DB_name = "Mydatabase";
    private static final int DB_vsrsion = 1;
    private static final String Table_name = "my_courses";
    private static final String ID_COL = "my_courses";
    private static final String Name_COL = "name";
    private static final String Ph_COL = "Phone";
    private static final String Email_COL = "email";
    private static final String Password_COL = "password";


    public MyDatabase(Context context) {
        super(context, DB_name, null, DB_vsrsion);
    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "Create Table "+Table_name +"(" +ID_COL +"INTEGER PRIMARY KEY,"
                + Name_COL + " TEXT,"
                + Ph_COL + " int,"
                + Email_COL + " TEXT,"
                + Password_COL + " TEXT)";
        db.execSQL(query);
    }



//  ***************** ADD DATA TO TABLE(DB)  ************************8
    public void addNewCourse(String name, String Ph_No, String Email, String Pwd) {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Name_COL, name);
        values.put(Ph_COL, Ph_No);
        values.put(Email_COL, Email);
        values.put(Password_COL, Pwd);

        db.insert(Table_name,null,values);
//        db.close();
    }


//******************* FETCH DATA FROM TABLE(DB)  ******************

    public ArrayList<ContactModel> fetchData(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+Table_name,null);
        ArrayList<ContactModel> arrayList = new ArrayList<>();

        while (cursor.moveToNext()){

            ContactModel contactModel = new ContactModel();

            contactModel.name = cursor.getString(1);
            contactModel.phone_no = cursor.getString(2);
            contactModel.email = cursor.getString(3);
            contactModel.pwd = cursor.getString(4);


            arrayList.add(contactModel);

        }
        return arrayList;
    }


    //******************* UPDATE DATA FROM TABLE(DB)  ******************


    public void updateContact(ContactModel contactModel){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(Password_COL, contactModel.pwd);
        db.update(Table_name,cv, Ph_COL+ " = "+contactModel.phone_no,null );


    }

    //******************* DELETE DATA FROM TABLE(DB)  ******************


    public void deleteContact(ContactModel contactModel){

        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(Table_name,Password_COL+ " = ?",new String[]{contactModel.pwd});


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db);
    }
}
