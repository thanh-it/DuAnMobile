package duan.it.thanh.duanmobile.music;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import duan.it.thanh.duanmobile.R;
import duan.it.thanh.duanmobile.dbdao.MusicDAO;
import duan.it.thanh.duanmobile.model.Music;

public class ListenOnlineActivity extends AppCompatActivity implements Animation.AnimationListener{
    private MediaPlayer mMediaPlayer;
    Button next, prev, play;
    SeekBar sb;
    Thread update_th;
    int position;
    Uri u;
    String type;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_online);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Intent i = getIntent();
        Bundle b = i.getExtras();
        position = b.getInt("pos",0);
        type = b.getString("typemusic");
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Đang nghe nhạc Online");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.stop();
//                if(type.equalsIgnoreCase("nhacam")){
//                    Intent open = new Intent(ListenOnlineActivity.this,ListOnlineAActivity.class);
//                    Log.d("test","acjs");
//                    startActivity(open);
//                }else if(type.equalsIgnoreCase("nhacviet")){
//                    Intent open = new Intent(ListenOnlineActivity.this,ListOnlineVActivity.class);
//                    Log.d("test","acjs");
//                    startActivity(open);
//                }
                finish();


            }
        });

        ImageView iv_disk = findViewById(R.id.disk_ant);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.player_disk);
        iv_disk.setAnimation(animation);
        animation.setAnimationListener(this);
        next = findViewById(R.id.btn_next);
        prev = findViewById(R.id.btn_prev);
        play = findViewById(R.id.btn_play);
        sb = (SeekBar) findViewById(R.id.seek_bar);
        title = findViewById(R.id.title);
        if(mMediaPlayer!=null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();

        }else{
        if(type.equalsIgnoreCase("nhacviet")){
            MusicDAO musicDAO = new MusicDAO(this);
            final List<Music> musics = musicDAO.getmusicv();
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

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
                            if (sb != null) {
                                sb.setProgress(currentP);
                            }
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            };
            u = Uri.parse(musics.get(position).getLink());
            title.setText(musics.get(position).getName());
            mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayer.start();
                    update_th.start();
                }
            });
            mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    position = (position+1)%musics.size();
                    u = Uri.parse(musics.get(position).getLink());
                    mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
                    mMediaPlayer.start();
                }
            });
            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    position = (position-1<0)? musics.size()-1: position-1;
                    u = Uri.parse(musics.get(position).getLink());
                    mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
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
        }else if(type.equalsIgnoreCase("nhacam")){
            MusicDAO musicDAO = new MusicDAO(this);
            final List<Music> musicam = musicDAO.getmusicam();
            mMediaPlayer = new MediaPlayer();

            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            update_th = new Thread(){
                @Override
                public void run() {
                    int total = mMediaPlayer.getDuration();
                    int currentP = 0;
                    sb.setMax(total);
                    while (currentP<total){
                        try{
                            sleep(500);
                            currentP = mMediaPlayer.getCurrentPosition();
                            if (sb != null) {
                                sb.setProgress(currentP);
                            }
                        }catch (InterruptedException e){
                            e.printStackTrace();
                            mMediaPlayer.reset();
                            currentP = mMediaPlayer.getCurrentPosition();
                        }
                    }
                }
            };

            u = Uri.parse(musicam.get(position).getLink());
            title.setText(musicam.get(position).getName());
            mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayer.start();
                    update_th.start();
                }
            });
            mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }
            });
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    position = (position+1)%musicam.size();
                    u = Uri.parse(musicam.get(position).getLink());
                    mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
                    mMediaPlayer.start();
                }
            });
            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    position = (position-1<0)? musicam.size()-1: position-1;
                    u = Uri.parse(musicam.get(position).getLink());
                    mMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
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
        }}
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
