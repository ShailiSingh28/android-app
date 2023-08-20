package com.example.myform;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class sqlite extends SQLiteOpenHelper {
     static final String DATABASE_NAME="table.db";
     static final int DATABASE_VERSION=1;
    Context ctx;
    public sqlite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sb) {
        sb.execSQL(modelclass.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public long data(modelclass models) {
        SQLiteDatabase db=this.getWritableDatabase();
        long ids=0;
        try {
            if (db!=null && db.isOpen() && !db.isReadOnly()){
                ContentValues values=new ContentValues();
                //values.put("local_id",models.getLocal_id());
                values.put("name", models.getName());
                values.put("dob",models.getDob());
                values.put("fname",models.getFname());
                values.put("mname",models.getMname());
                values.put("gender",models.getGender());

                ids=db.insert("Student_Record",null, values);
                // Log.e(TAG,"okay"+ids);
                db.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            db.close();
        }
        return ids;
}

    @SuppressLint("Range")
    public ArrayList<modelclass> getstudentdetails() {
        ArrayList <modelclass> arr=new ArrayList<>();
        SQLiteDatabase sql=this.getWritableDatabase();
        try {
            if (sql!=null && sql.isOpen()&& !sql.isReadOnly())
            {
                String query="Select * from Student_Record";
                Cursor c=sql.rawQuery(query,null);
                if (c!=null && c.getCount()>0)
                {
                    c.moveToFirst();
                    while (!c.isAfterLast())
                    {
                        modelclass list=new modelclass();
                        list.setLocal_id(c.getString(c.getColumnIndex("local_id")));
                        list.setName(c.getString(c.getColumnIndex("name")));
                        list.setDob(c.getString(c.getColumnIndex("dob")));
                        list.setFname(c.getString(c.getColumnIndex("fname")));
                        list.setMname(c.getString(c.getColumnIndex("mname")));
                        arr.add(list);
                        c.moveToNext();
                    }
                }
                sql.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            sql.close();
        }
        return arr;
    }
}
