package duan.it.thanh.duanmobile.Music;

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
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import duan.it.thanh.duanmobile.R;
import duan.it.thanh.duanmobile.dbdao.musicdao;
import duan.it.thanh.duanmobile.model.music;

public class ListOnlineAActivity extends AppCompatActivity {
    ListView musica;
    musicdao musicDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_online_a);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),OnlineMusicActivity.class));
            }
        });
        musicDAO = new musicdao(ListOnlineAActivity.this);
        musica = findViewById(R.id.lv_am);;
        final List<music> musicas = musicDAO.getmusicam();
        CustomPr customPr = new CustomPr(this,musicas);
        musica.setAdapter(customPr);
        musica.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),open_music_am.class).putExtra("pos",position));
            }
        });
    }

    class CustomPr extends BaseAdapter
    {
        LayoutInflater inflater;
        List<music> musicas;
        CustomPr(Context context, List<music> musicam)
        {
            inflater = (LayoutInflater)(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
            musicas = musicam;
        }
        @Override
        public int getCount() {
            return musicas.size();
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
            View v =  inflater.inflate(R.layout.custom_music,null);
            TextView stt = v.findViewById(R.id.idms);
            TextView name = v.findViewById(R.id.name);
            String mstt = String.valueOf(musicas.get(position).getId());
            stt.setText(mstt);
            name.setText(musicas.get(position).getName());
            return v;
        }
    }
}
