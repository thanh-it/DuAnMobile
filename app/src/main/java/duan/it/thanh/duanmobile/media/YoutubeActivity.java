package duan.it.thanh.duanmobile.media;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import duan.it.thanh.duanmobile.R;

public class YoutubeActivity {
    String VideoUrl;
    public YoutubeActivity(){

    }
    public YoutubeActivity(String videoUrl){
        this.VideoUrl= videoUrl;
    }
    public String getVideoUrl() {
        return VideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        VideoUrl = videoUrl;
    }

}
