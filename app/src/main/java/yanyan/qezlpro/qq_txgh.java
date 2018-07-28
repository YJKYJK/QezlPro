package yanyan.qezlpro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

/**
 * Created by Administrator on 2017/7/29 0029.
 */

public class qq_txgh extends Activity{
    private Tencent tencent ;
    private Button bbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_txgh);
        tencent= Tencent.createInstance("101413547",this);
        bbb= (Button) findViewById(R.id.bbb);


    }
    public void txgh_dl(View view)
    {


        tencent.login(this, "all", new IUiListener() {
            @Override
            public void onComplete(Object o) {

               // if(o==null)
               // {

               // }


               // else {
                //    Toast.makeText(qq_txgh.this,o.toString(), Toast.LENGTH_SHORT).show();
               // }

            }

            @Override
            public void onError(UiError uiError) {

            }

            @Override
            public void onCancel() {


            }
        });
    }
}
