package com.zsm.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.KeyEvent;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {
    //Vitamio组件
    private VideoView vitamio_videoview;
    //流媒体视频Url
    String Url;
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

        //从上个Activity的Intent中取得Url
        Url=getIntent().getStringExtra("Url");
        //放入网址
        vitamio_videoview.setVideoURI(Uri.parse(Url));

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK);
        {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("按到返回键了哦~");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗，将返回扫描界面");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            // 显示对话框
            isExit.show();
        }
        return false;
    }
    DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };
}
