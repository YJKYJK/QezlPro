package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
 * Created by Administrator on 2017/8/7 0007.
 */

public class gj_rjzy extends Activity{
    private ListView listView;
    private List<B_qqgj> wj=new ArrayList<B_qqgj>();

    private List<String>link=new ArrayList<String>();
    private OkHttpClient okHttpClient=new OkHttpClient();
    private ProgressDialog p;
    private GN_qzdwb qzdwb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_rjzy);
        listView= (ListView) findViewById(R.id.rjzy_lb);
        p=new ProgressDialog(gj_rjzy.this);
        p.setMessage("正在获取");
        p.show();
        init();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(link.get(position).length()!=0)
                {
                    Uri uri= Uri.parse(link.get(position));
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
            }
        });
    }
    private void init()
    {


        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().
                url("http://60.205.191.199/rjzy")
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

              final String res=  response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            p.dismiss();
                            String ym=new String(res.getBytes(),"UTF-8");
                            qzdwb=new GN_qzdwb();
                            String[] rj=qzdwb.kshq(ym,"[","]");
                            for(int i=0;i<rj.length;i++)
                            {
                          String mname  =qzdwb.kshq2(rj[i],"name:","link");
                                String mlink=qzdwb.kshq2(rj[i],"link:\"","\"");
                                link.add(mlink);
                                wj.add(new B_qqgj(mname,"点击下载"));
                            }
                            listView.setAdapter(new  A_BaseAdapter(gj_rjzy.this,wj));


                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
