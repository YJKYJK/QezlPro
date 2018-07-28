package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16 0016.
 */

public class gj_hqwyym extends Activity {
    private EditText wz;
    private Spinner spinner;
    private TextView ym;
    private String wzz;
    private String bm="UTF-8";


    private List<String> list;
    private ArrayAdapter<String> adapter;

    private ProgressDialog p;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_hqwyym);
        wz= (EditText) findViewById(R.id.hqwyym_wz);
        spinner= (Spinner) findViewById(R.id.hqwyym_bm);
        ym= (TextView) findViewById(R.id.hqwyym_ym);

        list=new ArrayList<String>();
        list.add("UTF-8");
        list.add("GBK");
        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



    }
    public void hqwyym_kshq(View view)
    {
        wzz=wz.getText().toString();
        if(wzz.length()!=0)
        {
            if(wzz.indexOf("http://")==-1 && wzz.indexOf("https://")==-1)
            {
                wzz="http://"+wzz;
            }
            if(spinner.getSelectedItemPosition()==0)
            {
                bm="UTF-8";
            }
            else {
                bm="GBK";
            }

            hqym();
        }


    }
    private void hqym(){
        p=new ProgressDialog(this);
        p.setMessage("正在获取...");
        p.show();
        String url=wzz;
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
              final String res=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String aa=new String(res.getBytes(),bm);
                            ym.setText(aa);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
}
