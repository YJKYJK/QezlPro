package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
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
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public class gj_ffyyxz extends Activity{
    private List<B_qqgj> gq;
    private ListView listView;
    private EditText ss;
    public List<String> yylj=new ArrayList<String>();
    private List<String>gqxx=new ArrayList<String>();
    private ProgressDialog p;


    private GN_dialog2 dialog2;
    private GN_Dialog dialog;



    private OkHttpClient okHttpClient=new OkHttpClient();
    private GN_qzdwb qzdwb;
    private String mlj;

    private String mgqxx;
    private String  xzlj;

    private int pt=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_ffyyxz);
        listView= (ListView) findViewById(R.id.ffyyxz_list);
        ss= (EditText) findViewById(R.id.ffyyxz_ss);

        gq=new ArrayList<B_qqgj>();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //Toast.makeText(gj_ffyyxz.this,yylj.get(position),Toast.LENGTH_SHORT).show();
                if(pt==-1)
                {
                    Toast.makeText(gj_ffyyxz.this,"错误",Toast.LENGTH_SHORT).show();
                }
                else if(pt==0) {
                    mlj = "http://tool.rainss.cn/qqmusic/" + yylj.get(position);
                    mgqxx = gqxx.get(position);
                    p = new ProgressDialog(gj_ffyyxz.this);
                    p.setMessage("正在加载");
                    hqxzxx();
                }
                else {

                    if(yylj.get(position).length()<=5)
                    {
                        Toast.makeText(gj_ffyyxz.this,"下载链接异常",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        hqkgyydz("http://api.guaqb.cn/api.php?kg="+yylj.get(position));
                        mgqxx = gqxx.get(position);
                        p = new ProgressDialog(gj_ffyyxz.this);
                        p.setMessage("正在加载");
                    }

                }

            }
        });


    }

    public void ffyyxz_qq(View view)
    {
        pt=0;
        if (ss.getText().toString().length()<=0)
        {
            Toast.makeText(gj_ffyyxz.this,"请输入音乐名称",Toast.LENGTH_SHORT).show();
        }
        else {
            qqyy();
        }
    }

    private void qqyy()
    {
        gq.clear();
        yylj.clear();
        gqxx.clear();
        String wz="http://tool.rainss.cn/qqmusic/search.php?keywords="+ss.getText().toString()+"&page=1";
        OkHttpClient okHttpClient=new OkHttpClient();
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().url(wz).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String res=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            int wz = 0;
                            String ym = new String(res.getBytes(), "UTF-8");
                            if (ym.length() < 20) {
                            }
                            else {
                                ym = ym.substring(ym.indexOf("搜索结果 - QQ音乐</div>"), ym.indexOf(">上一页</a>"));
                                qzdwb = new GN_qzdwb();
                                String[] aaa = qzdwb.kshq(ym, "</font><a href =\"", ">下载<");

                                for (int i = 0; i < aaa.length; i++) {
                                    String gm = qzdwb.kshq2(aaa[i], "\">", "</a>");
                                    String gs = qzdwb.kshq2(aaa[i], "</a> - ", "<button><");
                                    String lj = qzdwb.kshq2(aaa[i], "<button><a href =\"", "\"");
                                    gqxx.add(gm+"-"+gs);


                                    yylj.add(lj);
                                    gq.add(new B_qqgj(gm, gs));
                                }

//                            //List<String>gs=new ArrayList<String>();
//                            //List<String>gm=new ArrayList<String>();
//                            int ks = 0;
//                            int js = 0;

//
//                            String zf = ">下载<";
//                            int start = 0;
//                            int count = 0;
//                            while (ym.indexOf(zf,start) >= 0 && start < ym.length()) {
//                                count++;
//                                start = ym.indexOf(zf,start) + zf.length();
//                            }
//                            Toast.makeText(gj_ffyyxz.this,count+"",Toast.LENGTH_SHORT).show();
//
////
////                                String mym=ym.substring(ks,js);
//
//                            if (count == 0)
//                            {
//                                Toast.makeText(gj_ffyyxz.this,"抱歉，没有搜索到您要找的歌曲",Toast.LENGTH_SHORT).show();
//                            }
//                           for(int i=0;i<count;i++)
//                          {
//
//                              ks=ym.indexOf("<a href =\"\">",wz);
//                              js=ym.indexOf(">下载<",ym.indexOf("<a href =\"\">",wz));
//                              String mym=ym.substring(ks,js);
//                               wz=ym.indexOf(">下载<",wz)+4;
//                               String gm=mym.substring(mym.indexOf("href =\"\">")+9,mym.indexOf("</a> -",mym.indexOf("href =\"\">")+8));
//                              String gs=mym.substring(mym.indexOf("</a> - ")+6,mym.indexOf("<button>",mym.indexOf("</a> - ")));
//                              String lj=mym.substring(mym.indexOf("<button><a href =\"")+18,mym.indexOf("\"",mym.indexOf("<button><a href =\"")+18));
//                              //yylj.add(mym.substring(mym.indexOf("<a href =\"",mym.indexOf("<button>",mym.indexOf("</a> - "))),mym.indexOf("\">",mym.indexOf("<a href =\"",mym.indexOf("<button>",mym.indexOf("</a> - "))))));
//                            yylj.add(lj);
//                             gq.add(new B_qqgj(gm,gs));
//
//                         }


                                listView.setAdapter(new A_BaseAdapter(gj_ffyyxz.this, gq));

                            }
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }



                        }

                });


            }

        });

    }

    private void hqtp(String tp)
    {
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().
                url(tp)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final InputStream in=response.body().byteStream();
                final Bitmap bitmap= BitmapFactory.decodeStream(in);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dialog2=new GN_dialog2(gj_ffyyxz.this);
                        dialog2.setNr(bitmap,"歌曲下载",mgqxx,"下载","试听");
                        dialog2.show();
                        p.dismiss();
                        dialog2.setqdOnListener(new GN_Dialog.qdOnListener() {
                            @Override
                            public void onqdclick() {
                                yyxz();

                            }
                        });
                        dialog2.setqxOnListener(new GN_Dialog.qxOnListener() {
                            @Override
                            public void onqxclick() {
                                Toast.makeText(gj_ffyyxz.this,"暂无法试听，请直接下载",Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                });

            }
        });



    }
