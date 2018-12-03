package duan.it.thanh.duanmobile.music;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import duan.it.thanh.duanmobile.R;

public class PlayerActivity extends AppCompatActivity implements Animation.AnimationListener {
    private MediaPlayer mMediaPlayer;
    ArrayList<File> mySongs;
    Button next, prev, play;
    SeekBar sb;
    Thread update_th;
    int position;
    Uri u;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        toolbar.setTitle("Đang phát nhạc....");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.stop();
                finish();
            }
        });
        ImageView iv_disk = findViewById(R.id.disk_ant);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.player_disk);
        iv_disk.setAnimation(animation);
        next = findViewById(R.id.btn_next);
        prev = findViewById(R.id.btn_prev);
        play = findViewById(R.id.btn_play);
        sb = (SeekBar) findViewById(R.id.seek_bar);
        title = findViewById(R.id.title);
        update_th = new Thread(){
            @Override
            public void run() {
                int total = mMediaPlayer.getDuration();
                int currentP = 0;
                sb.setMax(total);
                while (currentP<total){
                    try{
                        sleep(500);
                        currentP=mMediaPlayer.getCurrentPosition();
                        sb.setProgress(currentP);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        if(mMediaPlayer!=null){
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
        Intent i = getIntent();
        Bundle b = i.getExtras();
        mySongs = (ArrayList) b.getParcelableArrayList("songList");
        position = b.getInt("pos",0);
        u = Uri.parse(mySongs.get(position).toString());
        mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
        title.setText(mySongs.get(position).getName());
        mMediaPlayer.start();
        update_th.start();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
                position = (position+1)%mySongs.size();
                u = Uri.parse(mySongs.get(position).toString());
                mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
                title.setText(mySongs.get(position).getName());
                mMediaPlayer.start();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
                position = (position-1<0)? mySongs.size()-1: position-1;
//                if(position-1 < 0){
//                    position=mySongs.size()-1;
//                }else {
//                    position=position-1;
//                }
                u = Uri.parse(mySongs.get(position).toString());
                mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
                title.setText(mySongs.get(position).getName());
                mMediaPlayer.start();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                    play.setText("Stop");
                }else {
                    mMediaPlayer.start();
                    play.setText("Play");
                }
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

}
