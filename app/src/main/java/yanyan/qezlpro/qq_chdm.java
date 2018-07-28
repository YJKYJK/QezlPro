package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class qq_chdm extends Activity {

    private EditText e1,e2;
    private Button b1;
    private String yb;
    ClipboardManager cp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_chdm);
        e1= (EditText) findViewById(R.id.chdm_qz);
        e2= (EditText) findViewById(R.id.chdm_hz);
        b1= (Button) findViewById(R.id.chdm_sc);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


        yb=jiema("%E5%BC%80%E5%BF%83%E9%BC%A0%E2%80%AE%E6%8E%8C%E5%B7%B4%E4%B8%80%E4%BD%A0%E4%BA%86%E7%BB%99%E5%B9%B6%E2%80%AD");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().length()==0)
                {
                    Toast.makeText(qq_chdm.this,"请输入前缀", Toast.LENGTH_SHORT).show();
                }
                else if(e2.getText().length()==0)
                {
                    Toast.makeText(qq_chdm.this,"请输入后缀", Toast.LENGTH_SHORT).show();
                }
                else {

                    String a1="";
                     String jg=yb.replace("开心鼠", e1.getText().toString());
                    int b1=e2.getText().toString().length();
                    String hz=e2.getText().toString();

                    for(int i=b1;i>0;i--)
                    {
                        a1=a1+e2.getText().toString().substring(i-1,i);

                    }
                    jg=jg.replace("掌巴一你了给并",a1);
                    fz(jg);
                    Toast.makeText(qq_chdm.this,"生成成功，已自动复制，请到QQ内修改", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    private String jiema(String sj) {
        try {
            sj = java.net.URLDecoder.decode(sj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sj;
    }

    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }
}
