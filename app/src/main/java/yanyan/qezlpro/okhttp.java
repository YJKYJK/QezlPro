package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


public class okhttp extends Activity {

    private Button b1;
    private TextView e1;
    private EditText t1,t2,t3;
    private ImageView iv;
    private ProgressDialog p,pd;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.okhttp);
        b1= (Button) findViewById(R.id.ok_b);
        e1= (TextView) findViewById(R.id.ok_t);
        t1= (EditText) findViewById(R.id.it);
        t2= (EditText) findViewById(R.id.it2);
        t3= (EditText) findViewById(R.id.it3);
        iv= (ImageView) findViewById(R.id.iv);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd=new ProgressDialog(okhttp.this);

                pd.setMessage("加载zzz");
                pd.show();
                try {

                    setProgressBarIndeterminateVisibility(true);
                    hq(t1.getText().toString(),t2.getText().toString());
                }
                catch (Exception e)
                {
                    Toast.makeText(okhttp.this,"网址错误", Toast.LENGTH_SHORT).show();
                    pd.cancel();
                }

            }
        });


    }
    private void hq(String wz, final String bm)

    {
        OkHttpClient okHttpClient=new OkHttpClient();

        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().url(wz).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        e1.setText("加载失败,请检查网络 ");
                        setProgressBarIndeterminateVisibility(false);
                    }
                });

            }
            @Override
            public void onResponse(Response response) throws IOException {
                final String res=response.body().string();
                pd.cancel();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String aa=new String(res.getBytes(),bm);
                            e1.setText(aa);
                            setProgressBarIndeterminateVisibility(false);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }


    public void hqtp(View view)
    {
        OkHttpClient okHttpClient=new OkHttpClient();

        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().url(t3.getText().toString()).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                InputStream in=response.body().byteStream();
                final Bitmap bitmap= BitmapFactory.decodeStream(in);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(bitmap);
                    }
                });

            }
        });


    }
    public void xs(View view)
    {
        p=new ProgressDialog(okhttp.this);

        p.setMessage("加载中...");
        p.setCancelable(false);
        p.show();
    }
}
