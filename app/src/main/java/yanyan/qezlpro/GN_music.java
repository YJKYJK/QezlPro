package yanyan.qezlpro;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;

public class GN_music extends Service {

    private MediaPlayer player;//声明一个MediaPlayer对象

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO 自动生成的方法存根
        return null;
    }

    //创建服务]
    @Override
    public void onCreate() {
        // 当player对象为空时
        if (player == null) {
            player = MediaPlayer.create(GN_music.this, Uri
                    .parse("http://dl.stream.qqmusic.qq.com/M800002JOt4X1yax7d.mp3?vkey=2BA1908EB1F47B6A85A5E7515447DADBB67A5F5836BFF81BBED68F4B309FFFA97B79007358AF727234E4E33C781A031AFA9FD524935D5E4B&guid=1501819542899&fromtag=30"));
            // 实例化对象，通过播放本机服务器上的一首音乐
            player.setLooping(false);//设置不循环播放
        }
        super.onCreate();
    }

    //销毁服务
    @Override
    public void onDestroy() {
        //当对象不为空时
        if (player != null) {
            player.stop();//停止播放
            player.release();//释放资源
            player = null;//把player对象设置为null
        }
        super.onDestroy();
    }

    //开始服务
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO 自动生成的方法存根
        Bundle b = intent.getExtras();//��ȡ����MainActivity���д��ݹ�����Bundle����
        int op = b.getInt("msg");//�ٻ�ȡ��MainActivity����op��ֵ
        switch (op) {
            case 1://��opΪ1ʱ����������Ű�ťʱ
                play();//����play()����
                break;
            case 2://��opΪ2ʱ���������ͣ��ťʱ
                pause();//����pause()����
                break;
            case 3://��opΪ3ʱ�������ֹͣ��ťʱ
                stop();//����stop()����
                break;
            default:
                break;
        }


        return super.onStartCommand(intent, flags, startId);
    }

    //停止播放音乐方法
    private void stop() {
        // 当player对象不为空时
        if (player != null) {
            player.seekTo(0);//设置从头开始
            player.stop();//停止播放
            try {
                player.prepare();//预加载音乐
            } catch (IllegalStateException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }

    //暂停播放音乐方法
    private void pause() {
        // 当player对象正在播放时并且player对象不为空时
        if (player.isPlaying() && player != null) {
            player.pause();//暂停播放音乐
        }
    }

    //播放音乐方法
    private void play() {
        // 当player对象不为空并且player不是正在播放时
        if (player != null && !player.isPlaying()) {
            player.start();//开始播放音乐
        }
    }
}
