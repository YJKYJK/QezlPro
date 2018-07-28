package yanyan.qezlpro;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.show.api.ShowApiRequest;


public class qq_xjcs extends Activity {
    protected Handler mHandler =  new Handler();

    private EditText e1,e2;
    private Button b1;
    private String qqh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_xjcs);
        e1= (EditText) findViewById(R.id.xjcs_qq);
        e2= (EditText) findViewById(R.id.xjcs_jg);
        b1= (Button) findViewById(R.id.xjcs_cs);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().length()<=4)
                {
                    Toast.makeText(qq_xjcs.this,"QQ账号有误，请重新输入", Toast.LENGTH_SHORT).show();
                    e1.setText("");
                }
                else {
                    xjcs(e1.getText().toString());
                }
            }
        });

    }
    public void xjcs(String qq)

    {
        qqh=qq;
        new Thread(){
            @Override
            public void run() {
                final String res = new ShowApiRequest("http://route.showapi.com/863-1", "31895", "be852ccaa33f49209e50cc195b985580")
                        .addTextPara("qq",qqh).post();
                mHandler.post(new Thread(){
                    @Override
                    public void run() {
                        String res2 = res.substring(res.indexOf("\"[") + 1, res.indexOf("\"}}"));
                        res2 = res2.replace("\",\"score\":\"", "\n得分：");
                        res2 = res2.replace("\",\"grade\":\"", "\n凶吉：");
                        res2 = res2.replace("\",\"analysis\":\"", "\n点评：");
                        res2 = res2.replace("[", "类型：");
                        res2 = res2.replace("]，", "\n");
                        e2.setText(res2 + "  ");
                    }




                });
            }
        }.start();
    }
}
