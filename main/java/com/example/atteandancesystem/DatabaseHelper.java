package com.example.atteandancesystem;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DkteStudent3.db";
    public static final String TABLE_NAME = "LoginDetails";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "PASSD";
    public static final String COL_5 = "CATEGORY";
    public static final String TABLE_NAME1 = "StudentDetails";
    public static final String COL_11 = "ID";
    public static final String COL_22 = "SNAME";
    public static final String COL_33 = "SEMAIL";
    public static final String COL_44 = "PEMAIL";
    public static final String COL_55 = "IURL";
    public static final String COL_66 = "YEAR";
    public static final String TABLE_NAME11 = "TimeTable";
    public static final String COL_111 = "ID";
    public static final String COL_222 = "DAY";
    public static final String COL_333 = "TIME";
    public static final String COL_444 = "YEAR";
    public static final String COL_555 = "SUBJECT";
    public static final String COL_666 = "TEACHER";
    public static final String COL_777 = "KIND";
    public static final String TABLE_NAME111 = "ATTENDANCE";
    public static final String COL_1111 = "ID";
    public static final String COL_2222 = "DAY";
    public static final String COL_3333 = "TIME";
    public static final String COL_4444 = "YEAR";
    public static final String COL_5555 = "SUBJECT";
    public static final String COL_6666 = "DATE";
    public static final String COL_7777 = "ATTEND";
    public static final String COL_8888="NAME";

    public static final String TABLE_NAME1111 = "EVENT";
    public static final String COL_11111 = "ID";
    public static final String COL_22222 = "DATE";
    public static final String COL_33333 = "EVENT";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,PASSD TEXT,CATEGORY TEXT)");
        db.execSQL("create table " + TABLE_NAME1 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,SNAME TEXT,SEMAIL TEXT,PEMAIL TEXT,IURL TEXT,YEAR TEXT)");
        db.execSQL("create table " + TABLE_NAME11 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DAY TEXT,TIME TEXT,YEAR TEXT,SUBJECT TEXT,TEACHER TEXT,KIND TEXT)");
        db.execSQL("create table " + TABLE_NAME111 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DAY TEXT,TIME TEXT,YEAR TEXT,SUBJECT TEXT,DATE TEXT,ATTEND TEXT,NAME TEXT)");
        db.execSQL("create table " + TABLE_NAME1111 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,EVENT TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public boolean insertData(String name,String email,String pass,String cat) {
        boolean res;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,email);
        contentValues.put(COL_4,pass);
        contentValues.put(COL_5,cat);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            res=false;
        else
            res=true;
       //db.insert(TABLE_NAME,null,contentValues);
       db.close();
       return  res;
    }

    public boolean insertData1(String name,String email,String pemail,String url,String yr) {
        boolean res;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_22,name);
        contentValues.put(COL_33,email);
        contentValues.put(COL_44,pemail);
        contentValues.put(COL_55,url);
        contentValues.put(COL_66,yr);

        long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1)
            res= false;
        else
            res= true;
        //db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return res;

    }

    public boolean insertData2(String d,String t,String y,String sub,String te,String k) {
        boolean res;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_222,d);
        contentValues.put(COL_333,t);
        contentValues.put(COL_444,y);
        contentValues.put(COL_555,sub);
        contentValues.put(COL_666,te);
        contentValues.put(COL_777,k);

        long result = db.insert(TABLE_NAME11, null, contentValues);
        if(result == -1)
            res= false;
        else
            res= true;
        //db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return res;

    }

    public boolean insertData3(String ev,String dt) {
        boolean res;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_22222,ev);
        contentValues.put(COL_33333,dt);

        long result = db.insert(TABLE_NAME1111, null, contentValues);
        if(result == -1)
            res= false;
        else
            res= true;
        //db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return res;

    }

    public boolean insertData4(String d,String t,String yr,String sub,String dt,String sta,String nm) {
        boolean res;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2222,d);
        contentValues.put(COL_3333,t);
        contentValues.put(COL_4444,yr);
        contentValues.put(COL_5555,sub);
        contentValues.put(COL_6666,dt);
        contentValues.put(COL_7777,sta);
        contentValues.put(COL_8888,nm);


        long result = db.insert(TABLE_NAME111, null, contentValues);
        if(result == -1)
            res= false;
        else
            res= true;
        //db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return res;

    }

    public Cursor getAllData1(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * FROM " + TABLE_NAME111 + " WHERE " + COL_1 + " =  \"" + id + "\"";
        Cursor res= db.rawQuery(query,null);
        return res;
    }

    public Cursor getAttend(String Name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * FROM " + TABLE_NAME111 + " WHERE " + COL_8888 + " =  \"" + Name + "\"";
        Cursor res= db.rawQuery(query,null);
        return res;
    }


    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Cursor getAllData(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COL_3 + " =  \"" + email + "\"";
        Cursor res= db.rawQuery(query,null);
        return res;
    }

    public boolean updateData1(String id,String sname,String email,String pemail,String url,String yr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_22,sname);
        contentValues.put(COL_33,email);
        contentValues.put(COL_44,pemail);
        contentValues.put(COL_55,url);
        contentValues.put(COL_66,yr);
        db.update(TABLE_NAME1, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

    public void deleteDataattend () {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME111);

    }

}

