package duan.it.thanh.duanmobile.music;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import duan.it.thanh.duanmobile.R;
import duan.it.thanh.duanmobile.dbdao.MusicDAO;
import duan.it.thanh.duanmobile.model.Music;

public class ListOnlineVActivity extends AppCompatActivity {
ListView lv_V;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_v_online);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),OnlineMusicActivity.class));
            }
        });
        lv_V = findViewById(R.id.lv_v);
        MusicDAO musicDAO = new MusicDAO(this);
        final List<Music> musics = musicDAO.getmusicv();
        CustomPr customPr = new CustomPr(this, musics);
        lv_V.setAdapter(customPr);
        lv_V.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),ListenOnlineActivity.class).putExtra("pos",position).putExtra("typemusic","nhacviet"));
            }
        });
    }
    class CustomPr extends BaseAdapter
    {
        LayoutInflater inflater;
        List<Music> musics;
        CustomPr(Context context, List<Music> music)
        {
            inflater = (LayoutInflater)(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
            musics = music;
        }
        @Override
        public int getCount() {
            return musics.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view =  inflater.inflate(R.layout.custom_music,null);
            TextView stt = view.findViewById(R.id.idms);
            String idshow = String.valueOf(musics.get(position).getId());
            stt.setText(idshow);
            TextView name = view.findViewById(R.id.name);
            name.setText(musics.get(position).getName());
            return view;
        }
    }
}
