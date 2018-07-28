package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class qq_z extends Activity {
    private ListView listView;
    private SimpleAdapter sa;
    private List<Map<String,Object>> datalist;

  private   int[]tp={R.drawable.tpa1,R.drawable.tpa2,R.drawable.tpa3,R.drawable.tpa4,R.drawable.tpa5,
          R.drawable.tpa5,R.drawable.tpa5,R.drawable.tpa5,R.drawable.tpa5};
   private  String[] bt1={"拉圈圈99+","空间蓝色字体","空间装逼代码","以别人名义发说说","QQ凶吉测试","123","456","聊天","称号"};
   private  String[] bt2={"","","手机型号/打赏代码等","","","123","456","聊天","呵呵"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_z);

        listView= (ListView) findViewById(R.id.qq_z_list);
        datalist=new ArrayList<Map<String,Object>>();
        sa=new SimpleAdapter(this,getsj(),R.layout.ys_zlist,new String[]{"tp","bt1","bt2"},
                new int[]{R.id.ys_z_tp,R.id.ys_z_t1,R.id.ys_z_t2});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent();
                switch (position) {
                    case 0:
                        in.setClass(qq_z.this,qq_lqq.class);
                        break;

                    case 1:
                        in.setClass(qq_z.this,qq_lszt.class);
                        break;

                    case 2:
                        in.setClass(qq_z.this,qq_kjsb.class);
                        break;

                    case 3:
                        in.setClass(qq_z.this,qq_ybrmyfss.class);
                        break;

                    case 4:
                        in.setClass(qq_z.this,qq_xjcs.class);
                        break;
                    case 5:
                        in.setClass(qq_z.this,gj_tszt.class);
                        break;
                    case 6:
                        in.setClass(qq_z.this,qq_cyxjc.class);
                        break;
                    case 7:
                        in.setClass(qq_z.this,qq_qzlt.class);
                        break;

                    case 8:
                        in.setClass(qq_z.this,qq_chdm.class);
                        break;

                }
                startActivity(in);
            }
        });


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
}
