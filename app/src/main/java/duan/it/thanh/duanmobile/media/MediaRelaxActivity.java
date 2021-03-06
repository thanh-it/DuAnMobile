package duan.it.thanh.duanmobile.media;

import android.annotation.SuppressLint;
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
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_relax);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Phim thư giãn");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                youtubeActivities.clear();
            }
        });
        recyclerView = findViewById(R.id.lv_media_relax);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youtubeActivities.clear();
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lpjrT99ds88\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rBtUOHo2Ayw\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/B8SxgpIOu18\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eDpdQUM8WuA\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NH7tV0Pvdz4\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/-4YcSQlS1gw\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zwoTa2AyLNI\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cZJJsgJyMZs\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ME6znbdq6G4\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        VideoAdapter videoAdapter = new VideoAdapter(youtubeActivities);
        recyclerView.setAdapter(videoAdapter);
    }
}
