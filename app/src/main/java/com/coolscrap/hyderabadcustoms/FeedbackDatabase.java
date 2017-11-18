package com.coolscrap.hyderabadcustoms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shubham on 17/11/17.
 */

public class FeedbackDatabase {
    public static final String COUNTRY = "country";
    private static final String DATABASE_NAME = "hotnessdb";
    private static final int DATABASE_VERSION = 1;
    public static final String DATE = "date";
    public static final String FEEDBACK = "feedback";
    public static final String FLIGHT = "flight";
    private static final String NAME = "name";
    public static final String PASSPORT = "passport";
    public static final String REACTION = "reaction";
    private static final String ROW_ID = "_id";
    private static final String TABLE_HOT = "peopletable";
    public static int count;
    private Context ourContext;
    private SQLiteDatabase ourDatabse;
    private MyDBHandler ourhelper;

    public class MyDBHandler extends SQLiteOpenHelper
    {


        public MyDBHandler(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

        @Override
        public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE peopletable (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, country TEXT NOT NULL, flight TEXT NOT NULL, passport TEXT NOT NULL, reaction TEXT NOT NULL, feedback TEXT NOT NULL, date TEXT NOT NULL);");
            return;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS peopletable");
onCreate(db);
        }
    }
    public FeedbackDatabase(Context c)
    {
        this.ourContext=c;
    }
    public FeedbackDatabase open() throws SQLiteException
    {
        {
            ourhelper = new MyDBHandler(ourContext);
            ourDatabse = ourhelper.getWritableDatabase();
            Cursor cursor = ourhelper.getWritableDatabase().rawQuery("SELECT  * FROM peopletable", null);
            cursor.moveToFirst();
            count = cursor.getCount();
            cursor.close();
            return this;
        }
    }
    public FeedbackDatabase close()
    {
        ourhelper.close();
        return null;
    }
    public long createEntry(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {

            ContentValues contentvalues = new ContentValues();
            contentvalues.put("name", s);
            contentvalues.put("flight", s1);
            contentvalues.put("country", s2);
            contentvalues.put("passport", s3);
            contentvalues.put("reaction", s4);
            contentvalues.put("feedback", s5);
            contentvalues.put("date", s6);
            return ourDatabse.insert("peopletable", null, contentvalues);
        }

    public int getAngry()
    {
            return ourDatabse.rawQuery("SELECT reaction  FROM peopletable WHERE reaction = 'ANGRY'", null).getCount();
    }

    public String getComments()
    {
        Cursor cursor = ourDatabse.query("peopletable", new String[] {
                "_id", "name", "flight", "country", "passport", "reaction", "feedback"
        }, null, null, null, null, null);
        String obj = "";
        cursor.getColumnIndex("_id");
        int i = cursor.getColumnIndex("name");
        cursor.getColumnIndex("flight");
        cursor.getColumnIndex("country");
        int j = cursor.getColumnIndex("feedback");
        cursor.moveToFirst();
        for(; !cursor.isAfterLast(); cursor.moveToNext())
            obj = (new StringBuilder()).append(((String) (obj))).append("\n\n").append(" \t\t ").append(cursor.getString(i)).append(": '' ").append(cursor.getString(j)).append(" '' \n\n").toString();

        return (obj);
    }
    public String getData()
    {

        Cursor cursor = ourDatabse.query("peopletable", new String[] {
                "_id", "name", "flight", "country", "passport", "reaction", "feedback", "date"
        }, null, null, null, null, null);
        String obj = "";
        cursor.getColumnIndex("_id");
        int i = cursor.getColumnIndex("name");
        int j = cursor.getColumnIndex("flight");
        int k = cursor.getColumnIndex("country");
        int l = cursor.getColumnIndex("passport");
        int i1 = cursor.getColumnIndex("reaction");
        cursor.getColumnIndex("feedback");
        int j1 = cursor.getColumnIndex("date");
        cursor.moveToFirst();
        for(; !cursor.isAfterLast(); cursor.moveToNext())
            obj = obj + "\n\n" +" " + cursor.getString(i) +" \t\t\t " + cursor.getString(j) + " \t\t\t\t" + cursor.getString(k) + " \t \t\t\t" + cursor.getString(l) + " \t\t\t" + cursor.getString(i1) + " \t\t\t" + cursor.getString(j1)+" \n\n";

        return (obj);
    }
    public int getCount()
    {
        int i = 0,j;
        Cursor cursor = ourDatabse.query("peopletable", new String[] {
                "_id", "name", "flight", "country", "passport", "reaction", "feedback"
        }, null, null, null, null, null);
        cursor.getColumnIndex("_id");
        cursor.moveToFirst();
        do
        {
            j = i;
            if(cursor.isAfterLast())
                continue;
            i++;
            cursor.moveToNext();
        } while(true);
     }
    public int getEnjoyed()
    {
            return ourDatabse.rawQuery("SELECT reaction  FROM peopletable WHERE reaction = 'HAPPY'", null).getCount();
    }

    public int getHappy()
    {
            return ourDatabse.rawQuery("SELECT reaction  FROM peopletable WHERE reaction = 'SATISFIED'", null).getCount();
    }

    public int getSad()
    {
            return ourDatabse.rawQuery("SELECT reaction  FROM peopletable WHERE reaction = 'SAD'", null).getCount();
    }

    public int getSatisfied()
    {
            return ourDatabse.rawQuery("SELECT reaction  FROM peopletable WHERE reaction = 'NEUTRAL'", null).getCount();
    }
    public void resetData()
    {
            open();
            ourDatabse.execSQL("DELETE FROM peopletable");
            return;
        }


}
