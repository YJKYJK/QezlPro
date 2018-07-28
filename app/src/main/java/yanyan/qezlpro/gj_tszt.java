package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class gj_tszt extends Activity implements View.OnClickListener{
    private Button b1,b2,b5,b3,b4,b6,b7,b8,b9,b10,b11,b12,b13,b14;
    private EditText e1;
    private ClipboardManager cp;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_tszt);
        cp= (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        init();

    }
    private void init() {
        b1= (Button) findViewById(R.id.tszt_b1);
        b2= (Button) findViewById(R.id.tszt_b2);
        b3= (Button) findViewById(R.id.tszt_b3);
        b4= (Button) findViewById(R.id.tszt_b4);
        b5= (Button) findViewById(R.id.tszt_b5);
        b6= (Button) findViewById(R.id.tszt_b6);
        b7= (Button) findViewById(R.id.tszt_b7);
        b8= (Button) findViewById(R.id.tszt_b8);
        b9= (Button) findViewById(R.id.tszt_b9);
        b10= (Button) findViewById(R.id.tszt_b10);
        b11= (Button) findViewById(R.id.tszt_b11);
        b12= (Button) findViewById(R.id.tszt_b12);
        b13= (Button) findViewById(R.id.tszt_b13);
        b14= (Button) findViewById(R.id.tszt_b14);
        e1= (EditText) findViewById(R.id.tszt_jg);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);

        b1.setText(jiema("%20%E5%88%A0%CC%B6%20%E9%99%A4%CC%B6%20%E7%AC%A6%CC%B6%20%E5%8F%B7%CC%B6"));
        b2.setText(jiema("%20%E7%A6%81%E2%83%A0%20%E6%AD%A2%E2%83%A0%20"));
        b3.setText(jiema("%EA%A7%81%E7%BF%85%E8%86%80%EA%A7%82%20"));
        b4.setText(jiema("%20%E6%A1%86%E2%83%A2%E6%A1%86"));
        b5.setText(jiema("%20%E0%B8%B1%CD%A1%CE%B6%E0%B8%B1%CD%A1%20%E8%8A%B1%20%E0%B8%B1%CD%A1%CE%B6%E0%B8%B1%CD%A1%20%E8%97%A4%E0%B8%B1%CD%A1%E0%B8%B1%CD%A1%E2%9C%BE"));
        b6.setText(jiema("%E2%84%B3%E2%84%93%E6%96%87%E2%84%B3%E2%84%93%E5%AD%97"));
        b7.setText(jiema("%E2%9D%A6%E5%8F%B6%E2%9D%A7%E2%9D%A6%E5%AD%90%E2%9D%A7%E2%9D%A6"));
        b8.setText(jiema("%D2%89%E8%8F%8A%D2%89%D2%89%E8%8A%B1%D2%89%D2%89%E6%96%87%D2%89%D2%89%E5%AD%97%D2%89"));
        b9.setText(jiema("%E5%B8%A6%DB%A3%DB%96%E0%B8%B4%E0%B8%B4%DB%A3%DB%96%E0%B8%B4%E5%88%BA%DB%A3%DB%96%E0%B8%B4%E0%B8%B4%DB%A3%DB%96%E0%B8%B4%E6%96%87%DB%A3%DB%96%E0%B8%B4%E0%B8%B4%DB%A3%DB%96%E0%B8%B4%E5%AD%97%DB%A3%DB%96%E0%B8%B4%E0%B8%B4%DB%A3%DB%96%E0%B8%B4"));
        b10.setText(jiema("%E0%BC%84%E9%A3%9E%E0%BF%86%E0%BE%82%E8%A1%8C%E0%BF%86%E0%BE%82%E0%BF%86%E0%BE%82%E0%BF%90"));
        b11.setText("空白网名");
        b12.setText(jiema("%E2%9C%85%E5%B7%B2%E8%AE%A4%E8%AF%81%F0%9F%92%AF"));
        b13.setText(jiema("防艾特网名"));
        b14.setText(jiema("符号大全"));





    }

    @Override
    public void onClick(View v) {
        String nr=e1.getText().toString();
        int a=v.getId();
        switch (a)
        {
            case R.id.tszt_b1:scfh(nr); break;
            case R.id.tszt_b2:jzfh(nr); break;
            case R.id.tszt_b3:cbfh(nr); break;
            case R.id.tszt_b4:kkfh(nr); break;
            case R.id.tszt_b5:htfh(nr); break;
            case R.id.tszt_b6:mfh(nr); break;
            case R.id.tszt_b7:yzfh(nr); break;
            case R.id.tszt_b8:jhfh(nr); break;
            case R.id.tszt_b9:dcfh(nr); break;
            case R.id.tszt_b10:fxfh(nr); break;
            case R.id.tszt_b11:kbwm(); break;
            case R.id.tszt_b12:yrz(nr); break;
            case R.id.tszt_b13:fat(nr); break;
            case R.id.tszt_b14:tsfh(); break;
        }

    }


    private String jiema(String sj)
    {
        try {
            sj=java.net.URLDecoder.decode(sj, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sj;
    }
    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }

    private void ts(String ts)
    {
        Toast.makeText(gj_tszt.this,ts, Toast.LENGTH_SHORT).show();
    }

    private void scfh(String nr)
    {
        String a1,a2,a3="";
        int b1,b2,b3;

        if(e1.length()!=0) {
            a1= jiema("%CC%B6");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
               a2=nr.substring(i,i+1);
                a3=a3+" "+a2+a1;

            }
            fz(a3);
            e1.setText(a3);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void cbfh(String nr)
    {
        String a1,a2;
        if(nr.length()!=0) {
            a1= jiema("%EA%A7%81");
            a2=jiema("%EA%A7%82%20");
            fz(a1+nr+a2);
            e1.setText(a1+nr+a2);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void kkfh(String nr)
    {
        String a1,a2,a3="";
        int b1,b2,b3;

        if(nr.length()!=0) {
            a1= jiema("%E2%83%A2");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
                a2=nr.substring(i,i+1);
                a3=a3+" "+a2+a1+".\n";

            }
            fz(a3);
            e1.setText(a3);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void htfh(String nr)
    {
        String a1,a2,a3="";
        int b1,b2,b3;

        if(nr.length()!=0) {
            a1= jiema("%20%E0%B8%B1%CD%A1%CE%B6%E0%B8%B1%CD%A1%20");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
                a2=nr.substring(i,i+1);
                a3=a3+a1+a2;

            }
            fz(a3+jiema("%E0%B8%B1%CD%A1%E0%B8%B1%CD%A1%E2%9C%BE"));
            e1.setText(a3+jiema("%E0%B8%B1%CD%A1%E0%B8%B1%CD%A1%E2%9C%BE"));
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void mfh(String nr)
    {
        String a1,a2,a3="";
        int b1,b2,b3;

        if(nr.length()!=0) {
            a1= jiema("%E2%84%B3%E2%84%93");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
                a2=nr.substring(i,i+1);
                a3=a3+a1+a2;

            }
            fz(a3);
            e1.setText(a3);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void jzfh(String nr)
    {
        String a1,a2,a3="";
        int b1;

        if(nr.length()!=0) {
            a1= jiema("%E2%83%A0");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
                a2=nr.substring(i,i+1);
                a3=a3+" "+a2+a1;

            }
            fz(a3);
            e1.setText(a3);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void yzfh(String nr)
    {
        String a1,a2,a3="";
        int b1,b2,b3;

        if(nr.length()!=0) {
            a1= jiema("%E2%9D%A7%E2%9D%A6");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
                a2=nr.substring(i,i+1);
                a3=a3+a2+a1;

            }
            fz(jiema("%E2%9D%A6")+a3);
            e1.setText(jiema("%E2%9D%A6")+a3);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void jhfh(String nr)
    {
        String a1,a2,a3="";
        int b1,b2,b3;

        if(nr.length()!=0) {
            a1= jiema("%D2%89");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
                a2=nr.substring(i,i+1);
                a3=a3+a1+a2+a1;

            }
            fz(a3);
            e1.setText(a3);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void dcfh(String nr)
    {
        String a1,a2,a3="";
        int b1,b2,b3;

        if(nr.length()!=0) {
            a1= jiema("%DB%A3%DB%96%E0%B8%B4%E0%B8%B4%DB%A3%DB%96%E0%B8%B4");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
                a2=nr.substring(i,i+1);
                a3=a3+a2+a1;

            }
            fz(a3);
            e1.setText(a3);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void fxfh(String nr)
    {
        String a1,a2,a3="";
        int b1,b2,b3;

        if(nr.length()!=0) {
            a1= jiema("%E0%BF%86%E0%BE%82");
            b1=nr.length();
            for(int i=0;i<b1;i++)
            {
                a2=nr.substring(i,i+1);
                a3=a3+a2+a1;
            }
            a3=jiema("%E0%BC%84")+a3+jiema("%E0%BF%86%E0%BE%82%E0%BF%90");
            fz(a3);
            e1.setText(a3);
            ts("生成成功,已复制");
        }

        else{
            ts("请输入内容");
        }
    }

    private void kbwm()
    {
        String a;
        a=jiema("%E3%80%80");
        e1.setText(a+a);
        fz(e1.getText().toString());
        ts("生成成功,已复制");

    }

    private void yrz(String nr)
    {
        String a;
        a=jiema("%E2%9C%85%E5%B7%B2%E8%AE%A4%E8%AF%81%F0%9F%92%AF");
        e1.setText(nr+a);
        fz(e1.getText().toString());
        ts("生成成功,已复制");

    }

    private void fat(String nr)
    {
        String a;
        a=jiema("%14");
        e1.setText(nr+a);
        fz(e1.getText().toString());
        ts("生成成功,已复制");

    }
    private void tsfh()
    {
        String a=jiema("%F0%9F%87%A6%F0%9F%87%A7%F0%9F%87%A8%F0%9F%87%A9%F0%9F%87%AA%F0%9F%87%AB%F0%9F%87%AC%F0%9F%87%AD%F0%9F%87%AE%F0%9F%87%AF%F0%9F%87%B0%F0%9F%87%B1%F0%9F%87%B2%F0%9F%87%B3%F0%9F%87%B4%F0%9F%87%B5%F0%9F%87%B6%F0%9F%87%B7%F0%9F%87%B8%F0%9F%87%B9%F0%9F%87%BA%F0%9F%87%BB%F0%9F%87%BC%F0%9F%87%BD%F0%9F%87%BE%F0%9F%87%BF");
        a=a+jiema("%E0%AE%90%20%E0%B9%91%20%C2%A0%EF%BB%AC%20%C2%A0%E2%82%AA%20%E0%AF%B5%20%E0%AF%AB%20%E0%AE%86%20%E0%AF%B0%20%E0%AE%92%20%E0%AE%A3%20%E0%B9%91%20%E2%8A%B9%20%E2%8A%B1%20%E2%88%82%20%E2%82%B0%20%E0%B8%85%20%E0%B9%80%20%D4%85%20%CE%B5%D1%97%D0%B7%20%E2%8A%86%E2%8A%87%E2%88%82%20%E2%82%B4%20%E3%80%A0%20%E3%80%84%20%E2%9C%8E%EF%B9%8F%E2%84%B3%E0%B9%93%E2%82%AF%E3%8E%95%20%E2%9C%90%EF%B9%8F%E2%99%A1%E0%B9%93%E2%82%AF%E3%8E%95");
        a=a+jiema("%E2%86%90%E2%86%91%E2%86%92%E2%86%93%E2%86%96%E2%86%91%E2%86%97%E2%86%90%E2%86%B9%E2%86%99%E2%86%93%E2%86%98%E2%98%87%E2%98%88%E2%9E%94%E2%9E%98%E2%9E%99%E2%9E%9A%E2%9E%9B%E2%9E%9C%E2%9E%9D%E2%9E%9E%E2%9E%9F%E2%9E%A0%E2%9E%A1%E2%9E%A2%E2%9E%A3%E2%9E%A4%E2%9E%A5%E2%9E%A6%E2%9E%A7%E2%9E%A8%E2%9E%A9%E2%9E%AA%E2%9E%AB%E2%9E%AC%E2%9E%AD%E2%9E%AE%E2%9E%AF%E2%9E%B1%E2%9E%B2%E2%9E%B3%E2%9E%B4%E2%9E%B5%E2%9E%B6%E2%9E%B7%E2%9E%B8%E2%9E%B9%E2%9E%BA%E2%9E%BB%E2%9E%BC%E2%9E%BD%E2%9E%BE%E2%86%95%E2%86%94%E2%86%A8%E2%86%B2%E2%86%B3%EF%A0%81%EF%A0%89%EF%A0%8C%EF%A0%8D%E2%86%9B%E2%86%9C%E2%86%9D%E2%86%9E%E2%86%9F%E2%86%A0%E2%86%A1%E2%86%A2%E2%86%A3%E2%86%A4%E2%86%A5%E2%86%A6%E2%86%A7%E2%86%A8%E2%86%A9%E2%86%AA%E2%86%AB%E2%86%AC%E2%86%AD%E2%86%AE%E2%86%AF%E2%86%B0%E2%86%B1%E2%86%B2%E2%86%B3%E2%86%B4%E2%86%B5%E2%86%B6%E2%86%B7%E2%86%B8%E2%86%BA%E2%86%BB%E2%86%BC%E2%86%BD%E2%86%BE%E2%86%BF%E2%87%80%E2%87%81%E2%87%82%E2%87%83%E2%87%84%E2%87%85%E2%87%86%E2%87%87%E2%87%88%E2%87%89%E2%87%8A%E2%87%9C%E2%87%9D%E2%87%9E%E2%87%9F%E2%87%A0%E2%87%A1%E2%87%A2%E2%87%A3%E2%87%A4%E2%87%A5%E2%87%8B%E2%87%8C%E2%87%8D%E2%87%8E%E2%87%8F%E2%87%90%E2%87%91%E2%87%92%E2%87%93%E2%87%94%E2%87%95%E2%87%96%E2%87%97%E2%87%98%E2%87%99%E2%87%9A%E2%87%9B%E2%87%9C%E2%87%9D%E2%87%9E%E2%87%9F%E2%87%A0%E2%87%A1%E2%87%A2%E2%87%A3%E2%87%A4%E2%87%A5%E2%87%A6%E2%87%A7%E2%87%A8%E2%87%A9%E2%87%AA%E2%87%AB%E2%87%AC%E2%87%AD%E2%87%AE%E2%87%AF%E2%87%B0%E2%87%B1%E2%87%B2%E2%87%B3%E2%87%B4%E2%87%B5%E2%87%B6%E2%87%B7%E2%87%B8%E2%87%B9%E2%87%BA%E2%87%BB%E2%87%BC%E2%87%BD%E2%87%BE%E2%87%BF%E2%87%B4%E2%87%B5%E2%87%B6%E2%87%B7%E2%87%B8%E2%87%B9%E2%87%BA%E2%87%BB%E2%87%BC%E2%87%BD%E2%87%BE%E2%87%BF");
        a=a+jiema("%E2%96%81%20%E2%96%82%20%E2%96%83%20%E2%96%84%20%E2%96%85%20%E2%96%86%20%E2%96%87%20%E2%96%88%20%E2%96%89%20%E2%96%8A%20%E2%96%8B%20%E2%96%8C%20%E2%96%8D%20%E2%96%8E%20%E2%96%8F%20%E2%9D%98%20%E2%9D%99%20%E2%9D%9A%20%E2%96%94%20%E2%96%80%20%E2%96%92%20%E2%96%A5%20%E2%96%A4%20%E2%96%A6%20%E2%96%A7%20%E2%96%A8%20%E2%96%A9%20%E2%96%91%20%E2%96%96%20%E2%96%97%20%E2%96%98%20%E2%96%99%20%E2%96%9A%20%E2%96%9B%20%E2%96%9C%20%E2%96%9D%20%E2%96%9E%20%E2%96%9F%20%E2%97%BB%20%E2%97%BC%20%E2%97%BD%20%E2%97%BE%20%E2%97%BF%20%E2%97%B8%20%E2%97%B9%20%E2%97%BA%20%E2%96%93%20%E2%BF%B4%20%E2%96%A0%20%E2%96%A1%20%E2%96%AF%20%E2%96%AA%20%E2%96%AB%20%E2%96%AE%20%EF%BF%AD%20%E2%96%A2%20%E2%96%AD%20%E2%8E%95%20%E2%88%8E%20%E2%96%AC%20%E2%96%B0%20%E2%96%B1%20%E3%85%81%20%E2%9D%90%20%E2%9D%92%20%E5%8F%A3%20%E2%9D%8F%20%E2%9D%91%20%E5%9B%97%20%E2%97%9A%20%E2%97%9B%20%E2%98%90%20%E2%97%B1%20%E2%97%B2%20%E2%97%98%20%E2%97%B3%20%E2%97%B0%20%E2%97%99%20%E2%99%A6%20%E2%99%A2%20%E2%97%8A%20%E2%97%A7%20%E2%97%A8%20%E2%97%AB%20%E2%97%A9%20%E2%97%AA%20%E2%96%A3%20%E2%97%86%20%E2%97%87%20%E2%97%88%20%E2%97%A4%20%E2%96%B2%20%E2%97%A5%20%E2%97%80%20%EF%A0%84%20%E2%96%B6%20%E2%97%A3%20%E2%96%BC%20%E2%97%A2%20%E2%97%84%20%E2%96%BA%20%E2%88%87%20%E2%97%81%20%E2%96%B7%20%E2%88%86%20%E2%97%AD%20%E2%97%AE%20%E2%97%AC%20%E2%96%BD%20%E2%96%BF%20%E2%96%BE%20%E2%96%B3%20%E2%96%B5%20%E2%96%B4%20%E2%97%83%20%E2%97%85%20%E2%97%82%20%E2%96%B9%20%E2%96%BB%20%E2%96%B8%20%E2%8A%BF%20%E2%8E%96%20%E2%97%B5%20%E2%97%B6%20%E2%97%B7%20%E2%97%B4%20%E2%97%92%20%E2%97%93%20%E2%97%90%20%E2%97%94%20%E2%97%95%20%E2%97%91%20%E2%97%89%20%E2%97%8E%20%E2%97%8D%20%E2%97%AF%20%E3%80%87%20%EF%BC%AF%20%E2%9D%8D%20O%20%EA%92%A8%20%E0%AD%A6%200%20%E3%85%87%20%EF%BD%8F%20%E0%B1%A6%20%E0%B3%A6%20%E0%A7%A6%20%E0%A9%A6%20%E0%AB%A6%20%E0%B4%A0%20%E0%B9%90%20o%20%E2%97%8C%20%E2%97%8B%20%E0%A5%A6%20%EF%BF%AE%20%C2%B0%20%CB%9A%20%E3%82%9C%20%E2%88%98%20%EF%BE%9F%20%E0%A7%B9%20%E0%A5%B0%20%E0%A5%B1%20%E2%8B%84%20%EF%A0%85%20%E3%80%82%20%E2%84%B4%20%E2%97%8F%20%EF%A0%86%20%E0%BB%90%20%E1%80%9D%20%E0%BC%A0%20%E0%BC%9A%20%E0%BF%80%20%E0%BF%81%20%E1%8B%90%20%E1%9F%A0%20%E1%A0%90%20%E2%95%B6%20%E2%95%B4%20%EF%BC%BF%20%E2%95%BA%20%E2%95%B8%20%CB%8D%20%E2%95%BC%20%E2%95%BE%20_%20%EF%A0%82%20%E2%81%83%20%EF%B9%A3%20-%20%EF%BC%8D%20%EF%A0%8A%20%CB%97%20%EF%B9%98%20%EF%BD%B0%20%E2%94%81%20%E2%80%92%20%E2%94%80%20%E3%83%BC%20%E2%80%95%20%E2%80%94%20%E3%85%A1%20%E4%B8%80%20%E3%86%92%20%CB%89%20%C2%AF%20%EF%B9%8C%20%EF%BF%A3%20%EF%B9%8B%20%EF%B9%8F%20%EF%B8%B3%20%E2%96%8F%20%E2%96%95%20%E2%95%B5%20%E2%95%B7%20%E2%88%A3%20%E2%95%B9%20%E2%95%BB%20%EF%BF%A8%20%E2%95%BD%20%E2%95%BF%20%E2%94%83%20%CE%B9%20%E0%A5%A4%20%E0%A7%B7%20l%20%7C%20%E3%86%90%20%EF%B8%B2%20%E3%80%A1%20%E3%85%A3%20%E3%84%A7%20%E4%B8%A8%20%EF%B8%B1%20%EF%BD%9C%20%E2%94%82%20%EF%B8%B4%20%E2%95%B1%20%E2%95%B2%20%EF%B9%92%20/%20%5Cn%20%E2%88%95%20%E2%88%96%20%EF%BC%8E%20%E2%8B%B0%20%E2%8B%B1%20%E3%83%BB%20%CD%BA%20%E2%80%A4%20.%20%E2%8B%85%20%E2%88%99%20%CB%91%20%E2%80%A7%20%EF%BD%A5%20%C2%B7%20%CB%99%20%C2%A8%20%E2%80%A5%20%EF%B9%8A%20%EF%B9%89%20%E2%80%A6%20%EF%B9%8E%20%EF%B9%8D%20%E2%8B%AF%20%E2%95%8C%20%E2%95%8D%20%EF%B9%95%20%E2%94%84%20%E2%94%85%20%E2%88%B6%20%E2%94%88%20%E2%94%89%20%EF%B8%B0%20%E2%95%8E%20%E2%95%8F%20%CB%90%20%E2%94%86%20%E2%94%87%20:%20%E2%94%8A%20%E2%94%8B%20%E2%8B%AE%20%E2%97%9C%20%E2%97%9D%20%C2%A6%20%E2%97%A0%20%E2%97%A1%20%E2%97%9E%20%E2%97%9F");
        a=a+jiema("%E2%84%AB%20%C2%AA%20%E2%84%80%20%E2%84%81%20%E2%99%AD%20%E2%84%AC%20%E2%84%94%20%E2%84%82%20%E2%84%83%20%E2%98%AA%20%E2%84%AD%20%EF%BF%A0%20%C2%A2%20%E2%84%85%20%E2%84%86%20%C2%A9%20%E2%86%83%20%E2%85%AD%20%E2%85%BD%20%E2%85%AE%20%E2%85%BE%20%E2%84%AE%20%E2%84%AF%20%E2%84%B0%20%E2%84%87%20%E2%84%88%20%E2%84%A8%20%E2%84%91%20%E2%84%A5%20%EF%BF%A1%20%C2%A3%20%E2%84%90%20%E2%84%89%20%E2%84%B1%20%E2%84%B2%20%E2%84%8A%20%E2%84%8B%20%E2%84%8C%20%E2%84%8D%20%E2%84%8E%20%E2%84%8F%20%E2%99%84%20%E2%99%85%20%E2%84%B9%20%E2%84%AA%20%E2%84%92%20%E2%84%93%20%E2%84%84%20%E2%85%AC%20%E2%85%BC%20%E2%85%AF%20%E2%85%BF%20%E2%84%B3%20%E2%99%8D%20%E2%84%95%20%E2%81%BF%20%E2%84%96%20%C3%95%20%E2%84%B4%20%E2%84%99%20%E2%84%97%20%E2%98%A7%20%E2%84%9A%20%E2%84%9B%20%E2%84%9C%20%E2%84%9D%20%E2%84%9E%20%E2%84%9F%20%C2%AE%20%E2%84%A0%20%C5%A0%20%EF%BC%84%20$%20%C2%A7%20%E2%84%A2%20%C2%B5%20%E2%84%A3%20%EF%BF%A6%20%E2%84%B5%20%EF%BF%A5%20%C2%A5%20%E2%84%A4%20%E2%98%A1%20%E2%84%98%20%E2%84%AD%20%E2%84%BA%20%E2%84%A9%20%E2%84%B6%20%E2%84%B7%20%E2%84%B8%20%E2%84%A6%20%E2%84%A7%20%E2%86%80%20%E2%86%81%20%E2%86%82%20%EF%AC%80%20%EF%AC%81%20%EF%AC%82%20%EF%AC%83%20%EF%AC%84%20%EF%AC%85%20%E2%84%BB%20%E2%84%BC%20%E2%84%BD%20%E2%84%BE%20%E2%84%BF%20%E2%85%80%20%E2%85%81%20%E2%85%82%20%E2%85%83%20%E2%85%84%20%E2%85%85%20%E2%85%86%20%E2%85%87%20%E2%85%88%20%E2%85%89%20%E2%85%8A%20%E2%85%8B%20%E2%85%8D%20%E2%85%8E");
        fz(a);
        e1.setText(a);
    }
public void tszt_qk(View view)
{
    e1.setText("");
}

public void tszt_fz(View view)
{
    fz(e1.getText().toString());
    ts("复制成功");
}

}