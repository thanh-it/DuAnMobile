package duan.it.thanh.duanmobile.media;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import duan.it.thanh.duanmobile.R;

public class YoutubeActivity {
    public String VideoUrl;
    public String type;
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
