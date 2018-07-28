package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/4 0004.
 */

public class gj_kzzs extends Activity {
    private Handler handler=new Handler();
   private Runnable runnable;

    private TextView kzsd,ct,wcjd;
    private SeekBar jd;
    private ListView listview;
    private EditText mz;

    private List<String> list;
    private ArrayAdapter<String> adapter;


    private String nr;
    private String[] nrsz;
    private int gs;


    private int a=100;
    private int sd=2000;

    ClipboardManager cp;
    private GN_Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_kzzs);
        ct = (TextView) findViewById(R.id.kzzs_ct);
        jd= (SeekBar) findViewById(R.id.kzzs_jd);
        kzsd= (TextView) findViewById(R.id.kzzs_sd);
        listview= (ListView) findViewById(R.id.kzzs_lb);
        wcjd= (TextView) findViewById(R.id.kzzs_kzjd);
        mz= (EditText) findViewById(R.id.kzzs_mz);

        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        init();


        jd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress==0)
                {
                    sd=500;
                    kzsd.setText("速度： 0.5 秒");
                }
                else {
                    sd=progress*1000;
                    kzsd.setText("速度： "+progress+" 秒");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        runnable = new Runnable() {
            @Override
            public void run() {
                if(a<gs) {
                    fz(mz.getText().toString()+nrsz[a]);
                    a++;
                    handler.postDelayed(this, sd);
                    wcjd.setText("已完成："+a+"/"+gs);
                }
                else {
                    Toast.makeText(gj_kzzs.this,"词库已完毕", Toast.LENGTH_LONG).show();
                    handler.postDelayed(this, 0);
                    handler.removeCallbacks(runnable);

                }

            }

        };
    }





    private void init() {
   list=new ArrayList<String>();
        list.add("滚刀模式");
        list.add("殴打模式");
        list.add("被对方说垃圾");
        list.add("被对方说煞笔");
        list.add("被对方说软件");
        list.add("对方打草泥马");

        list.add("对方错字");
        list.add("对方刷屏");
        list.add("对方造谣");
        list.add("讽刺");
        list.add("讽刺对方人多");
        list.add("讽刺对方窝囊");


        adapter=new ArrayAdapter<String>(this,R.layout.ys_list_dh,list);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                a=0;
                GN_DQ dq=null;
                if(position<12) {
                    switch (position) {
                        case 0:
                            dq = new GN_DQ(gj_kzzs.this, "gd.txt");
                            break;
                        case 1:
                            dq = new GN_DQ(gj_kzzs.this, "od.txt");
                            break;
                        case 2:
                            dq = new GN_DQ(gj_kzzs.this, "lj.txt");
                            break;
                        case 3:
                            dq = new GN_DQ(gj_kzzs.this, "sb.txt");
                            break;
                        case 4:
                            dq = new GN_DQ(gj_kzzs.this, "rj.txt");
                            break;
                        case 5:
                            dq = new GN_DQ(gj_kzzs.this, "cnm.txt");
                            break;

                        case 6:
                            dq = new GN_DQ(gj_kzzs.this, "cz.txt");
                            break;
                        case 7:
                            dq = new GN_DQ(gj_kzzs.this, "sp.txt");
                            break;
                        case 8:
                            dq = new GN_DQ(gj_kzzs.this, "dfzy.txt");
                            break;
                        case 9:
                            dq = new GN_DQ(gj_kzzs.this, "fc.txt");
                            break;
                        case 10:
                            dq = new GN_DQ(gj_kzzs.this, "fcdfrd.txt");
                            break;
                        case 11:
                            dq = new GN_DQ(gj_kzzs.this, "fcdfwn.txt");
                            break;
                    }
                    nr = dq.DQ();
                    nrsz = nr.split("\\n");
                    gs = nrsz.length;
                    wcjd.setText("完成进度：0/"+gs);
                }
                else {


                }
                ct.setText("已选:"+listview.getItemAtPosition(position)+"\n共"+gs+"词");
            }
        });



    }





    public void kzzs_ks(View view) {
        if(nr!=null) {
            dialog =new GN_Dialog(gj_kzzs.this);
            handler.postDelayed(runnable, 10000);
            dialog.setBt("提示");
            dialog.setXx("将在10秒后自动复制，是否打开QQ？");
            dialog.setQd("取消");
            dialog.setQx("打开QQ");
            dialog.show();
            dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                @Override
                public void onqdclick() {

                }
            });
            dialog.setqxOnListener(new GN_Dialog.qxOnListener() {
                @Override
                public void onqxclick() {

                    Intent intent=new Intent();
                    PackageManager packageManager=gj_kzzs.this.getPackageManager();
                    intent=packageManager.getLaunchIntentForPackage("com.tencent.mobileqq");

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);


                 startActivity(intent);
                }
            });

        }
        else {
            dialog =new GN_Dialog(gj_kzzs.this);
            dialog.setBt("提示");
            dialog.setXx("您还没有选择词库");
            dialog.setQd("知道了");

        dialog.setdialog2(0);
            dialog.show();
            dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
                @Override
                public void onqdclick() {

                }
            });
        }
    }



    public void kzzs_tz(View v){
        handler.removeCallbacks(runnable);
        Toast.makeText(this,"已停止", Toast.LENGTH_SHORT).show();
    }

    public void kzzs_zzck(View v )
    {
       dialog =new GN_Dialog(gj_kzzs.this);
        dialog.setBt("提示");
        dialog.setXx("下版本更新");
        dialog.setQd("知道了");
        dialog.setdialog2(0);
        dialog.show();
        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
            @Override
            public void onqdclick() {

            }
        });



    }

    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }

}
