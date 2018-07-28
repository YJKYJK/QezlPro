package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/15 0015.
 */

public class gj_cts extends Activity implements View.OnClickListener{
    private RadioButton wy,qy;
    private EditText sr;
    private TextView sc;
    private ProgressDialog p;

    private int ys=5;
    private int type=1;
    ClipboardManager cp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_cts);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        sr= (EditText) findViewById(R.id.cts_sr);
        sc= (TextView) findViewById(R.id.cts_sc);

        wy= (RadioButton) findViewById(R.id.cts_wy);
        qy= (RadioButton) findViewById(R.id.cts_qy);

        wy.setOnClickListener(this);
        qy.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cts_wy:if(wy.isChecked()) {qy.setChecked(false);}break;
            case R.id.cts_qy:if(qy.isChecked()){wy.setChecked(false);}break;
        }
    }

    public void cts_sc(View view)
    {
        if (wy.isChecked())
        {
            ys=5;
        }
        else {
            ys=7;
        }

if(sr.getText().toString().length()==0)
{
    Toast.makeText(gj_cts.this,"请输入要生成的内容", Toast.LENGTH_SHORT).show();
}
else {

    sccts();
}
    }

    private void sccts()
    {
        p=new ProgressDialog(this);
        p.setMessage("正在制作...");
        p.show();
        String url="http://www.cangtoushi.com.cn/?mywords="+sr.getText().toString()+"&type="+ys;
        OkHttpClient okHttpClient=new OkHttpClient();
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().url(url).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                p.dismiss();

            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.dismiss();
                final String res =response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String aa=new String(res.getBytes(),"UTF-8");
                            aa=aa.substring(aa.indexOf("\"shibox\" >"),aa.indexOf("</div>",aa.indexOf("\"shibox\" >")));
                            aa=aa.replace("<br>","");
                            aa=aa.replace("\"shibox\" >","");
                            aa=aa.replace(" ","");
                            aa=aa.replace("\t","");
                            sc.setText(aa);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });
    }
    public void cts_fz(View view)
    {
        fz(sc.getText().toString());
        Toast.makeText(gj_cts.this,"已复制成功", Toast.LENGTH_SHORT).show();
    }
    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }


}
