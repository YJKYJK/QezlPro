package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.Tencent;
import com.umeng.analytics.MobclickAgent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class main extends Activity implements AdapterView.OnItemClickListener,View.OnClickListener{


private ImageButton i1,i2,i3,i4;
private double elong;
private String wyxx;

    private Tencent tencent ;

    private TextView t2;
    private ViewPager pager;
    private List<View> viewList = new ArrayList<View>();


    private ListView qq_list;
    private SimpleAdapter sa;
    private List<Map<String,Object>> datalist;
    private String[] bt1={"拉圈圈99+","QQ空间蓝色字体","QQ装逼代码集合","自定义分享","网警代码","王者荣耀空白名称生成器",
            "亮钻助手","以别人名义发说说","QQ凶吉测试","发起临时会话","撤回恶搞","恶搞音乐分享",
            "空间说说万人赞","绝版气泡","QQ靓号申请","QQ好友克隆","QQ群/好友恢复","QQ空间解除禁言"};
    private String[] bt2={"秒拉圈圈99+","QQ空间蓝色字体","QQ装逼代码集合","自定义分享","网警代码","王者荣耀空白名称生成器",
            "亮钻助手","以别人名义发说说","QQ凶吉测试","发起临时会话","撤回恶搞","恶搞音乐分享"
            ,"空间说说万人赞","绝版气泡","腾讯官方(网页）","腾讯官方(网页）","腾讯官方(网页）","腾讯官方(网页）"};
    private int[] tp={R.drawable.tpa1,R.drawable.tpa2,R.drawable.tpa3,R.drawable.tpa11,R.drawable.tpa12,R.drawable.tpa16,
            R.drawable.tpa13,R.drawable.tpa18,R.drawable.tpa5,R.drawable.tpa7,R.drawable.tpa8,R.drawable.tpa4,
            R.drawable.tpa9,R.drawable.tpa17,R.drawable.tpa9,R.drawable.tpa9,R.drawable.tpa9,R.drawable.tpa9,R.drawable.tpa9};


    private GridView gridView;
    private SimpleAdapter grid_sa;
    private List<Map<String,Object>> grid_datalist;
    private String[] sygj_bt={"小字生成器","特殊字体","火车票生成","个性二维码","网址缩短","扣字助手","IP/网站查询器","表白网页制作",
            "藏头诗制作","网页源码获取","淘宝优惠券","球球助手","装逼图片生成","付费音乐下载","视频桌面","软件资源"};
    private int[] sygj_tp ={R.drawable.tpb1,R.drawable.tpb2,R.drawable.tpb3,R.drawable.tpb4,R.drawable.tpb5,R.drawable.tpb6,R.drawable.tpb7
            ,R.drawable.tpb8,R.drawable.tpb9,R.drawable.tpb10,R.drawable.tpb11,R.drawable.tpb12,R.drawable.tpb13,
            R.drawable.tpb14,R.drawable.tpb15,R.drawable.tpb16};

    private int[] wd_tp={R.drawable.tpb1,R.drawable.tpb2,R.drawable.tpb3,R.drawable.tpb4,R.drawable.tpb6};
    private String[] wd_bt={"加入官方群","检测更新","关于软件","分享软件","下载文件"};



    private ListView wd_list;
    private SimpleAdapter wd_sa;
    private List<Map<String,Object>> wd_datalist;



    private GN_Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_jm);

        //友盟更新
        onResume();
        onPause();
