package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class gj_wzsd extends Activity {



    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    private EditText e,jg;

    private gn_hqwyym hq;
    private ProgressDialog p;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_wzsd);
        e= (EditText) findViewById(R.id.wzsd_wz);
        jg= (EditText) findViewById(R.id.wzsd_jg);
        spinner= (Spinner) findViewById(R.id.wzsd_ym);
        list=new ArrayList<String>();
        list.add("域名1：http://u6.gg");
        list.add("域名2：http://980.so");

        adapter=new ArrayAdapter<String>(gj_wzsd.this,R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



    }
    public void wzsd_sc(View v)
    {
        String aa=e.getText().toString();
        if(aa.length()==0){
            Toast.makeText(gj_wzsd.this,"请输入网址", Toast.LENGTH_LONG).show();
        }
        else {
            if(spinner.getSelectedItemPosition()==0)
            {
                hq("http://u6.gg/api.php?url="+aa,"UTF-8");
            }
            else {
                hq("http://980.so/api.php?url="+aa,"GBK");

            }






            }

        }

    public void hq(String wz, final String bm)
    {
        p = new ProgressDialog(gj_wzsd.this);
        p.setMessage("正在获取。。。");
        p.show();
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        final Request request = builder.get().url(wz).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                p.cancel();

            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.cancel();
                final String res = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                           jg.setText(new String(res.getBytes(), bm));
                        } catch (UnsupportedEncodingException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

            }
        });

    }
}
