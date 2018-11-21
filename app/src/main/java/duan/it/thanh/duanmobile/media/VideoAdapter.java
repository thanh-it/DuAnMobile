package duan.it.thanh.duanmobile.media;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;

import duan.it.thanh.duanmobile.R;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    List<YoutubeActivity> youtubeActivities;
    public VideoAdapter(){

    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext()).inflate(R.layout.video_view,viewGroup,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        videoViewHolder.videoWeb.loadData(youtubeActivities.get(i).getVideoUrl(),"text/html","utf-8");
    }

    public VideoAdapter(List<YoutubeActivity> youtubeActivities){
        this.youtubeActivities = youtubeActivities;
    }



    @Override
    public int getItemCount() {
        return youtubeActivities.size();
    }
    public class VideoViewHolder extends RecyclerView.ViewHolder{
        WebView videoWeb;
        public VideoViewHolder(View itemView){
            super(itemView);
            videoWeb = (WebView) itemView.findViewById(R.id.webView);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient());
        }
    }
}
