package duan.it.thanh.duanmobile.Media;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import duan.it.thanh.duanmobile.MainActivity;
import duan.it.thanh.duanmobile.R;

public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        Button media_short = findViewById(R.id.mediaShort);
        Button media_relax = findViewById(R.id.mediaRelax);
        Button media_music = findViewById(R.id.mediaMusic);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        media_short.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mediashort = new Intent(MediaActivity.this,MediaShortActivity.class);
                startActivity(mediashort);
            }
        });
        media_relax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mediarelax = new Intent(MediaActivity.this,MediaRelaxActivity.class);
                startActivity(mediarelax);
            }
        });
        media_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mediamusic = new Intent(MediaActivity.this,MediaMusicActivity.class);
                startActivity(mediamusic);
            }
        });
    }

}
