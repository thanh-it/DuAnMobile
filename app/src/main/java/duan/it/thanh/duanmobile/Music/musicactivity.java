package duan.it.thanh.duanmobile.Music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import duan.it.thanh.duanmobile.mainactivity;
import duan.it.thanh.duanmobile.R;

public class musicactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mainactivity.class));
            }
        });
        Button show_list = findViewById(R.id.show_list);
        Button online_music = findViewById(R.id.musicOnline);
        show_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent show = new Intent(musicactivity.this, listmusicactivity.class);
                startActivity(show);
            }
        });
        online_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent online = new Intent(musicactivity.this,onlinemusicactivity.class);
                startActivity(online);
            }
        });
    }

}
