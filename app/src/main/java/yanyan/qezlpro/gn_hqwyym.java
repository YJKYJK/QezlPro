package yanyan.qezlpro;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class gn_hqwyym {

    private String wz;
    private String lx;
    private Context context;
    public static String fhz="k";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            fhz=""+msg.arg1;
        }
    };




    private String tsxx;
    private ProgressDialog p;
    public gn_hqwyym(String wz, String lx, Context context, String tsxx)
    {
        this.wz=wz;
        this.lx=lx;
        this.context=context;
        this.tsxx=tsxx;

    }

    public String hq() {



        p = new ProgressDialog(context);
        p.setMessage(tsxx);
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

                final String res = response.body().string();
                fhz = new String(res.getBytes(), lx);

                Message message=new Message();
                message.arg1=88;
                handler.sendMessage(message);


//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            fhz= new String(res.getBytes(), lx);
//
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                });
                p.cancel();

            }
        });
        return fhz;

    }


    }

