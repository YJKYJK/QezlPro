package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/5/20 0020.
 */

public class qq_kjsb extends Activity {
    private Button b1,b2;
    private EditText e1;
    private CheckBox checkBox;
    private Spinner spinner;
    private SimpleAdapter sa;
    private List<Map<String,Object>> datalist;
    private ListView lv;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    ClipboardManager cp;

    private String[]dm={"QQ防艾特","红锁","黑锁","钻石","图片框",
            "链子","扭头","蜡烛","小红锁","玫瑰花","飞机","空间音乐","黄赞","#号","定位","拍照","返回","蓝赞",
            "@号","用户","红墙","小豹印"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_kjbs);
        spinner= (Spinner) findViewById(R.id.qjsb_spinner);
        checkBox= (CheckBox) findViewById(R.id.kjsb_sfls);
        e1= (EditText) findViewById(R.id.kjsb_xh);
        b1= (Button) findViewById(R.id.kjsb_sc);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        lv= (ListView) findViewById(R.id.kjsb_list);
        b2= (Button) findViewById(R.id.kjsb_sswrz);

        csh();
        list=new ArrayList<String>();
        list.add("安卓");
        list.add("苹果");
        list.add("ipad");
        list.add("手表");
        list.add("平板");
        list.add("电脑");
        list.add("笔记本");
        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(e1.getText().toString().length()!=0)
                {
                    if (checkBox.isChecked()) {

                        yls();
                        Toast.makeText(qq_kjsb.this,"生成成功，已复制", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        wls();
                        Toast.makeText(qq_kjsb.this,"生成成功，已复制", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(qq_kjsb.this,"您还没有输入设备型号", Toast.LENGTH_SHORT).show();
                }
            }
        });



//
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    try {
                        String dm2 = java.net.URLDecoder.decode("%14", "UTF-8");
                        fz(dm2);
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ群修改即可", Toast.LENGTH_SHORT).show();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                        break;
                    case 1:fz("[em]e10009[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 2:fz("[em]e10001[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 3:fz("[em]e328142[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 4:fz("[em]e10006[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 5:fz("[em]e10007[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 6:fz("[em]e110113[/em] [em]e110114[/em] [em]e110123[/em] [em]e110100[/em] [em]e110111[/em] [em]e110131[/em] [em]e110112[/em] [em]e110126[/em] [em]e110103[/em] [em]e110122[/em] [em]e110124[/em] [em]e110099[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 7:fz("[em]e10010[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 8:fz("[em]e10011[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 9:fz("[em]e10012[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 10:fz("[em]e10014[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 11:fz("[em]e10016[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 12:fz("[em]e10017[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 13:fz("[em]e10018[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 14:fz("[em]e10021[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 15:fz("[em]e10022[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 16:fz("[em]e10029[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 17:fz("[em]e10030[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 18:fz("[em]e10035[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 19:fz("[em]e10036[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 20:fz("送你一面墙。防火，防盗，防色狼！[em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em][em]e2219[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;
                    case 21:fz("[em]e328062[/em][em]e328062[/em][em]e328062[/em][em]e328062[/em][em]e328062[/em]");
                        Toast.makeText(qq_kjsb.this,"已复制，到QQ空间粘贴发布即可", Toast.LENGTH_SHORT).show();break;

                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(qq_kjsb.this,qq_sswrz.class);
                startActivity(intent);
            }
        });


    }

    private void csh() {
        datalist=new ArrayList<Map<String,Object>>();

        sa=new SimpleAdapter(this,getsj(),R.layout.ys_pt_list,new String[]{"ti"},new int[]{R.id.ys_textView});
        lv.setAdapter(sa);
    }

    private void yls(){
        //[em]e10005[/em]
       // [em]e10028[/em]{uin:3631,nick:123}

        switch (spinner.getSelectedItemPosition()){
            case 0:fz("[em]e10028[/em]" +"{uin:3631,nick:"+e1.getText().toString()+"}"); break;
            case 1:fz("[em]e10002[/em]" +"{uin:3631,nick:"+e1.getText().toString()+"}"); break;
            case 2:fz("[em]e10024[/em]" +"{uin:3631,nick:"+e1.getText().toString()+"}"); break;
            case 3:fz("[em]e10026[/em]" +"{uin:3631,nick:"+e1.getText().toString()+"}"); break;
            case 4:fz("[em]e10003[/em]" +"{uin:3631,nick:"+e1.getText().toString()+"}"); break;
            case 5:fz("[em]e10004[/em]" +"{uin:3631,nick:"+e1.getText().toString()+"}"); break;
            case 6:fz("[em]e10008[/em]" +"{uin:3631,nick:"+e1.getText().toString()+"}"); break;

        }

    }
    private void wls(){
        //[em]e10005[/em]
        // [em]e10028[/em]{uin:3631,nick:123}

        switch (spinner.getSelectedItemPosition()){
            case 0:fz("[em]e10028[/em]" +e1.getText().toString()); break;
            case 1:fz("[em]e10002[/em]" +e1.getText().toString()); break;
            case 2:fz("[em]e10024[/em]" +e1.getText().toString()); break;
            case 3:fz("[em]e10026[/em]" +e1.getText().toString()); break;
            case 4:fz("[em]e10003[/em]" +e1.getText().toString()); break;
            case 5:fz("[em]e10004[/em]" +e1.getText().toString()); break;
            case 6:fz("[em]e10008[/em]" +e1.getText().toString()); break;
        }

    }

    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }

    public List<Map<String,Object>> getsj() {
        for(int i=0;i<dm.length;i++)
        {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("ti",dm[i]+"代码");
            datalist.add(map);
        }
        return  datalist;
    }
    public void tzym(View view)
    {
        Intent intent=new Intent().setClass(qq_kjsb.this,qq_cjdm.class);
        startActivity(intent);
    }
}
