package duan.it.thanh.duanmobile.Music;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import duan.it.thanh.duanmobile.R;

public class listmusicactivity extends AppCompatActivity {

    ListView lv;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_bakc_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),musicactivity.class));
            }
        });
        lv = findViewById(R.id.listmusicof);
        final ArrayList<File> mySongs = findSongs(Environment.getExternalStorageDirectory());
        items = new String[mySongs.size()];
        for (int i = 0; i<mySongs.size();i++){
            items[i] = mySongs.get(i).getName().toString().replace(".mp3","").replace(".wav","");
        }
        ArrayAdapter<String>  adp = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,items);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),playeractivity.class).putExtra("pos",position).putExtra("songList",mySongs));
            }
        });

    }
    public ArrayList<File> findSongs(File root){
        ArrayList<File> al = new ArrayList<File>();
        File[] files = root.listFiles();
        for(File singleFile : files){
            if(singleFile.isDirectory()){
                al.addAll(findSongs(singleFile));
            }else {
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav")){
                    al.add(singleFile);
                }
            }
        }
        return al;
    }
    public void toast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
    }


}
