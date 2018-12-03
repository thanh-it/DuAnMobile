package duan.it.thanh.duanmobile.datamusicmedia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB extends SQLiteOpenHelper {
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
    public DB(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MEDIA);
        db.execSQL(SQL_CREATE_MUSIC);
        String sql = "INSERT or replace INTO MUSIC (NAME, LINK, TYPE) VALUES('Người Ta Có Thương Mình Đâu','http://download.monteam.net/1.mp3','nhacviet')," +
                "('Đẹp Nhất Là Em','http://download.monteam.net/2.mp3','nhacviet')," +
                "('Gửi Tình Yêu Nhỏ','http://download.monteam.net/3.mp3','nhacviet')," +
                "('Nhà Em Ở Lưng Đồi','http://download.monteam.net/4.mp3','nhacviet')," +
                "('Cưới Chạy','http://download.monteam.net/5.mp3','nhacviet')," +
                "('Đi Đi Đi','http://download.monteam.net/6.mp3','nhacviet')," +
                "('Đi Đi Chần Chờ Chi','http://download.monteam.net/7.mp3','nhacviet')," +
                "('Vì Anh Thương Em','http://download.monteam.net/8.mp3','nhacviet')," +
                "('Không Thể Chạm Được Em','http://download.monteam.net/9.mp3','nhacviet')," +
                "('Đại Ca Lớp 12A','http://download.monteam.net/10.mp3','nhacviet')," +
                "('Đời Anh Xe Ôm','http://download.monteam.net/11.mp3','nhacviet')," +
                "('Em Đừng Thả Thính','http://download.monteam.net/12.mp3','nhacviet')," +
                "('Em Chừa Rồi','http://download.monteam.net/13.mp3','nhacviet')," +
                "('Attentiom','http://download.monteam.net/1a.mp3','nhacam')," +
                "('Vicetone - Nevada','http://download.monteam.net/2a.mp3','nhacam')," +
                "('Havana','http://download.monteam.net/3a.mp3','nhacam')," +
                "('Clean bandit symphony','http://download.monteam.net/4a.mp3','nhacam')," +
                "('DJ Let me love you','http://download.monteam.net/5a.mp3','nhacam')," +
                "('That Girl','http://download.monteam.net/6a.mp3','nhacam')," +
                "('Reality','http://download.monteam.net/7a.mp3','nhacam')," +
                "('Avicii','http://download.monteam.net/8a.mp3','nhacam')," +
                "('Alan Walker','http://download.monteam.net/9a.mp3','nhacam')," +
                "('TOP 20 ban nightcore','http://download.monteam.net/10a.mp3','nhacam')," +
                "('Drum piano','http://download.monteam.net/11a.mp3','nhacam')," +
                "('Some thing just like','http://download.monteam.net/12a.mp3','nhacam')," +
                "('Tonyz road so far in spired','http://download.monteam.net/13a.mp3','nhacam')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_table = String.format("DROP TABLE IF EXISTS %s", db);
        db.execSQL(drop_table);
        onCreate(db);
        Log.d("onUpgrade","HELLO");
    }
}