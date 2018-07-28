package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public class qq_jbqp extends Activity {
    private EditText bh;
    private GN_Dialog dialog;
    ClipboardManager cp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_jbqp);
        bh= (EditText) findViewById(R.id.jbqp_bh);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    }
    public void jbqp_sc(View view)
    {
        String a=bh.getText().toString();
        if(a.length()==0)
        {
            Toast.makeText(qq_jbqp.this,"请输入编号",Toast.LENGTH_SHORT).show();
        }
        else
        {
            fz("http://zb.vip.qq.com/bubble?id="+a);

            dialog=new GN_Dialog(qq_jbqp.this);
            dialog.setBt("生成成功");
            dialog.setXx("链接已复制，请打开QQ粘贴发送到QQ好友或者群，点击链接设置即可");
            dialog.setQd("打开QQ");
            dialog.setQx("取消");
            dialog.show();
            dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                @Override
                public void onqdclick() {
                    Intent intent=new Intent();
                    PackageManager packageManager=qq_jbqp.this.getPackageManager();
                    intent=packageManager.getLaunchIntentForPackage("com.tencent.mobileqq");

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);


                    startActivity(intent);
                }
            });
            dialog.setqxOnListener(new GN_Dialog.qxOnListener() {
                @Override
                public void onqxclick() {

                }
            });
        }
    }

    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }
}
