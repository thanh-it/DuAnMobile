package duan.it.thanh.duanmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import duan.it.thanh.duanmobile.Media.MediaActivity;
import duan.it.thanh.duanmobile.Music.MusicActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_music = findViewById(R.id.btn_music);
        Button btn_media = findViewById(R.id.btn_media);
        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent music = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(music);
            }
        });
        btn_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent media = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(media);
            }
        });
    }
}
