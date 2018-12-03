package duan.it.thanh.duanmobile.dbdao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import duan.it.thanh.duanmobile.datamusicmedia.DB;
import duan.it.thanh.duanmobile.model.Music;

public class MusicDAO {
    private SQLiteDatabase db;
    private DB dbql;
    public MusicDAO(Context context){
        dbql = new DB(context);
        db = dbql.getWritableDatabase();

    }

    public List<Music> getPr(String sql, String...selectionArgs){
        List<Music> list = new ArrayList<>();
        Cursor c =db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            Music pr = new Music();
            pr.id = c.getInt(c.getColumnIndex("ID"));
            pr.name = c.getString(c.getColumnIndex("NAME"));
            pr.link = c.getString(c.getColumnIndex("LINK"));
            pr.type = c.getString(c.getColumnIndex("TYPE"));
            list.add(pr);
        }
        return list;
    }
    public List<Music> getMusicAll(){
        String sql = "SELECT * FROM MUSIC";
        return getPr(sql);
    }
    public List<Music> getmusicam(){
        String sql = "SELECT * FROM MUSIC WHERE TYPE LIKE '%nhacam%'";
        return getPr(sql);
    }
    public List<Music> getmusicv(){
        String sql = "SELECT * FROM MUSIC WHERE TYPE LIKE '%nhacviet%'";
        return getPr(sql);
    }
}