//
//        GN_newdialog newdialog=new GN_newdialog(this);
//        newdialog.setnr("从手术室收拾收拾收拾收拾收拾收拾收拾cscscsssssssssssssssssssssssssssssssssssssssssssssssssssssssssc");
//        newdialog.show();
//        newdialog.setqdOnListener(new GN_newdialog.gbOnListener() {
//            @Override
//            public void onqdclick() {
//
//            }
//        });



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }

    //初始化
        init();
        init2();
        init3();
        init4();
        //QQ列表被点击
        qq_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String wz="";
                Intent in=new Intent();
                switch (position)
                {
                    case 0:in.setClass(main.this,qq_lqq.class); break;
                    case 1:in.setClass(main.this,qq_lszt.class); break;
                    case 2:in.setClass(main.this,qq_kjsb.class); break;
                    case 3:in.setClass(main.this,qq_zdyfx.class);  break;
                    case 4:in.setClass(main.this,qq_wjdm.class);break;
                    case 5:in.setClass(main.this,qq_wzrykbzt.class);break;
                    case 6:in.setClass(main.this,qq_lzzs.class);break;
                    case 7:in.setClass(main.this,qq_ybrmyfss.class);  break;
                    case 8:in.setClass(main.this,qq_xjcs.class);  break;
                    case 9:in.setClass(main.this,qq_qzlt.class);  break;
                    case 10:in.setClass(main.this,qq_chdm.class);break;
                    case 12:in.setClass(main.this,qq_sswrz.class);break;
                    //case 11:in.setClass(main.this,qq_jbqp.class);break;
                    case 11:in.setClass(main.this,qq_egfx.class);break;
                    case 13:in.setClass(main.this,qq_jbqp.class);break;
                   // case 13:in.setClass(main.this,qq_jbqp.class);break;

                   // case 11:in.setClass(main.this,qq_jbqp.class);break;
                    case 14:wz="http://zc.qq.com/chs/new.html";break;
                    case 15:wz="http://vip.qq.com/client/fr_index.html?ADTAG=vip.qq.com/freedom/freedom_clone.html&SNO=1456469489713";break;
                    case 16:wz="http://huifu.qq.com/";break;
                    case 17:wz="http://kf.qq.com/qzone/remove_qzone.html";break;



                }

                if (position>13 && position<18)
                {
                    Uri uri= Uri.parse(wz);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
                else {
                startActivity(in);
                }
            }
        });

        //实用工具点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent();
                switch (position)
                {
                    case 0:in.setClass(main.this,gj_xzscq.class); break;
                    case 1:in.setClass(main.this,gj_tszt.class); break;
                    case 2:in.setClass(main.this,gj_hcp.class); break;
                    case 3:in.setClass(main.this,gj_gxewm.class); break;
                    case 4:in.setClass(main.this,gj_wzsd.class); break;
                    case 5:in.setClass(main.this,gj_kzzs.class); break;
                    case 6:in.setClass(main.this,gj_ipcx.class); break;
                    case 7:in.setClass(main.this,gj_bbzz.class); break;
                    case 8:in.setClass(main.this,gj_cts.class); break;
                    case 9:in.setClass(main.this,gj_hqwyym.class); break;
                    case 10:in.setClass(main.this,gj_tbk.class); break;
                    case 11:in.setClass(main.this,gj_qqzs.class); break;
                   case 12:in.setClass(main.this,gj_zbtp.class); break;
                    //case 12:in.setClass(main.this,qq_txgh.class); break;
                    case 13:in.setClass(main.this,gj_ffyyxz.class); break;
                    case 14:in.setClass(main.this,gj_spzm.class); break;
                    case 15:in.setClass(main.this,gj_rjzy.class); break;




                }
                startActivity(in);

            }
        });

        //我的点击事件
        wd_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:joinQQGroup("i-TjXuOIgCffX1khTu8vV0vc4ggpOnEV");
                        break;
                    case 1:

                        if(wyxx!=null) {
                            String bbh = wyxx.substring(wyxx.indexOf("版本号=") + 4, wyxx.indexOf("=版本号"));
                            double bbh2 = Double.parseDouble(bbh);
                            if (getbbh() < bbh2) {
                                hqgg();

                            } else {
                              Toast.makeText(main.this, "无新版本", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            hqgg();
                        }break;
                    case 2:
                        gyrj();
                        break;

                    case 3:



                        if(wyxx!=null) {


                                String wz = wyxx.substring(wyxx.indexOf("更新链接=") + 5, wyxx.indexOf("=更新链接"));
                                fxrj(wz);

                        }
                        else {
                            fxrj("https://jq.qq.com/?_wv=1027&k=4CAg5QW");
                        }

                        break;

                    case 4:
                        Intent in=new Intent();
                        in.setClass(main.this,wd_xzlb.class);
                        startActivity(in);
                        break;

                }
            }
        });




//页面被改变
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