private void hqxzxx()
{
    Request.Builder builder=new Request.Builder();
    final Request request=builder.get().
            url(mlj)
            .build();
    Call call=okHttpClient.newCall(request);
    call.enqueue(new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {

        }

        @Override
        public void onResponse(Response response) throws IOException {
            final String res=response.body().string();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String ym=new String(res.getBytes(),"UTF-8");
                        qzdwb = new GN_qzdwb();
                       String tp= qzdwb.kshq2(ym,"<img src= \"","\" alt");
                        xzlj=qzdwb.kshq2(ym,"普通音质：<a href = '","'>OGG</a>");
                        hqtp(tp);

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    });

}
private void yyxz()
{
    if(xzlj.length()<=0)
    {
        Toast.makeText(gj_ffyyxz.this,"没有找到下载链接",Toast.LENGTH_SHORT).show();
    }
//    else {
//        Toast.makeText(gj_ffyyxz.this,xzlj+"",Toast.LENGTH_SHORT).show();
//    }
    else {
        Toast.makeText(gj_ffyyxz.this,"开始下载",Toast.LENGTH_SHORT).show();
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().
                url(xzlj)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(gj_ffyyxz.this,"下载异常",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final InputStream in=response.body().byteStream();
//                SimpleDateFormat cc=new SimpleDateFormat("MMddHHmmss");
//                Date cure=new Date(System.currentTimeMillis());
//                final String aaa=cc.format(cure);
                File file=new File("/mnt/sdcard/qezl/",mgqxx+".MP3");

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
                        Toast.makeText(gj_ffyyxz.this,"下载完成",Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

    }
}

//private void yybf()
//{
//
//    MediaPlayer player=new MediaPlayer();
//    try {
//        player.setDataSource(gj_ffyyxz.this,Uri.parse(xzlj));
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    Intent intent = new Intent(gj_ffyyxz.this, GN_music.class);
//    Bundle bundle = new Bundle();//实例化一个Bundle对象
//
//
//    bundle.putInt("msg",1);//把op的值放入到bundle对象中
//    intent.putExtras(bundle);//再把bundle对象放入intent对象中
//    startService(intent);

    //}
    public void ffyyxz_kgyy(View view)
    {
        pt=1;
        if(ss.getText().toString().length()<=0)
        {
            Toast.makeText(gj_ffyyxz.this,"请输入音乐名称",Toast.LENGTH_SHORT).show();
        }
        else {
            kgyyxz(ss.getText().toString());
        }
    }

    private void kgyyxz(String yym)
    {
        gq.clear();
        yylj.clear();
        gqxx.clear();
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().
                url("http://mobilecdn.kugou.com/api/v3/search/song?format=json&keyword="+yym+"&page=1&pagesize=30")
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                final String res=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                            int wz = 0;
                        String ym ="";
                        try {
                            ym = new String(res.getBytes(), "UTF-8");
                            if (ym.length() < 20) {
                            }
                            else {
                                qzdwb=new GN_qzdwb();
                              String[] mym =qzdwb.kshq(ym,"{\"pay_type_320\":0","\"},");
                                for(int i=0;i<mym.length;i++)
                                {
                                    String gm=qzdwb.kshq2(mym[i],"filename\":\"","\",\"");
                                    String gs=qzdwb.kshq2(mym[i],"singername\":\"","\",\"");
                                    String lj=qzdwb.kshq2(mym[i],"hash\":\"","\",\"");
                                    gqxx.add(gm+"-"+gs);
                                    yylj.add(lj);
                                    gq.add(new B_qqgj(gm, gs));
                                }
                                listView.setAdapter(new A_BaseAdapter(gj_ffyyxz.this,gq));
                            }
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }



                    }
                });

            }
        });

    }

    private void hqkgyydz(String yylj)
    {
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().
                url(yylj)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                final String res=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                       String ym ="";
                        try {
                            ym = new String(res.getBytes(), "UTF-8");
                            qzdwb=new GN_qzdwb();

                            ym=qzdwb.kshq2(ym,"http:/",".mp3");
                            ym="http:/"+ym+".mp3";
                            final String kgxzlj=ym;
                            xzlj=ym;

                            dialog=new GN_Dialog(gj_ffyyxz.this);
                            dialog.setBt(mgqxx);
                            dialog.setQd("下载");
                            dialog.setXx(ym);
                            dialog.setdialog2(0);
                            dialog.show();

                            dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                                @Override
                                public void onqdclick() {
                                 yyxz_kg(kgxzlj);


                                }
                            });
                            dialog.setqxOnListener(new GN_Dialog.qxOnListener() {
                                @Override
                                public void onqxclick() {

                                }
                            });
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }


                    }
                });
            }
        });
    }

    private void yyxz_kg(String kgxzlj)

    {
        if(kgxzlj.length()<=0)
        {
            Toast.makeText(gj_ffyyxz.this,"没有找到下载链接",Toast.LENGTH_SHORT).show();
        }
//    else {
//        Toast.makeText(gj_ffyyxz.this,xzlj+"",Toast.LENGTH_SHORT).show();
//    }
        else {
            kgxzlj=kgxzlj.replace("\\s","");
            kgxzlj=kgxzlj.replace("\n","");
            Toast.makeText(gj_ffyyxz.this,"开始下载",Toast.LENGTH_SHORT).show();
            Request.Builder builder=new Request.Builder();
            final Request request=builder.get().
                    url(kgxzlj)
                    .build();
            Call call=okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(gj_ffyyxz.this,"下载异常",Toast.LENGTH_SHORT).show();
                        }
                    });


                }

                @Override
                public void onResponse(Response response) throws IOException {
                    final InputStream in=response.body().byteStream();
//                SimpleDateFormat cc=new SimpleDateFormat("MMddHHmmss");
//                Date cure=new Date(System.currentTimeMillis());
//                final String aaa=cc.format(cure);
                    File file=new File("/mnt/sdcard/qezl/",mgqxx+".MP3");

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
                            Toast.makeText(gj_ffyyxz.this,"下载完成",Toast.LENGTH_SHORT).show();
                        }
                    });



                }
            });

        }


    }





}
