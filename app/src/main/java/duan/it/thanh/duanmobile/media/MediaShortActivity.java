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

public class MediaShortActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YoutubeActivity> youtubeActivities = new Vector<>();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_short);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Phim ngắn");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                youtubeActivities.clear();
            }
        });
        recyclerView = findViewById(R.id.lv_media_short);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youtubeActivities.clear();
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5QXa051kjpU\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/AVee0LbBxXc\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8BpEVByhOzI\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/hymGTWhFHio\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JlxkCNoINsw\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/oeVeKuuQRsA\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/0YU0ocHlyoQ\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KWB6oMhIGdo\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Y_2_vjo2Ur4\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeActivities);
        recyclerView.setAdapter(videoAdapter);
    }
}
