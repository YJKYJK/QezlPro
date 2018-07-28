package yanyan.qezlpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private GridView gridView;
    private SimpleAdapter sa;
    private List<Map<String,Object>> datalist;

    private long elong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView= (GridView) findViewById(R.id.sy);
        datalist=new ArrayList<Map<String,Object>>();
        sa=new SimpleAdapter(this,getsj()
                ,R.layout.ys_list,new String[]{"tp"},new int[]{R.id.imageView});
        gridView.setAdapter(sa);
        gridView.setOnItemClickListener(this);

    }

    private List<Map<String,Object>> getsj() {
        for(int i=0;i<20;i++)
        {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("tp",R.mipmap.a_1);
            datalist.add(map);
        }
        return  datalist;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int a=position;
        Intent intent=new Intent();


            switch (a)
            {
                case 0:
                    intent.setClass(MainActivity.this,qq_lszt.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent.setClass(MainActivity.this,qq_ybrmyfss.class);
                    startActivity(intent);
                    break;

                case 2:
                    intent.setClass(MainActivity.this,qq_xjcs.class);
                    startActivity(intent);
                    break;

                case 3:
                    intent.setClass(MainActivity.this,qq_lqq.class);
                    startActivity(intent);
                    break;

                case 4:
                    intent.setClass(MainActivity.this,qq_kjsb.class);
                    startActivity(intent);
                    break;

                case 5:
                    intent.setClass(MainActivity.this,qq_cjdm.class);
                    startActivity(intent);
                    break;

                case 6:
                    intent.setClass(MainActivity.this,qq_z.class);
                    startActivity(intent);
                    break;

                case 7:
                    intent.setClass(MainActivity.this,okhttp.class);
                    startActivity(intent);
                    break;

                case 8:
                    intent.setClass(this,gj_hcp.class);
                    startActivity(intent);
                    break;
            }



            Toast.makeText(MainActivity.this,"position"+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            if(System.currentTimeMillis()-elong>2000)
            {
                Toast.makeText(MainActivity.this,"再按一次退出", Toast.LENGTH_SHORT).show();
                elong= System.currentTimeMillis();
            }
            else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
