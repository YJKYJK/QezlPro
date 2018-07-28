package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/3 0003.
 */

public class main_qidongye extends Activity {
    TextView t1,t2,t3;
    String bbh;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_qidongye);

        t1= (TextView) findViewById(R.id.xsrq);
        t2= (TextView) findViewById(R.id.xssj);
        t3= (TextView) findViewById(R.id.main_bbh);
        ztl();
        hqbbh();




       SimpleDateFormat cc=new SimpleDateFormat("HH:mm");
        SimpleDateFormat ee=new SimpleDateFormat("MM月dd日");
       Date cure=new Date(System.currentTimeMillis());
        t2.setText(cc.format(cure));
        t1.setText(ee.format(cure));
        t3.setText("企鹅助理Pro "+bbh);




        File file=new File("/mnt/sdcard/qezl");
        if(!file.exists())
        {
            file.mkdir();
        }
        else if(!file.isDirectory())

        {
            file.delete();
            file.mkdir();
        }





       Handler handler = new Handler();
       handler.postDelayed(new a(), 3000);

   }


    class a implements Runnable {
       public void run() {
            Intent intent = new Intent();
            intent.setClass(main_qidongye.this, main.class);
            startActivity(intent);
           main_qidongye.this.finish();


        }
    }

private void ztl()
{
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        // 设置状态栏透明
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 设置根布局的参数
        ViewGroup rootView = (ViewGroup) ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
        rootView.setFitsSystemWindows(true);
        rootView.setClipToPadding(true);
    }

}
private void hqbbh(){

    PackageManager manager=this.getPackageManager();
    try {
        PackageInfo info=manager.getPackageInfo(this.getPackageName(),0);
        bbh=info.versionName;
    } catch (PackageManager.NameNotFoundException e) {
        e.printStackTrace();
    }
}


}




