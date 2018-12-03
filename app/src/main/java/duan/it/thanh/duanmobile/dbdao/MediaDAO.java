package duan.it.thanh.duanmobile.dbdao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import duan.it.thanh.duanmobile.datamusicmedia.DB;
import duan.it.thanh.duanmobile.media.YoutubeActivity;

public class MediaDAO {
    private SQLiteDatabase db;
    private DB dbql;
    public MediaDAO(Context context){
        dbql = new DB(context);
        db = dbql.getWritableDatabase();
    }
    public List<YoutubeActivity> getPr(String sql, String...selectionArgs){
        List<YoutubeActivity> list = new ArrayList<>();
        Cursor c =db.rawQuery(sql,selectionArgs);
        while (c.moveToNext()){
            YoutubeActivity pr = new YoutubeActivity();
            pr.id = c.getInt(c.getColumnIndex("ID"));
            pr.VideoUrl = c.getString(c.getColumnIndex("LINK"));
            pr.type = c.getString(c.getColumnIndex("TYPE"));
            list.add(pr);
        }
        return list;
    }
    public List<YoutubeActivity> getMediaAll(){
        String sql = "SELECT * FROM MEDIA";
        return getPr(sql);
    }
    public List<YoutubeActivity> getShort(){
        String sql = "SELECT * FROM MEDIA WHERE TYPE LIKE '%short%'";
        return getPr(sql);
    }
    public List<YoutubeActivity> getRelax(){
        String sql = "SELECT * FROM MEDIA WHERE TYPE LIKE '%relax%'";
        return getPr(sql);
    }
    public List<YoutubeActivity> getMusics(){
        String sql = "SELECT * FROM MEDIA WHERE TYPE LIKE '%music%'";
        return getPr(sql);
    }
}
