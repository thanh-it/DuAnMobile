package duan.it.thanh.duanmobile.media;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

import duan.it.thanh.duanmobile.R;
import duan.it.thanh.duanmobile.dbdao.MediaDAO;

public class MediaMusicActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YoutubeActivity> youtubeActivities = new Vector<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MediaActivity.class));
                youtubeActivities.clear();
            }
        });
        recyclerView = findViewById(R.id.lv_media_music);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        youtubeActivities.clear();
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/23-Fu3enVqI\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ydGnrDkBNvs\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3WBAKpQf2Pw\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PeHkM0nWqHY\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VX3wT9t3_rY\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/l727AmzA3dA\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/GvQ9B3UVZVo\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PeHkM0nWqHY\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UGrkBpZ6h7k\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/dmMOS86RwFQ\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kUYzOcszm10\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kkR4LxK69Ww\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rModCh06Pnc\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/0voRSYMaAKE\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));
        youtubeActivities.add(new YoutubeActivity("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RY4wKPQrKeU\" frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeActivities);
        recyclerView.setAdapter(videoAdapter);
    }

}