//页面被改变
            @Override
            public void onPageSelected(int position) {
                int c = pager.getCurrentItem();
                cshtp();
                switch (c) {
                    case 0:

                        i1.setBackgroundResource(R.drawable.sy1);
                        break;
                    case 1:
                        pager.setCurrentItem(1);
                        i2.setBackgroundResource(R.drawable.qqgj1);
                        break;
                    case 2:

                        i3.setBackgroundResource(R.drawable.sygj1);
                        break;
                    case 3:
                        pager.setCurrentItem(3);
                        i4.setBackgroundResource(R.drawable.wd1);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }




    //初始化
    public void init()
    {
        i1 = (ImageButton) findViewById(R.id.imageButton1);
        i2 = (ImageButton) findViewById(R.id.imageButton2);
        i3 = (ImageButton) findViewById(R.id.imageButton3);
        i4 = (ImageButton) findViewById(R.id.imageButton4);
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        cshtp();
        i1.setBackgroundResource(R.drawable.sy1);

        pager = (ViewPager) findViewById(R.id.fff);
        LayoutInflater fa = LayoutInflater.from(this);
        View v1 = fa.inflate(R.layout.main_sy, null);
        View v2 = fa.inflate(R.layout.main_qqgj, null);
        View v3 = fa.inflate(R.layout.main_sygj, null);
        View v4 = fa.inflate(R.layout.main_wd, null);

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        viewList.add(v4);
        mpa mpa1 = new mpa(viewList);
        pager.setAdapter(mpa1);

        t2= (TextView) v1.findViewById(R.id.sy_gg);

        qq_list= (ListView) v2.findViewById(R.id.qqgj_list);
        //t2.setText(hqgg());
        gridView= (GridView) v3.findViewById(R.id.sygj_gridview);
        wd_list= (ListView) v4.findViewById(R.id.wd_list);
        hqgg();
        tencent= Tencent.createInstance("101417006",this);



    }
    //初始化页面二
    private void init2() {


        datalist=new ArrayList<Map<String,Object>>();
       sa=new SimpleAdapter(this,getsj(),R.layout.ys_zlist,new String[]{"tp","bt1","bt2"},
               new int[]{R.id.ys_z_tp,R.id.ys_z_t1,R.id.ys_z_t2});
       qq_list.setAdapter(sa);
    }

    private void init3() {
       grid_datalist =new ArrayList<Map<String,Object>>();
        grid_sa=new SimpleAdapter(this,getgjsj(),R.layout.ys_zgive,new String[]{"tp","bt"},new int[]{R.id.ys_Image,R.id.ys_text});
        gridView.setAdapter(grid_sa);
    }

    //初始化页面3
    private void init4() {
        wd_datalist=new ArrayList<Map<String,Object>>();
        wd_sa=new SimpleAdapter(this,getwd_sj(),R.layout.ys_zlist,new String[]{"tp","bt1","bt2"},
                new int[]{R.id.ys_z_tp,R.id.ys_z_t1,R.id.ys_z_t2});
        wd_list.setAdapter(wd_sa);
    }









    //初始化图片
    private void cshtp() {
        i1.setBackgroundResource(R.drawable.sy2);
        i2.setBackgroundResource(R.drawable.qqgj2);
        i3.setBackgroundResource(R.drawable.sygj2);
        i4.setBackgroundResource(R.drawable.wd);


    }


//点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton1:
                pager.setCurrentItem(0);
                i1.setBackgroundResource(R.drawable.sy1);
                break;
            case R.id.imageButton2:
                pager.setCurrentItem(1);
                i2.setBackgroundResource(R.drawable.qqgj1);
                break;
            case R.id.imageButton3:
                pager.setCurrentItem(2);
                i3.setBackgroundResource(R.drawable.sygj1);
                break;
            case R.id.imageButton4:
                pager.setCurrentItem(3);
                i4.setBackgroundResource(R.drawable.wd1);
                break;
        }


    }
    public void jiaqun(View view)
    {
        joinQQGroup("i-TjXuOIgCffX1khTu8vV0vc4ggpOnEV");
    }

   //加群
    public boolean joinQQGroup(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivity(intent);
            return true;
        } catch (Exception e) {
            // 未安装手Q或安装的版本不支持
            return false;
        }
    }

   //友盟统计
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

   public int getbbh()

   {
      PackageManager manager=this.getPackageManager();
        try {
           PackageInfo info=manager.getPackageInfo(this.getPackageName(),0);
            int bbh=info.versionCode;



            return bbh;


        } catch (Exception e) {
           e.printStackTrace();
            return 100;
       }
   }


    public String getbbh2()

    {
        PackageManager manager=this.getPackageManager();
        try {
            PackageInfo info=manager.getPackageInfo(this.getPackageName(),0);
            String bbh=info.versionName;



            return bbh;


        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //获取公告/更新
  public void hqgg(){
      OkHttpClient okHttpClient=new OkHttpClient();

      Request.Builder builder=new Request.Builder();
      //http://kejishujuzhongw.flzhan.com/index.html
      //ttp://60.205.191.199/qezl
      final Request request=builder.get().url("http://kejishujuzhongw.flzhan.com/index.html").build();
      Call call=okHttpClient.newCall(request);
      call.enqueue(new Callback() {
          @Override
          public void onFailure(Request request, IOException e) {
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {

                          t2.setText("获取公告失败");



                  }
              });

          }

          @Override
          public void onResponse(Response response) throws IOException {
              final String res=response.body().string();

              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          GN_qzdwb qzdwb=new GN_qzdwb();
                          String aa=new String(res.getBytes(),"UTF-8");
                          aa=qzdwb.kshq2(aa,"{[","]}");
                          aa=aa.replace("<br  />","");

                          double bbh2=0;
                          wyxx=aa;

                          String bbh=qzdwb.kshq2(aa,"版本号=","=版本号");
                          if(bbh.length()==0)
                          {

                              hqgg2();

                          }
                          if(bbh.length()!=0)
                          {
                             bbh2= Double.parseDouble(bbh);
                          }
                          String res2=qzdwb.kshq2(aa,"公告=","=公告");
                          String gxnr=qzdwb.kshq2(aa,"更新内容=","=更新内容");
                          String gxlj=qzdwb.kshq2(aa,"更新链接=","=更新链接");

                         t2.setText(res2);
                          if(getbbh()<bbh2) {
                              gxts(gxnr, gxlj);
                          }



                      } catch (Exception e) {

                          hqgg2();
                          e.printStackTrace();
                      }

                  }
              });

          }
      });

  }

  public void cs(View view)
  {
      Intent in=new Intent();
      in.setClass(main.this,MainActivity.class);
      startActivity(in);
  }

    public List<Map<String,Object>> getsj() {
        for(int i=0;i<bt1.length;i++)
        {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("tp",tp[i]);
            map.put("bt1",bt1[i]);
            map.put("bt2",bt2[i]);
            datalist.add(map);
        }
        return  datalist;
    }

    private List<? extends Map<String,?>> getgjsj() {
        for(int i=0;i<sygj_bt.length;i++)
        {

            Map<String,Object> map=new HashMap<String,Object>();
            map.put("tp",sygj_tp[i]);
            map.put("bt",sygj_bt[i]);
            grid_datalist.add(map);
        }
        return  grid_datalist;
    }

    public List<? extends Map<String,?>> getwd_sj() {
        String[] wd_nr={"加入官方群","版本："+getbbh2(),"关于软件","分享软件","文件下载"};
        for(int i=0;i<wd_tp.length;i++)
        {

            Map<String,Object> map=new HashMap<String,Object>();
            map.put("tp",wd_tp[i]);
            map.put("bt1",wd_bt[i]);
            map.put("bt2",wd_nr[i]);
            wd_datalist.add(map);
        }
        return  wd_datalist;

    }

    //http://chengji.21qq.xin/



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            if(System.currentTimeMillis()-elong>2000)
            {
                Toast.makeText(main.this,"再按一次退出", Toast.LENGTH_SHORT).show();
                elong= System.currentTimeMillis();
            }
            else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    private void gxts(String gxnr, final String gxlj)
    {

            //  String gxnr=aa.substring(aa.indexOf("更新内容=") + 5, aa.indexOf("=更新内容"));
            // final String gxlj=aa.substring(aa.indexOf("更新链接=") + 5, aa.indexOf("=更新链接"));
            dialog=new GN_Dialog(main.this);
            dialog.setBt("更新提示");
            dialog.setXx(gxnr);
            dialog.setQd("马上更新");
            dialog.setQx("稍后更新");
            dialog.show();
            dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                @Override
                public void onqdclick() {
                    Uri uri= Uri.parse(gxlj);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
            });
            dialog.setqxOnListener(new GN_Dialog.qxOnListener() {
                @Override
                public void onqxclick() {

                }
            });

        }
        private void fxrj(String tzdz)
        {


            final Bundle params = new Bundle();
            params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
            params.putString(QQShare.SHARE_TO_QQ_TITLE, "企鹅助理");
            params.putString(QQShare.SHARE_TO_QQ_SUMMARY,  "我正在使用企鹅助理，里面有各类好玩的功能，你也来试试吧");
            params.putString(QQShare.SHARE_TO_QQ_TARGET_URL,tzdz);
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "https://ps.ssl.qhimg.com/sdmt/124_135_100/t0193a2198f757a2c76.jpg");

            tencent.shareToQQ(main.this, params, null);
        }


        private void gyrj()
        {
//
//            dialog=new GN_Dialog(main.this);
//            dialog.setBt("软件说明");
//            dialog.setXx("企鹅助理pro并不是企鹅助理升级版，只是作者学习另外一种语言时仿写企鹅助理，同时增加一些新功能和删除一些无用的功能\n企鹅助理以后不会更新，企鹅助理pro则会继续更新");
//            dialog.setQd("知道了");
//            dialog.setdialog2(0);
//            dialog.show();
//            dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
//                @Override
//                public void onqdclick() {
//                }
//            });
            GN_newdialog newdialog=new GN_newdialog(this);
            newdialog.setnr("企鹅助理pro并不是企鹅助理升级版，只是作者学习另外一种语言时仿写企鹅助理，同时增加一些新功能和删除一些无用的功能\n企鹅助理以后不会更新，企鹅助理pro则会继续更新");

            newdialog.setqdOnListener(new GN_newdialog.gbOnListener() {
                @Override
                public void onqdclick() {

                }
            });
            newdialog.show();

        }

