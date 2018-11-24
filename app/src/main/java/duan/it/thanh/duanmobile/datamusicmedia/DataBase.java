package duan.it.thanh.duanmobile.datamusicmedia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBase extends SQLiteOpenHelper {
    private static final int version = 1   ;
    private static final String name = "db";
    private static final String SQL_CREATE_MEDIA="Create table MEDIA (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "LINK TEXT ,"+
            "TYPE TEXT)";
    private static final String SQL_CREATE_MUSIC="Create table MUSIC (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME TEXT ," +
            "LINK TEXT ,"+
            "TYPE TEXT)";
    public DataBase(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MEDIA);
        db.execSQL(SQL_CREATE_MUSIC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_table = String.format("DROP TABLE IF EXISTS %s", db);

        db.execSQL(drop_table);

        onCreate(db);
        Log.d("onUpgrade","HELLO");
    }
}