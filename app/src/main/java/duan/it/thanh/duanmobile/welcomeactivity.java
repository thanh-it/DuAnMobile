package duan.it.thanh.duanmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class welcomeactivity extends AppCompatActivity {
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
            MyTimerTask myTask = new MyTimerTask();
            Timer myTimer = new Timer();
            myTimer.schedule(myTask, 3000);
        }
    class MyTimerTask extends TimerTask {
        public void run() {
            Intent intent = new Intent(getApplicationContext(),loginactivity.class);
            startActivity(intent);
            finish();
        }
    }
}