//        private void tow()
//        {
//            List<B_qqgj> qqgj_sj=new ArrayList<B_qqgj>();
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa1,"拉圈圈99+","拉圈圈99+"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa2,"QQ空间蓝色字体","QQ空间蓝色字体"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa3,"QQ装逼代码集合","QQ装逼代码集合"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa11,"自定义分享","自定义分享"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa12,"网警代码","网警代码"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa16,"王者荣耀空白名称生成器","王者荣耀空白名称生成器"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa13,"亮钻助手","亮钻助手"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa3,"以别人名义发说说","以别人名义发说说"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa4,"QQ凶吉测试","QQ凶吉测试"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa5,"发起临时会话","发起临时会话"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa7,"撤回恶搞","撤回恶搞"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa8,"恶搞音乐分享","恶搞音乐分享"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa9,"空间说说万人赞","空间说说万人赞"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa9,"QQ靓号申请","QQ靓号申请"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa9,"QQ好友克隆","QQ好友克隆"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa9,"QQ群/好友恢复","QQ群/好友恢复"));
//            qqgj_sj.add(new B_qqgj(R.drawable.tpa9,"QQ空间解除禁言","QQ空间解除禁言"));
//        qq_list.setAdapter(new A_BaseAdapter(this,qqgj_sj));
//
//        }




