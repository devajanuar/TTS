package com.ttsmultimedia.tts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by devajanuar on 8/14/2015.
 */
public class Video extends Activity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private String[] programmingLang={"1. OneOkRock - Heartache","2. OneOkRock - Kanzen Kankaku Dreamer","3. OneOkRock - The Beginning"  };
    Button btnplayvideo,next,prev;
    VideoView mVideoView;
    DisplayMetrics dm;
    int pos;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        btnplayvideo = (Button) findViewById(R.id.button2);

        btnplayvideo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SdCardPath")
            @Override
            public void onClick(View v) {
                if(btnplayvideo.getText().equals("Play")){
                    getInit();
                    btnplayvideo.setText("Stop");
                }else  if (btnplayvideo.getText().equals("Stop")){
                    mVideoView.stopPlayback();
                    btnplayvideo.setText("Play");
                }
            }
        });

        btnback = (ImageButton) findViewById(R.id.backvideo);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Video.this,MainActivity.class);
                startActivity(intent);
            }
        });

        next  = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos ==1){
                    kedua();
                }
                else if (pos ==2){
                    ketiga();
                }
                if (pos==3){

                }
            }
        });

        prev = (Button)findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos ==1){

                }
                if (pos ==2){
                    pertama();
                }
                if (pos==3){
                    kedua();
                }
            }
        });

        listView=(ListView) findViewById(R.id.listView);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,programmingLang);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

    }

    @SuppressLint("SdCardPath")
    public void getInit(){
        pos = 1;
        String path = "/sdcard/x.mp4";
        mVideoView = (VideoView) findViewById(R.id.videoview1);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        mVideoView.setMinimumWidth(width);
        mVideoView.setMinimumHeight(height);
        mVideoView.setVideoPath(path);
        mVideoView.start();
    }


    @SuppressLint("SdCardPath")
    public void pertama(){
        pos=1;
        String path = "/sdcard/x.mp4";
        mVideoView = (VideoView) findViewById(R.id.videoview1);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        mVideoView.setMinimumWidth(width);
        mVideoView.setMinimumHeight(height);
        mVideoView.setVideoPath(path);
        mVideoView.start();
    }
    @SuppressLint("SdCardPath")
    public void kedua(){
        pos=2;
        String path = "/sdcard/y.mp4";
        mVideoView = (VideoView) findViewById(R.id.videoview1);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        mVideoView.setMinimumWidth(width);
        mVideoView.setMinimumHeight(height);
        mVideoView.setVideoPath(path);
        mVideoView.start();
    }

    @SuppressLint("SdCardPath")
    public void ketiga(){
        pos=3;
        String path = "/sdcard/z.mp4";
        mVideoView = (VideoView) findViewById(R.id.videoview1);
        dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        mVideoView.setMinimumWidth(width);
        mVideoView.setMinimumHeight(height);
        mVideoView.setVideoPath(path);
        mVideoView.start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String message=""+((TextView)view).getText();
        if(btnplayvideo.getText().equals("Play")){
            btnplayvideo.setText("Stop");
            if (message.equals("1. OneOkRock - Heartache")){
                pos = 1;
                String path = "/sdcard/y.mp4";
                mVideoView = (VideoView) findViewById(R.id.videoview1);
                dm = new DisplayMetrics();
                this.getWindowManager().getDefaultDisplay().getMetrics(dm);
                int height = dm.heightPixels;
                int width = dm.widthPixels;
                mVideoView.setMinimumWidth(width);
                mVideoView.setMinimumHeight(height);
                mVideoView.setVideoPath(path);
                mVideoView.start();

            }
            if (message.equals("2. OneOkRock - Kanzen Kankaku Dreamer")){
                pos=2;
                String path = "/sdcard/x.mp4";
                mVideoView = (VideoView) findViewById(R.id.videoview1);
                dm = new DisplayMetrics();
                this.getWindowManager().getDefaultDisplay().getMetrics(dm);
                int height = dm.heightPixels;
                int width = dm.widthPixels;
                mVideoView.setMinimumWidth(width);
                mVideoView.setMinimumHeight(height);
                mVideoView.setVideoPath(path);
                mVideoView.start();

            }
            if (message.equals("3. OneOkRock - The Beginning")) {
                pos=3;
                String path = "/sdcard/z.mp4";
                mVideoView = (VideoView) findViewById(R.id.videoview1);
                dm = new DisplayMetrics();
                this.getWindowManager().getDefaultDisplay().getMetrics(dm);
                int height = dm.heightPixels;
                int width = dm.widthPixels;
                mVideoView.setMinimumWidth(width);
                mVideoView.setMinimumHeight(height);
                mVideoView.setVideoPath(path);
                mVideoView.start();
            }
        }else  if (btnplayvideo.getText().equals("Stop")) {
            mVideoView.stopPlayback();
            btnplayvideo.setText("Play");
        }


        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

