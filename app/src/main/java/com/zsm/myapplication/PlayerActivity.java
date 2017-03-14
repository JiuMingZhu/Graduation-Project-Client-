package com.zsm.myapplication;

import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private VideoView vitamio_videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        //去除ActionBar
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        //设置横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //检测Vitamio是否解压解码包，一定要加
        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
            return;

        //初始化Vitamio包下的VideoView
        vitamio_videoview = (VideoView) findViewById(R.id.vitamio_videoview);

        //放入网址
        vitamio_videoview.setVideoURI(Uri.parse("rtmp://xiaomingjiang.vicp.net:21188/oflaDemo/123.mp4"));

        //设置控制栏
        vitamio_videoview.setMediaController(new MediaController(this));

        //获取焦点
        vitamio_videoview.requestFocus();

        //准备播放监听
        vitamio_videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);//设置播放速度
            }
        });
    }
}
