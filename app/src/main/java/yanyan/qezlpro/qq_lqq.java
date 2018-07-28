package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 */

public class qq_lqq extends Activity {
    private EditText e1,e2;
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    private Button b1;
    private String qqh="";

    private ProgressDialog p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTranslucent(this);
        setContentView(R.layout.qq_lqq);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 设置状态栏透明
//            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // 设置根布局的参数
//            ViewGroup rootView = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
//            rootView.setFitsSystemWindows(true);
//            rootView.setClipToPadding(true);
//        }




        e1= (EditText) findViewById(R.id.lqq_qq);
        e2= (EditText) findViewById(R.id.lqq_qq2);
        spinner= (Spinner) findViewById(R.id.lqq_spinner);
        b1= (Button) findViewById(R.id.lqq_ks);
        list=new ArrayList<String>();
        list.add("接口1");

        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aa=e1.getText().toString();
                String bb=e2.getText().toString();

                if(e1.length()==0 && e2.length()==0)
                {
                    Toast.makeText(qq_lqq.this,"请输入账号",Toast.LENGTH_SHORT).show();
                }

                if(aa.equals(bb))
                {
                    qqh=aa;

                   laqq(qqh);
                }
                else {
                    Toast.makeText(qq_lqq.this,"输入的账号不一致",Toast.LENGTH_SHORT).show();
                    e1.setText("");
                    e2.setText("");
                }
            }
        });


    }

    private void laqq(final String qq)
    {
        p=new ProgressDialog(qq_lqq.this);
        p.setMessage("正在提交");
        p.show();
        String jiekou="http://api.999qiu.cn/quan1/quan.php?jx=";


        OkHttpClient okHttpClient=new OkHttpClient();
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().url(jiekou+qq).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                laqq2(qq);

            }
        });

    }

    private void laqq2(String qq)
    {
        OkHttpClient okHttpClient=new OkHttpClient();


        FormEncodingBuilder formEncodingBuilder=new FormEncodingBuilder();
        RequestBody requestBody=formEncodingBuilder.add("qq",qq).build();
        Request.Builder builder= new Request.Builder();
        Request request= builder.url("http://quan.szzzjdb.com/").post(requestBody).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        GN_Dialog dialog=new GN_Dialog(qq_lqq.this);
                        dialog.setBt("提交成功");
                        dialog.setXx("QQ号已提交，请等待一分钟左右，请勿多次提交");
                        dialog.setQd("知道了");
                        dialog.setdialog2(0);
                        dialog.show();
                        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                            @Override
                            public void onqdclick() {

                            }
                        });

                    }
                });

            }
        });
    }
//    public static void setColor(Activity activity, int color) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 设置状态栏透明
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // 生成一个状态栏大小的矩形
//            View statusView = createStatusView(activity, color);
//            // 添加 statusView 到布局中
//            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
//            decorView.addView(statusView);
//            // 设置根布局的参数
//            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
//            rootView.setFitsSystemWindows(true);
//            rootView.setClipToPadding(true);
//        }
//    }

//    public static void setTranslucent(Activity activity) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 设置状态栏透明
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // 设置根布局的参数
//            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
//            rootView.setFitsSystemWindows(true);
//            rootView.setClipToPadding(true);
//        }
//    }
    private void tj()
    {
        switch (spinner.getSelectedItemPosition())
        {
            case 0:break;
            case 1:break;
            case 2:break;
            case 3:break;

        }
    }
}
