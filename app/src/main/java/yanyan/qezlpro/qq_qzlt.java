package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class qq_qzlt extends Activity {
    private Button b1;
    private EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_qzlt);
        b1= (Button) findViewById(R.id.qzlt_lt);
        e1= (EditText) findViewById(R.id.qzlt_qq);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().length()!=0)
                {

                    Uri uri= Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin="+e1.getText().toString()+"&version=1&src_type=web&web_src=oicqzone.com");
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(qq_qzlt.this,"您还没有输入对方QQ号", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
