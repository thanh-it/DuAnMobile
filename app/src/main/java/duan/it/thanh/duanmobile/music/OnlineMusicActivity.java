package duan.it.thanh.duanmobile.music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import duan.it.thanh.duanmobile.R;

public class OnlineMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MusicActivity.class));
            }
        });
        Button musicV = findViewById(R.id.musicV);
        Button musicA = findViewById(R.id.musicA);
        musicV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Viet = new Intent(OnlineMusicActivity.this, ListOnlineVActivity.class);
                startActivity(Viet);
            }
        });
        musicA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Anh = new Intent(OnlineMusicActivity.this, ListOnlineAActivity.class);
                startActivity(Anh);
            }
        });

    }

}
