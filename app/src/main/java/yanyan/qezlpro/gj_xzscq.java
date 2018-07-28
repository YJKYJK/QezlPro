package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/2 0002.
 */

public class gj_xzscq extends Activity implements View.OnClickListener{
    private EditText editText;
    private Button fz,qk,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    private RadioButton r1,r2;
    private Boolean b;
   private gn_gj m;
    private ArrayAdapter<String> yfad,rqad,sjad;

    private Spinner yf,rq,sj;
    private List<String> yflist,rqlist,sjlist;

    ClipboardManager cp;

    private String[] yfzs={"㋀","㋁" ,"㋂", "㋃" , "㋄" , "㋅" , "㋆" , "㋇" , "㋈" , "㋉","㋊" ,"㋋"};
    private String[] rqzs={"㏠","㏡","㏢","㏣","㏤","㏥","㏦"
            ,"㏧","㏨","㏩","㏪","㏫","㏬","㏭","㏮","㏯","㏰","㏱",
            "㏲","㏳","㏴","㏵","㏶","㏷","㏸","㏹","㏺","㏻","㏼","㏽","㏾"};
    private String[] sjzs={"㍘","㍙","㍚","㍛","㍜","㍝","㍞","㍟","㍠","㍡","㍢","㍣","㍤","㍥","㍦","㍧","㍨","㍩ ","㍪","㍫","㍬","㍭","㍮","㍯","㍰"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_xzscq);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
       m=new gn_gj(gj_xzscq.this);
        init();
        b=true;




        yf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(editText.getText().toString()+yfzs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        rq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(editText.getText().toString()+rqzs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sj.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(editText.getText().toString()+sjzs[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                inia();
            }
        });





    }

    private void inia(){

        editText.setText("");
    }
    private void init() {
        editText= (EditText) findViewById(R.id.xzscq_jg);
        fz= (Button) findViewById(R.id.xzscq_fz);
        qk= (Button) findViewById(R.id.xzscq_qk);
       b1= (Button) findViewById(R.id.xzscq_1);
        b2= (Button) findViewById(R.id.xzscq_2);
        b3= (Button) findViewById(R.id.xzscq_3);
        b4= (Button) findViewById(R.id.xzscq_4);
        b5= (Button) findViewById(R.id.xzscq_5);
        b6= (Button) findViewById(R.id.xzscq_6);
        b7= (Button) findViewById(R.id.xzscq_7);
        b8= (Button) findViewById(R.id.xzscq_8);
        b9= (Button) findViewById(R.id.xzscq_9);
        b0= (Button) findViewById(R.id.xzscq_0);
        r1= (RadioButton) findViewById(R.id.xzscq_r1);
        r2= (RadioButton) findViewById(R.id.xzscq_r2);

        yf= (Spinner) findViewById(R.id.xzscq_yf);
        rq= (Spinner) findViewById(R.id.xzscq_rq);
       sj= (Spinner) findViewById(R.id.xzscq_sj);

        fz.setOnClickListener(this);
        qk.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);

        yflist=new ArrayList<>();
        for(int i=1;i<13;i++) {
            yflist.add(i+"月");
        }
        yfad=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,yflist);
        yfad.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        yf.setAdapter(yfad);


        rqlist=new ArrayList<>();
        for(int i=1;i<32;i++) {
            rqlist.add(i+"日");
        }
        rqad=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,rqlist);
        rqad.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        rq.setAdapter(rqad);

        sjlist=new ArrayList<>();
        for(int i=0;i<24;i++) {
            sjlist.add(i+"点");
        }
        sjad=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,sjlist);
        sjad.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
       sj.setAdapter(sjad);


    }

    @Override
    public void onClick(View v) {
        String nr=editText.getText().toString();

        String aa="";
        switch (v.getId())
        {
            case R.id.xzscq_fz:
             fz(nr);
            m.ts("复制成功");


                break;
            case R.id.xzscq_qk:
                aa="";
                nr="";break;
            case R.id.xzscq_0:
                if(r1.isChecked()){
                    aa="º";
                }
                else{
                    aa="₀";
                }
                break;
            case R.id.xzscq_1:
                if(r1.isChecked()){
                    aa="¹";
                }
                else{
                    aa="₁";
                }break;
            case R.id.xzscq_2:
                if(r1.isChecked()){
                    aa="²";
                }
                else{
                    aa="₂";
                }break;
            case R.id.xzscq_3:
                if(r1.isChecked()){
                    aa="³";
                }
                else{
                    aa="₃";
                }break;
            case R.id.xzscq_4:
                if(r1.isChecked()){
                    aa="⁴";
                }
                else{
                    aa="₄";
                }break;
            case R.id.xzscq_5:
                if(r1.isChecked()){
                    aa="⁵";
                }
                else{
                    aa="₅";
                }break;
            case R.id.xzscq_6:
                if(r1.isChecked()){
                    aa="⁶";
                }
                else{
                    aa="₆";
                }break;
            case R.id.xzscq_7:
                if(r1.isChecked()){
                    aa="⁷";
                }
                else{
                    aa="₇";
                }break;
            case R.id.xzscq_8:
                if(r1.isChecked()){
                    aa="⁸";
                }
                else{
                    aa="₈";
                }break;
            case R.id.xzscq_9:
                if(r1.isChecked()){
                    aa="⁹";
                }
                else{
                    aa="₉";
                }break;



            case R.id.xzscq_r1:
                if(r1.isChecked())
               r2.setChecked(false);
                b=true;
                break;



            case R.id.xzscq_r2:
                if(r2.isChecked())
                {
                    r1.setChecked(false);
                    b=false;
                }
                    break;



        }
        editText.setText(nr+aa);


    }
    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }
}
