package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/21 0021.
 */

public class qq_cjdm extends Activity {
    ClipboardManager cp;

    private EditText e1,e2;
    private CheckBox c1,c2;
    private Button b1,b2;

    private EditText e3;
    private CheckBox c3;
    private Button b3;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.qq_cjdm);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        e1= (EditText) findViewById(R.id.cjdm_qs);
        c1= (CheckBox) findViewById(R.id.cjdm_mrqs);
        b1= (Button) findViewById(R.id.cjdm_sc);

        e2= (EditText) findViewById(R.id.cjdm_nr);
        c2= (CheckBox) findViewById(R.id.cjdm_mrnr);
        b2= (Button) findViewById(R.id.cjdm_sc2);


        c3= (CheckBox) findViewById(R.id.cjdm_mrnr2);
        e3= (EditText) findViewById(R.id.cjdm_cjdmnr);
        b3= (Button) findViewById(R.id.cjdm_sc3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked())
                {
                    fz("[em]e10033[/em]{uin:3631,nick: 打赏了666元红包,who:1}");
                    Toast.makeText(qq_cjdm.this,"生成成功，已自动复制", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(e1.getText().length()!=0)
                    {
                        fz("[em]e10033[/em]{uin:3631,nick: 打赏了"+e1.getText().toString()+"元红包,who:1}");
                        Toast.makeText(qq_cjdm.this,"生成成功，已自动复制", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(qq_cjdm.this,"您还没有输入打赏的金额", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c2.isChecked())
                {

                    fz("[em]e10033[/em]{uin:3631,nick: 打赏了一个冰淇淋,who:1}");
                    Toast.makeText(qq_cjdm.this,"生成成功，已自动复制", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    if(e2.getText().length()!=0)
                    {
                        fz("[em]e10033[/em]{uin:3631,nick: 打赏了一个"+e2.getText().toString() +",who:1}");
                        Toast.makeText(qq_cjdm.this,"生成成功，已自动复制", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(qq_cjdm.this,"您还没有输入打赏的金额", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c3.isChecked())
                {
                    fz("看你们 用的手机都是iPhone7s plus我挺羡慕的\n" +
                            "\n" +
                            "[em]e10026[/em]{uin:5720,nick:Apple Watch  电镀蓝 (8G),who:1}\n" +
                            "[em]e10022[/em] {uin:5720,nick:拍摄于07月20日,who:1}    {uin:5720,nick:美国白宫 天气：阴,who:1}\n" +
                            "[em]e10020[/em]{uin:5720,nick:乘坐于美国华盛顿国际机场USA527航班（A舱）,who:1}\n" +
                            "[em]e10023[/em]{uin:5720,nick:文字已通过美国华盛顿审核，请勿泄露。,who:1}\n" +
                            "[em]e10005[/em]{uin:1314,nick:iPhone8s plus,who:1}");
                    Toast.makeText(qq_cjdm.this,"生成成功，已自动复制", Toast.LENGTH_SHORT).show();
                }
                else {

                    if(e3.getText().length()!=0)
                    {
                        fz(e3.getText().toString()+"\n" +
                                "\n" +
                                "[em]e10026[/em]{uin:5720,nick:Apple Watch  电镀蓝 (8G),who:1}\n" +
                                "[em]e10022[/em] {uin:5720,nick:拍摄于07月20日,who:1}    {uin:5720,nick:美国白宫 天气：阴,who:1}\n" +
                                "[em]e10020[/em]{uin:5720,nick:乘坐于美国华盛顿国际机场USA527航班（A舱）,who:1}\n" +
                                "[em]e10023[/em]{uin:5720,nick:文字已通过美国华盛顿审核，请勿泄露。,who:1}\n" +
                                "[em]e10005[/em]{uin:1314,nick:iPhone8s plus,who:1}");
                        Toast.makeText(qq_cjdm.this,"生成成功，已自动复制", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(qq_cjdm.this,"您还没有输入内容", Toast.LENGTH_SHORT).show();

                    }
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

}
