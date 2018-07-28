package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.Tencent;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class qq_sswrz extends Activity {
    private EditText ssnr;
    private RadioButton rb1,rb2;
    private EditText rs;
    private Button b1,b2;
    ClipboardManager cp;
    GN_Dialog dialog;
    private Tencent tencent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_sswrz);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ssnr= (EditText) findViewById(R.id.sswrz_ssnr);
        rb1= (RadioButton) findViewById(R.id.sswrz_mrrs);
        rb2= (RadioButton) findViewById(R.id.sswrz_zdyrs);
        rs= (EditText) findViewById(R.id.sswrz_rs);
        b1= (Button) findViewById(R.id.sswrz_sc1);
        b2= (Button) findViewById(R.id.sswrz_sc2);
        tencent=Tencent.createInstance("100000001",this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked())
                {

                    fz(ssnr.getText().toString()+"\n\n\n{uin:3631,nick:?、TFboys、我很爱你、小米爱瞎子、如果能从来、上帝不会再来、七七八八、Birdy、小豆豆、各种坑、全是套路、ETasdf、假如能从来、你还爱我吗、世界很乱、妖孽还不快献身、 等17万人觉得很赞,who:1}");

                    ts(ssnr.getText().toString()+"\n\n\n{uin:3631,nick:?、TFboys、我很爱你、小米爱瞎子、如果能从来、上帝不会再来、七七八八、Birdy、小豆豆、各种坑、全是套路、ETasdf、假如能从来、你还爱我吗、世界很乱、妖孽还不快献身、 等17万人觉得很赞,who:1}");
                    //Toast.makeText(qq_sswrz.this,"生成成功且已复制，请到QQ空间粘贴发表", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(rs.getText().length()!=0) {
                        ts(ssnr.getText().toString() + "\n\n\n{uin:3631,nick:?、TFboys、我很爱你、小米爱瞎子、如果能从来、上帝不会再来、七七八八、Birdy、小豆豆、各种坑、全是套路、ETasdf、假如能从来、你还爱我吗、世界很乱、妖孽还不快献身、 等" + rs.getText().toString() + "人觉得很赞,who:1}");
                        //Toast.makeText(qq_sswrz.this,"生成成功且已复制，请到QQ空间粘贴发表", Toast.LENGTH_SHORT).show();
                        fz(ssnr.getText().toString() + "\n\n\n{uin:3631,nick:?、TFboys、我很爱你、小米爱瞎子、如果能从来、上帝不会再来、七七八八、Birdy、小豆豆、各种坑、全是套路、ETasdf、假如能从来、你还爱我吗、世界很乱、妖孽还不快献身、 等" + rs.getText().toString() + "人觉得很赞,who:1}");
                    }//{uin:3631,nick:?、TFboys、我很爱你、小米爱瞎子、如果能从来、上帝不会再来、七七八八、Birdy、小豆豆、各种坑、全是套路、ETasdf、假如能从来、你还爱我吗、世界很乱、妖孽还不快献身 等"&编辑框3.内容 &"人觉得很赞,who:1}

                    else{
                        Toast.makeText(qq_sswrz.this,"请输入人数", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb1.isChecked())
                {
                    Toast.makeText(qq_sswrz.this,"生成成功且已复制，请到QQ空间粘贴发表", Toast.LENGTH_SHORT).show();

                    fz("{uin:3631,nick:?、TFboys、我很爱你、小米爱瞎子、如果能从来、上帝不会再来、七七八八、Birdy、小豆豆、各种坑、全是套路、ETasdf、假如能从来、你还爱我吗、世界很乱、妖孽还不快献身、 等17万人觉得很赞,who:1}");

                }
                else{
                    if(rs.getText().length()!=0) {
                        Toast.makeText(qq_sswrz.this, "生成成功且已复制，请到QQ空间粘贴发表", Toast.LENGTH_SHORT).show();
                        fz("{uin:3631,nick:?、TFboys、我很爱你、小米爱瞎子、如果能从来、上帝不会再来、七七八八、Birdy、小豆豆、各种坑、全是套路、ETasdf、假如能从来、你还爱我吗、世界很乱、妖孽还不快献身、 等" + rs.getText().toString() + "人觉得很赞,who:1}");
                        //{uin:3631,nick:?、TFboys、我很爱你、小米爱瞎子、如果能从来、上帝不会再来、七七八八、Birdy、小豆豆、各种坑、全是套路、ETasdf、假如能从来、你还爱我吗、世界很乱、妖孽还不快献身 等"&编辑框3.内容 &"人觉得很赞,who:1}

                    }
                    else{
                        Toast.makeText(qq_sswrz.this,"请输入人数", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    rb2.setChecked(false);
                    rs.setVisibility(View.GONE);
                }

            }
        });

        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    rb1.setChecked(false);
                    rs.setVisibility(View.VISIBLE);
                }


            }
        });

    }
    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }

    private void ts(final String aa)
    {
        dialog=new GN_Dialog(qq_sswrz.this);
        dialog.setBt("生成成功");
        dialog.setXx("\n\n是否直接发送说说？\n\n");
        dialog.setQd("直接发送");
        dialog.setQx("复制");
        dialog.show();
        dialog.setqxOnListener(new GN_Dialog.qxOnListener() {
            @Override
            public void onqxclick() {
                fz(aa);
                Toast.makeText(qq_sswrz.this,"复制成功，请到QQ空间粘贴发表", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
            @Override
            public void onqdclick() {
                final Bundle params = new Bundle();
                params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzonePublish.PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD);
                params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY,aa);
                tencent.publishToQzone(qq_sswrz.this, params, null);

            }
        });
    }
}