//    private String[] bt1={"拉圈圈99+","QQ空间蓝色字体","QQ装逼代码集合","自定义分享","网警代码","王者荣耀空白名称生成器",
//            "亮钻助手","以别人名义发说说","QQ凶吉测试","发起临时会话","撤回恶搞","恶搞音乐分享",
//            "空间说说万人赞","QQ靓号申请","QQ好友克隆","QQ群/好友恢复","QQ空间解除禁言"};

//    private int[] tp={R.drawable.tpa1,R.drawable.tpa2,R.drawable.tpa3,R.drawable.tpa11,R.drawable.tpa12,R.drawable.tpa16,
//            R.drawable.tpa13,R.drawable.tpa3,R.drawable.tpa4,R.drawable.tpa5,R.drawable.tpa7,R.drawable.tpa8,
//            R.drawable.tpa9,R.drawable.tpa9,R.drawable.tpa9,R.drawable.tpa9,R.drawable.tpa9,R.drawable.tpa9};

    public void hqgg2() {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder();
        //http://kejishujuzhongw.flzhan.com/index.html
        //ttp://60.205.191.199/qezl
        final Request request = builder.get().url("http://60.205.191.199/qezl").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        t2.setText("获取公告失败");


                    }
                });

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String res = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            GN_qzdwb qzdwb = new GN_qzdwb();
                            String aa = new String(res.getBytes(), "UTF-8");
                            double bbh2 = 0;
                            wyxx = aa;
                            String bbh = qzdwb.kshq2(aa, "版本号=", "=版本号");
                            if (bbh.length() != 0) {
                                bbh2 = Double.parseDouble(bbh);
                            }
                            String res2 = qzdwb.kshq2(aa, "公告=", "=公告");
                            String gxnr = qzdwb.kshq2(aa, "更新内容=", "=更新内容");
                            String gxlj = qzdwb.kshq2(aa, "更新链接=", "=更新链接");

                            t2.setText(res2);
                            if (getbbh() < bbh2) {
                                gxts(gxnr, gxlj);
                            }


                        } catch (Exception e) {

                            e.printStackTrace();
                        }

                    }
                });

            }
        });

    }
}