package duan.it.thanh.duanmobile.media;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Vector;

import duan.it.thanh.duanmobile.R;

public class MediaRelaxActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YoutubeActivity> youtubeActivities = new Vector<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_relax);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MediaActivity.class));
                recyclerView.setAdapter(null);
            }
        });
        recyclerView = findViewById(R.id.lv_media_music);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VDgDjlXFPPo\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NgNE9ORkDtY\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fE5Rh4Dwk7s\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        VideoAdapter videoAdapter = new VideoAdapter(youtubeActivities);
        recyclerView.setAdapter(null);
        recyclerView.setAdapter(videoAdapter);
    }
}
