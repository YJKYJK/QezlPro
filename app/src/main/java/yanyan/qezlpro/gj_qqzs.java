package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import zhou.colorpalette.ColorSelectDialog;

/**
 * Created by Administrator on 2017/7/18 0018.
 */

public class gj_qqzs extends Activity {
    private int ztys;
    private Button ys;
    private EditText mc,lj;

    private ColorSelectDialog colorSelectDialog;

    private ProgressDialog p;
    private GN_Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_qqzs);
        ys= (Button) findViewById(R.id.qqzs_ys);
        mc= (EditText) findViewById(R.id.qqzs_mc);
        lj= (EditText) findViewById(R.id.qqzs_qqlj);
        ztys=-9700897;


    }
    public void qqzs_ysxz(View view)
    {
        if (colorSelectDialog == null) {
            colorSelectDialog = new ColorSelectDialog(this);
            colorSelectDialog.setOnColorSelectListener(new ColorSelectDialog.OnColorSelectListener() {
                @Override
                public void onSelectFinish(int color) {
                    ztys=color;
                    gj_qqzs.this.ys.setBackgroundColor(ztys);

                }
            });
        }
        colorSelectDialog.setLastColor(ztys);
        colorSelectDialog.show();
    }
    public void qqzs_sc(View view)
    {
        String a= Integer.toHexString(ztys);
        a=a.substring(2);
        a="["+a+"]"+mc.getText().toString();
        mc.setText(a);

    }
    public void qqzs_tj(View view)
    {
        p=new ProgressDialog(this);
        p.setMessage("正在提交数据");
        p.show();
        OkHttpClient okHttpClient=new OkHttpClient();


        FormEncodingBuilder formEncodingBuilder=new FormEncodingBuilder();
        RequestBody requestBody=formEncodingBuilder.add("inv_url",lj.getText().toString()).build();
        Request.Builder builder= new Request.Builder();
        Request request= builder.url("http://post.48qiu.com/").post(requestBody).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                p.dismiss();

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String res=response.body().string();
                p.dismiss();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String nm="";
                        try {
                            String aa=new String(res.getBytes(),"UTF-8");
                            String name=aa.substring(aa.indexOf("user_name\":\"")+12,aa.indexOf("\"",aa.indexOf("user_name\":\"")+13));
                            nm=zhz(name);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        dialog=new GN_Dialog(gj_qqzs.this);
                        dialog.setBt("提交成功");
                        dialog.setXx("尊敬的："+nm+"\n已提交成功\n3分钟后查看到账结果\n\n若未到账请检查以下几点：\n1.今天已获得30龙蛋\n2.今天已获得5个棒棒糖\n3.本周已获得20棒棒糖");

                        dialog.setQd("知道了");
                        dialog.setdialog2(0);
                        dialog.show();
                        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                            @Override
                            public void onqdclick() {

                            }
                        });
//                        try {
//                           // String aa=new String(res.getBytes(),"UTF-8");
//                           //String name=aa.substring(aa.indexOf("user_name\":\"")+12,aa.indexOf("\"",aa.indexOf("user_name\":\"")+13));
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
                    }
                });

            }
        });


    }
    private String zhz(String s)
    {
        int n=s.length()/6;
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0,j=2;i<n;i++,j+=6)
        {
            String code=s.substring(j,j+4);
            char c= (char) Integer.parseInt(code,16);
            stringBuffer.append(c);


        }
        return stringBuffer.toString();

    }
}
