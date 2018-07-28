package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/7/14 0014.
 */

public class gj_ipcx extends Activity {

    private TextView t1;
    private EditText e1,e2;




    private OkHttpClient okHttpClient;
    private Request.Builder builder;
    private ProgressDialog p;

    private String a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_ipcx);

       okHttpClient=new OkHttpClient();
       builder=new Request.Builder();
        t1= (TextView) findViewById(R.id.ipcx_ipdz);
        e1= (EditText) findViewById(R.id.ipcx_dz);
        e2= (EditText) findViewById(R.id.ipcx_wz);
        ipdz();


    }

    private void ipdz()
    {
        p=new ProgressDialog(gj_ipcx.this);
        p.setMessage("正在加载...");
        p.show();
        final Request request=builder.get().url("http://m.tool.chinaz.com/ipsel?ip=").build();
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
                        String aa=null;
                         try {
                             aa = new String(res.getBytes(),"UTF-8");
                             String bb=aa.substring(aa.indexOf("您的IP地址：<b class=\"fontcolor02\">")+30,aa.indexOf("请输入IP或域名"));
                             String ip=bb.substring(0,bb.indexOf("</b>"));
                             String cc1=bb.substring(bb.indexOf("来自"),bb.indexOf("<input id="));
                             String cc=cc1.substring(cc1.indexOf("fontcolor02\">")+13,cc1.indexOf("</b></p>"));

                            // cc=cc.substring(cc.indexOf("来自:<b class=\"fontcolor02\">"),cc.indexOf("</b>"));
                             aa="您的IP地址："+ip+"\n"+cc;


                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        t1.setText(aa);
                    }
                });

            }
        });
    }

    public void ipcx_dzcx(View view)
    {
      a=e1.getText().toString();
        if(a.length()!=0)
        {
            dzcx();
        }
        else {
            Toast.makeText(gj_ipcx.this,"您还没有输入内容", Toast.LENGTH_SHORT).show();
        }


    }

    public void ipcx_bacx(View view)
    {

      b=e2.getText().toString();
        if(b.length()!=0)
        {
            bacx();
        }
        else {
            Toast.makeText(gj_ipcx.this,"您还没有输入内容", Toast.LENGTH_SHORT).show();
        }
    }



    private void dzcx()
    {
        p=new ProgressDialog(gj_ipcx.this);
        p.setMessage("正在获取...");
        p.show();
        final Request request=builder.get().url("http://m.tool.chinaz.com/ipsel?IP="+a).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

                p.cancel();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.cancel();
                final String res=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String aa;
                        try {
                            aa=new String(res.getBytes(),"UTF-8");
                             String aa1=aa.substring(aa.indexOf("IP查询结果"),aa.indexOf("回到顶部"));

                            if(aa1.indexOf("IP的物理位置")!=-1)
                            {
                                String aa2=aa1.substring(aa1.indexOf("IP的物理位置："),aa1.indexOf("数字地址："));
                                String wldz=aa2.substring(aa2.indexOf("02\">")+4,aa2.indexOf("</b></p>"));

                                String ipdz=aa2.substring(aa2.indexOf("01\">")+4,aa2.indexOf("</b></p>",aa2.indexOf("01\">")));
                                GN_Dialog dialog=new GN_Dialog(gj_ipcx.this);
                                dialog.setBt("查询结果");
                                dialog.setXx("物理IP地址：\n"+wldz+"\n"+"查询到的IP地址：\n"+ipdz);
                                dialog.setdialog2(0);
                                dialog.setQd("知道了");
                                dialog.show();
                                dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                                    @Override
                                    public void onqdclick() {

                                    }
                                });

                            }
                            else {
                                Toast.makeText(gj_ipcx.this,"请输入正确的内容", Toast.LENGTH_SHORT).show();
                            }


                           // GN_Dialog gn_dialog=new GN_Dialog(gj_ipcx.this);
//                            gn_dialog.setdialog2(0);
//                            gn_dialog.setBt("ts");
//                            gn_dialog.setXx(aa);
//                            gn_dialog.setQd("zdl");
//                            gn_dialog.show();
//                            gn_dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
//                                @Override
//                                public void onqdclick() {
//
//                                }
//                            });



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }

    private void bacx()
    {

        p=new ProgressDialog(gj_ipcx.this);
        p.setMessage("正在获取...");
        p.show();
        final Request request=builder.get().url("http://m.tool.chinaz.com/beian?s="+b).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

                p.cancel();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                p.cancel();
                final String res=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String aa;
                        try {
                            aa=new String(res.getBytes(),"UTF-8");
                            if(aa.indexOf("主办单位名称：")!=-1)
                            {
                            String aa1=aa.substring(aa.indexOf("主办单位名称："),aa.indexOf("该单位还备案了以下网站"));
                                String zbdw=aa1.substring(aa1.indexOf("or01\">")+6,aa1.indexOf("</b>"));
                                String dwxz=aa1.substring(aa1.indexOf("性质：")+26,aa1.indexOf("</b></p>",aa1.indexOf("性质：")));
                                String baxx=aa1.substring(aa1.indexOf("可证号：")+27,aa1.indexOf("</b></p>",aa1.indexOf("可证号：")));
                                String wzmc=aa1.substring(aa1.indexOf("网站名称：")+28,aa1.indexOf("</b></p>",aa1.indexOf("网站名称：")));
                                String wzzy=aa1.substring(aa1.indexOf("网站首页网址")+30,aa1.indexOf("</b></p>",aa1.indexOf("网站首页网址")));
                                String shsj=aa1.substring(aa1.indexOf("审核时间：")+28,aa1.indexOf("</b></p>",aa1.indexOf("审核时间：")));

                                String xx="单位名称:"+zbdw+"\n\n单位性质："+dwxz+"\n\n许可证号："+baxx+"\n\n网站名称："+wzmc+"\n\n首页网址："+wzzy+"\n\n审核时间："+shsj;

                                GN_Dialog dialog=new GN_Dialog(gj_ipcx.this);
                                dialog.setBt("查询结果");
                                dialog.setXx(xx);
                                dialog.setdialog2(0);
                                dialog.setQd("知道了");
                                dialog.show();
                                dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                                    @Override
                                    public void onqdclick() {

                                    }
                                });




                            }
                            else {

                                GN_Dialog dialog=new GN_Dialog(gj_ipcx.this);
                                dialog.setBt("查询结果");
                                dialog.setXx("该网站未备案或者网址不正确");
                                dialog.setdialog2(0);
                                dialog.setQd("知道了");
                                dialog.show();
                                dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                                    @Override
                                    public void onqdclick() {

                                    }
                                });

                            }


                            // GN_Dialog gn_dialog=new GN_Dialog(gj_ipcx.this);
//                            gn_dialog.setdialog2(0);
//                            gn_dialog.setBt("ts");
//                            gn_dialog.setXx(aa);
//                            gn_dialog.setQd("zdl");
//                            gn_dialog.show();
//                            gn_dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
//                                @Override
//                                public void onqdclick() {
//
//                                }
//                            });



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
}
