package duan.it.thanh.duanmobile.Music;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SearchView;

import duan.it.thanh.duanmobile.R;

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button show_list = findViewById(R.id.show_list);
        Button online_music = findViewById(R.id.musicOnline);
        show_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent show = new Intent(MusicActivity.this, ListMusicActivity.class);
                startActivity(show);
            }
        });
        online_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent online = new Intent(MusicActivity.this,OnlineMusicActivity.class);
                startActivity(online);
            }
        });
    }

}
