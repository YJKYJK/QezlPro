package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.Tencent;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class  qq_ybrmyfss extends Activity {
    private EditText yb_qq,yb_wm,yb_brss,yb_zjss;
    private Button b1;
    ClipboardManager cp;
    private Tencent tencent;
    private GN_Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_ybrnyfss);
        yb_qq= (EditText) findViewById(R.id.yb_qq);
        yb_wm= (EditText) findViewById(R.id.yb_wm);
        yb_brss= (EditText) findViewById(R.id.yb_ssnr);
        yb_zjss= (EditText) findViewById(R.id.yb_zjss);
        b1= (Button) findViewById(R.id.yb_sc);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        tencent=Tencent.createInstance("100000001",this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yb_qq.length()==0)
                {
                    Toast.makeText(qq_ybrmyfss.this,"您还没有输入QQ账号", Toast.LENGTH_SHORT).show();
                }
                else if(yb_wm.length()==0){

                    Toast.makeText(qq_ybrmyfss.this,"您还没有输入网名", Toast.LENGTH_SHORT).show();
                }
                else if(yb_brss.length()==0){
                    Toast.makeText(qq_ybrmyfss.this,"您还没有输入对方说说内容", Toast.LENGTH_SHORT).show();
                }
                else {
                    final String b = sc(yb_qq.getText().toString(), yb_wm.getText().toString(),
                            yb_brss.getText().toString(), yb_zjss.getText().toString());

                    dialog=new GN_Dialog(qq_ybrmyfss.this);
                    dialog.setBt("生成成功");
                    dialog.setXx("\n\n是否直接发送说说？\n\n");
                    dialog.setQd("直接发送");
                    dialog.setQx("复制");
                    dialog.show();
                    dialog.setqxOnListener(new GN_Dialog.qxOnListener() {
                        @Override
                        public void onqxclick() {
                            fz(b);
                            Toast.makeText(qq_ybrmyfss.this,"复制成功，请到QQ空间粘贴发表", Toast.LENGTH_SHORT).show();
                        }
                    });
                    dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                        @Override
                        public void onqdclick() {
                            final Bundle params = new Bundle();
                            params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzonePublish.PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD);
                            params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY,b);
                            tencent.publishToQzone(qq_ybrmyfss.this, params, null);

                        }
                    });
                    //Toast.makeText(qq_ybrmyfss.this,"生成成功且已复制，请到QQ空间粘贴发表", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private String sc(String qq, String wm, String dfss, String zjss)
    {
        String a;
        a=zjss+"\n{uin:"+qq+",nick:"+wm+"}："+dfss;
       // a=et4.getText().toString()+"\n{uin:"+et1.getText().toString()+
          //      ",nick:"+et2.getText().toString()+"}："+et3.getText().toString();


        return a;
    }
    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }
}
