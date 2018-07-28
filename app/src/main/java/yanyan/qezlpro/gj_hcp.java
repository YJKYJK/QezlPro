package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class gj_hcp extends Activity {

   private OkHttpClient okHttpClient=new OkHttpClient();
    private ImageView imageView;
    private ProgressDialog p;
    private EditText e1,e2,e3,e4,e5,e6,e7;
    private Spinner spinner;
    private RadioButton r1,r2;
    private Button b1,b2;
    private ArrayAdapter<String> adapter;
    private List<String> list;
    private InputStream bc;
    private Bitmap bitmap2;

    private Byte[] b;

    private String url="http://zemuo.com/paper/news/hcp/img.php?id=1&txt1=%E6%88%91%E5%BF%83%E9%87%8C&txt2=%E4%BD%A0%E5%BF%83%E9%87%8C&txt3=1314&txt4=2017021413:14&txt5=5&txt6=999.9&txt7=%E5%88%98%E5%A4%A7%E6%98%8E&txt8=6221261980****3144";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_hcp);
        imageView= (ImageView) findViewById(R.id.hcp_tp);

        init();
        e1= (EditText) findViewById(R.id.hcp_e1);
        e2= (EditText) findViewById(R.id.hcp_e2);
        e3= (EditText) findViewById(R.id.hcp_e3);
        e4= (EditText) findViewById(R.id.hcp_e4);
        e5= (EditText) findViewById(R.id.hcp_e5);
        e6= (EditText) findViewById(R.id.hcp_e6);
        e7= (EditText) findViewById(R.id.hcp_e7);
        r1= (RadioButton) findViewById(R.id.hcp_ls);
        r2= (RadioButton) findViewById(R.id.hcp_hs);
        spinner= (Spinner) findViewById(R.id.hcp_xibie);
        b1= (Button) findViewById(R.id.hcp_sc);
        b2= (Button) findViewById(R.id.hcp_bc);

        list=new ArrayList<String>();
        list.add("硬座");
        list.add("软座");
        list.add("一等座");
        list.add("二等座");
        list.add("商务");
        list.add("观观");
        list.add("包座");

        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(r1.isChecked())
                {
                    r2.setChecked(false);
                    url="http://zemuo.com/paper/news/hcp/img.php?id=1&txt1=%E6%88%91%E5%BF%83%E9%87%8C&txt2=%E4%BD%A0%E5%BF%83%E9%87%8C&txt3=1314&txt4=2017021413:14&txt5=5&txt6=999.9&txt7=%E5%88%98%E5%A4%A7%E6%98%8E&txt8=6221261980****3144";
                    init();
                }
            }
        });

        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(r2.isChecked())
                {
                    r1.setChecked(false);
                    url="http://zemuo.com/paper/news/hcp/img.php?id=2&txt1=%E6%88%91%E5%BF%83%E9%87%8C&txt2=%E4%BD%A0%E5%BF%83%E9%87%8C&txt3=1314&txt4=2016040112:12&txt5=5&txt6=999.9&txt7=%E5%88%98%E5%A4%A7%E6%98%8E&txt8=6221261980****3144";
                    init();
                }
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc();
            }
        });

    }





    private void init()
    {
        p=new ProgressDialog(this);
        p.setMessage("加载...");
        p.show();

        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().
                url(url)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                p.cancel();

            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.cancel();

                final InputStream in=response.body().byteStream();
                final Bitmap bitmap= BitmapFactory.decodeStream(in);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                        bitmap2=bitmap;
                    }
                });
            }
        });



    }

    private void sc()
    {

        String qd,zd,cc,fcsj,jg,xm,sfz;
        int ys=1,xb=spinner.getSelectedItemPosition()+1;
        qd=e1.getText().toString();
        zd=e2.getText().toString();
        cc=e3.getText().toString();
        fcsj=e4.getText().toString();
        jg=e5.getText().toString();
        xm=e6.getText().toString();
        sfz=e7.getText().toString();
        if(r1.isChecked())
        {
            ys=1;
        }
        else
        {
            ys=2;
        }




        url="http://zemuo.com/paper/news/hcp/img.php?id="+ys+"&txt1="+qd+"&txt2="+
        zd+"&txt3="+cc+"&txt4="+fcsj+"&txt5="+xb+"&txt6="+jg+"&txt7="+xm+"&txt8="+sfz;

        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().
                url(url)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                p.cancel();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.cancel();
                final InputStream in=response.body().byteStream();
                bc=in;
                final Bitmap bitmap= BitmapFactory.decodeStream(in);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });

                in.close();

            }
        });

    }
    public void bctp(View view) {
        p.show();

        String qd,zd,cc,fcsj,jg,xm,sfz;
        int ys=1,xb=spinner.getSelectedItemPosition()+1;
        qd=e1.getText().toString();
        zd=e2.getText().toString();
        cc=e3.getText().toString();
        fcsj=e4.getText().toString();
        jg=e5.getText().toString();
        xm=e6.getText().toString();
        sfz=e7.getText().toString();
        if(r1.isChecked())
        {
            ys=1;
        }
        else
        {
            ys=2;
        }




        url="http://zemuo.com/paper/news/hcp/img.php?id="+ys+"&txt1="+qd+"&txt2="+
                zd+"&txt3="+cc+"&txt4="+fcsj+"&txt5="+xb+"&txt6="+jg+"&txt7="+xm+"&txt8="+sfz;

        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().
                url(url)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                p.cancel();
                Toast.makeText(gj_hcp.this,"图片下载异常", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.cancel();

                final InputStream in=response.body().byteStream();

                //获取系统时间
                SimpleDateFormat cc=new SimpleDateFormat("MMddHHmmss");
                Date cure=new Date(System.currentTimeMillis());
                final String aaa=cc.format(cure);
                        //t2.setText(cc.format(cure));

                File file=new File("/mnt/sdcard",aaa+".png");

                byte[] buf=new byte[128];
                FileOutputStream fos=new FileOutputStream(file);
                int len=0;

                while ((len=in.read(buf))!=-1){
                    fos.write(buf,0,len);

                }
                fos.flush();
                fos.close();
                in.close();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(gj_hcp.this,aaa, Toast.LENGTH_LONG).show();
                        Toast.makeText(gj_hcp.this,"保存成功", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

    }

//    public void bctp(View view) {
//
//            File file = new File(Environment.getExternalStorageDirectory()+"image");
//            FileOutputStream out;
//            try{
//                out = new FileOutputStream(file);
//                if(bitmap2.compress(Bitmap.CompressFormat.PNG,70,out))
//                {
//                    out.flush();
//                    out.close();
//                }
//            }
//            catch (FileNotFoundException e)
//            {
//                e.printStackTrace();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }



}
