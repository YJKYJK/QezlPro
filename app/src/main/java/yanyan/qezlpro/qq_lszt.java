package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.internal.Util;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/**
 * Created by Administrator on 2017/5/17 0017.
 */

public class qq_lszt extends Activity {
    private EditText ss_e;
    private Button sc_b;
    ClipboardManager cp;
    private GN_Dialog dialog;
    private Tencent tencent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_lszt);
        ss_e= (EditText) findViewById(R.id.lszt_ss);
        sc_b= (Button) findViewById(R.id.lszt_sc);
        tencent=Tencent.createInstance("100000001",this);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        sc_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(ss_e.length()!=0) {
                     final String lszt=sclszt(ss_e.getText().toString());
                    dialog=new GN_Dialog(qq_lszt.this);
                    dialog.setBt("生成成功");
                    dialog.setXx("蓝色字体已生成成功，是否直接发送说说？");
                    dialog.setQd("直接发送");
                    dialog.setQx("复制");
                    dialog.show();
                    dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                        @Override
                        public void onqdclick() {


                            zjfs(lszt);
                        }
                    });

                    dialog.setqxOnListener(new GN_Dialog.qxOnListener() {
                        @Override
                        public void onqxclick() {

                            fz(lszt);
                            Toast.makeText(qq_lszt.this,"已复制，到QQ空间粘贴发表即可", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //Toast.makeText(qq_lszt.this,"生成成功且已复制，到QQ空间粘贴发表即可", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(qq_lszt.this,"您还没有输入说说内容", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public String sclszt(String a)
    {

        if(a.indexOf("\n")!=-1) {
            String[] b = a.split("\n");
            a="";
            for(int i=0;i<b.length;i++)
            {
                a=a+"{uin:3631,nick:"+b[i]+"}\n";
            }
        }

        else{
            a="{uin:3631,nick:"+ a + "}";
        }
        return a;
    }
    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }

    private void zjfs(String lszt)
    {
        //QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT
        //QzonePublish.PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD
        final Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE,QzonePublish.PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD);
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY,lszt);
        //params.putString(QzoneShare.SHARE_TO_QQ_TITLE, lszt);
        //params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL,null);
        //tencent.shareToQQ(qq_lszt.this, params, null);
        tencent.publishToQzone(qq_lszt.this, params, null);


    }
//    IUiListener fsjg=new IUiListener() {
//        @Override
//        public void onComplete(Object o) {
//            Toast.makeText(qq_lszt.this, "发送成功", Toast.LENGTH_SHORT).show();
//
//
//        }
//
//        @Override
//        public void onError(UiError uiError) {
//            Toast.makeText(qq_lszt.this, "分享取消", Toast.LENGTH_SHORT).show();
//
//        }
//
//        @Override
//        public void onCancel() {
//            Toast.makeText(qq_lszt.this, "分享取消2", Toast.LENGTH_SHORT).show();
//
//        }
//    };


}
