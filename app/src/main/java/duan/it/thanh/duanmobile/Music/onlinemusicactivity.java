package duan.it.thanh.duanmobile.Music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import duan.it.thanh.duanmobile.R;

public class onlinemusicactivity extends AppCompatActivity {

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
                startActivity(new Intent(getApplicationContext(),musicactivity.class));
            }
        });
        Button musicV = findViewById(R.id.musicV);
        Button musicA = findViewById(R.id.musicA);
        musicV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Viet = new Intent(onlinemusicactivity.this, listonlinevactivity.class);
                startActivity(Viet);
            }
        });
        musicA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Anh = new Intent(onlinemusicactivity.this, listonlineaactivity.class);
                startActivity(Anh);
            }
        });

    }

}
