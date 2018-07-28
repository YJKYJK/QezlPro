package yanyan.qezlpro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.ant.liao.GifView;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public class gj_xktx extends Activity {
    private GifView gifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_xktx);
        gifView= (GifView) findViewById(R.id.gjf1);
       // gifView.setGifImage(R.drawable.gjfcs);
    }

    private void jz()
    {

        OkHttpClient okHttpClient=new OkHttpClient();
        FormEncodingBuilder formEncodingBuilder=new FormEncodingBuilder();
        RequestBody requestBody=formEncodingBuilder.add("id","1111").add("idi","jiqie").
                add("id1","9000").add("id2","394").add("id3","%23FF0000").add("id4","%23FFFFFF").add("id5","10").add("id6","jiqie")
                .add("id7","4444").add("id8","9005").add("id9","9001").add("id10","2222").add("id11","3332").add("id12","4000").build();
        Request.Builder builder= new Request.Builder();
        Request request= builder.url("http://www.jiqie.com/f/re70.php").post(requestBody).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final InputStream in=response.body().byteStream();
                File file=new File("/mnt/sdcard","gif.gif");
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
                        gifView.setGifImage(in);
                    }
                });

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        gifView.setGifImage(in);
//
//                    }
//                });

            }
        });
    }
    public void xktx_xs(View v)
    {
        jz();

    }
}
