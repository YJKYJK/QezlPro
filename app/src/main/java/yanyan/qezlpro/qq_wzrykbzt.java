package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/21 0021.
 */

public class qq_wzrykbzt extends Activity {

    private String[] zm={"%F0%9F%87%A6","%F0%9F%87%A7","%F0%9F%87%A8","%F0%9F%87%A9",
            "%F0%9F%87%AA","%F0%9F%87%AB","%F0%9F%87%AC","%F0%9F%87%AD",
            "%F0%9F%87%AE","%F0%9F%87%AF","%F0%9F%87%B0","%F0%9F%87%B1"
            ,"%F0%9F%87%B2","%F0%9F%87%B3","%F0%9F%87%B4",
            "%F0%9F%87%B5","%F0%9F%87%B6","%F0%9F%87%B7","%F0%9F%87%B8"
            ,"%F0%9F%87%B9","%F0%9F%87%BA","%F0%9F%87%BB","%F0%9F%87%BC"
            ,"%F0%9F%87%BD","%F0%9F%87%BE","%F0%9F%87%BF"};

    private String[] ts={"%E2%98%91","%E2%9E%97","%E2%9E%95","%E2%9E%96",
            "%E2%9C%96","%E2%9B%8E","%E2%9E%BF","%F0%9F%86%95","%E2%8F%AA",
            "%F0%9F%88%B9","%F0%9F%88%B5","%F0%9F%86%92","%F0%9F%88%B8","%F0%9F%88%B3",
            "%F0%9F%88%82","%F0%9F%85%B0","%F0%9F%88%B7","%F0%9F%86%8E","%F0%9F%88%AF",
            "%F0%9F%88%B6","%F0%9F%85%BE","%F0%9F%88%81"
            ,"%F0%9F%88%9A","%F0%9F%86%9A","%F0%9F%85%B1","%F0%9F%86%94",
            "%F0%9F%88%BA","%F0%9F%9A%BE"};

    private String[] qb={"%F0%9F%87%A6","%F0%9F%87%A7","%F0%9F%87%A8","%F0%9F%87%A9",
            "%F0%9F%87%AA","%F0%9F%87%AB","%F0%9F%87%AC","%F0%9F%87%AD",
            "%F0%9F%87%AE","%F0%9F%87%AF","%F0%9F%87%B0","%F0%9F%87%B1"
            ,"%F0%9F%87%B2","%F0%9F%87%B3","%F0%9F%87%B4",
            "%F0%9F%87%B5","%F0%9F%87%B6","%F0%9F%87%B7","%F0%9F%87%B8"
            ,"%F0%9F%87%B9","%F0%9F%87%BA","%F0%9F%87%BB","%F0%9F%87%BC"
            ,"%F0%9F%87%BD","%F0%9F%87%BE","%F0%9F%87%BF","%E2%98%91","%E2%9E%97","%E2%9E%95","%E2%9E%96",
            "%E2%9C%96","%E2%9B%8E","%E2%9E%BF","%F0%9F%86%95","%E2%8F%AA",
            "%F0%9F%88%B9","%F0%9F%88%B5","%F0%9F%86%92","%F0%9F%88%B8","%F0%9F%88%B3",
            "%F0%9F%88%82","%F0%9F%85%B0","%F0%9F%88%B7","%F0%9F%86%8E","%F0%9F%88%AF",
            "%F0%9F%88%B6","%F0%9F%85%BE","%F0%9F%88%81","%F0%9F%9A%BE","%F0%9F%88%BA"
            ,"%F0%9F%88%9A","%F0%9F%86%9A","%F0%9F%85%B1","%F0%9F%86%94"};

    private String[] ezj={"%F0%9F%87%A6","%F0%9F%87%A7","%F0%9F%87%A8","%F0%9F%87%A9",
            "%F0%9F%87%AA","%F0%9F%87%AB","%F0%9F%87%AC","%F0%9F%87%AD",
            "%F0%9F%87%AE","%F0%9F%87%AF","%F0%9F%87%B0","%F0%9F%87%B1"
            ,"%F0%9F%87%B2","%F0%9F%87%B3","%F0%9F%87%B4",
            "%F0%9F%87%B5","%F0%9F%87%B6","%F0%9F%87%B7","%F0%9F%87%B8"
            ,"%F0%9F%87%B9","%F0%9F%87%BA","%F0%9F%87%BB","%F0%9F%87%BC"
            ,"%F0%9F%87%BD","%F0%9F%87%BE","%F0%9F%87%BF",
            "%F0%9F%86%95",
            "%F0%9F%88%B9","%F0%9F%88%B5","%F0%9F%86%92","%F0%9F%88%B8","%F0%9F%88%B3",
            "%F0%9F%88%82","%F0%9F%85%B0","%F0%9F%88%B7","%F0%9F%86%8E","%F0%9F%88%AF",
            "%F0%9F%88%B6","%F0%9F%85%BE","%F0%9F%88%81"
            ,"%F0%9F%88%9A","%F0%9F%86%9A","%F0%9F%85%B1","%F0%9F%86%94",
            "%F0%9F%88%BA","%F0%9F%9A%BE"};

