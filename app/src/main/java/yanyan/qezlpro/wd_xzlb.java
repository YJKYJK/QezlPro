package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.umeng.analytics.a.t;

/**
 * Created by Administrator on 2017/8/4 0004.
 */

public class wd_xzlb extends Activity{
    private ListView listView;
   private List<B_qqgj> wj;
    File[] files;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wd_xzlb);
        listView= (ListView) findViewById(R.id.wd_wjlb);
       wj=new ArrayList<B_qqgj>();

       files=new File("/mnt/sdcard/qezl").listFiles();
        for(int i=0;i<files.length;i++)
        {

            wj.add(new B_qqgj(files[i].getName(),""));


        }
        listView.setAdapter(new A_BaseAdapter(wd_xzlb.this,wj));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(wd_xzlb.this,"文件位置："+files[position].getAbsolutePath(),Toast.LENGTH_LONG).show();

            }
        });

    }





}