    private String[] yzj={"%E2%9C%96","%E2%98%91","%E2%9E%97","%E2%9E%95","%E2%9E%96","%E2%9B%8E","%E2%8F%AA","%E2%9E%BF"};


    private GN_Dialog dialog;
    private ClipboardManager cp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_wzrykbnc);
        cp=(ClipboardManager) getSystemService(CLIPBOARD_SERVICE);



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

    public void wzrykbnc_hlsc(View v)
    {
        String fhwb="";
        Random random=new Random();
        for(int i=0;i<3;i++) {
            int sj = random.nextInt(qb.length);
            fhwb=fhwb+jiema(qb[sj]);
        }

        dialog=new GN_Dialog(qq_wzrykbzt.this);
        dialog.setBt("名字生成成功");
        dialog.setXx("名字："+fhwb+" 已复制\n如果出现名字重复，返回再次生成一个即可");
        dialog.setQd("知道了");
        dialog.setdialog2(0);
        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
            @Override
            public void onqdclick() {

            }
        });



        fz(fhwb);
        dialog.show();

    }

    private void fz(String nr)
    {
        ClipData fz2;
        fz2= ClipData.newPlainText("text",nr);
        cp.setPrimaryClip(fz2);
    }


    public void wzrykbnc_mstwosc(View v)
    {
        ArrayList<String> fh=new ArrayList<String>();
        String fhwb1="";

        Random random=new Random();

        for(int i=0;i<2;i++) {
            int sj = random.nextInt(yzj.length);
            fh.add(jiema(yzj[sj]));
        }

        for(int i=0;i<2;i++) {
            int sj = random.nextInt(ezj.length);
            fh.add(jiema(ezj[sj]));
        }

        for(int i=0;i<4;i++)
        {
            int sj = random.nextInt(fh.size());
            fhwb1=fhwb1+fh.get(sj);
            fh.remove(sj);
        }



        dialog=new GN_Dialog(qq_wzrykbzt.this);
        dialog.setBt("名字生成成功");
        dialog.setXx("名字："+fhwb1+" 已复制\n如果出现名字重复，返回再次生成一个即可");
        dialog.setQd("知道了");
        dialog.setdialog2(0);
        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
            @Override
            public void onqdclick() {

            }
        });
        fz(fhwb1);
        dialog.show();

    }
    public void wzrykbnc_msthreesc(View v)
    {
        Random random=new Random();
        if(random.nextInt(10)%2==0)
        {
            twoforone();
        }
        else {
            oneforthree();
        }

    }

    //二中一
    private void twoforone()
    {
        ArrayList<String> fh=new ArrayList<String>();
        String fhwb1="";

        Random random=new Random();


        int sj = random.nextInt(yzj.length);
        fh.add(jiema(yzj[sj]));


        for(int i=0;i<2;i++) {
            int sj2 = random.nextInt(ezj.length);
            fh.add(jiema(ezj[sj2]));
        }

        for(int i=0;i<3;i++)
        {
            int sj2 = random.nextInt(fh.size());
            fhwb1=fhwb1+fh.get(sj2);
            fh.remove(sj2);
        }



        dialog=new GN_Dialog(qq_wzrykbzt.this);
        dialog.setBt("名字生成成功");
        dialog.setXx("名字："+fhwb1+" 已复制\n如果出现名字重复，返回再次生成一个即可");
        dialog.setQd("知道了");
        dialog.setdialog2(0);
        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
            @Override
            public void onqdclick() {

            }
        });
        fz(fhwb1);
        dialog.show();
    }

    //一中三
    private void oneforthree()
    {
        ArrayList<String> fh=new ArrayList<String>();
        String fhwb1="";

        Random random=new Random();

for(int i=0;i<3;i++) {
    int sj = random.nextInt(yzj.length);
    fh.add(jiema(yzj[sj]));
}


            int sj2 = random.nextInt(ezj.length);
            fh.add(jiema(ezj[sj2]));


        for(int i=0;i<4;i++)
        {
            int sj = random.nextInt(fh.size());
            fhwb1=fhwb1+fh.get(sj);
            fh.remove(sj);
        }



        dialog=new GN_Dialog(qq_wzrykbzt.this);
        dialog.setBt("名字生成成功");
        dialog.setXx("名字："+fhwb1+" 已复制\n如果出现名字重复，返回再次生成一个即可");
        dialog.setQd("知道了");
        dialog.setdialog2(0);
        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
            @Override
            public void onqdclick() {

            }
        });
        fz(fhwb1);
        dialog.show();
    }

}
