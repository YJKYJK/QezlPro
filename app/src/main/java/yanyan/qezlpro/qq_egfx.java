package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.share.QQShare;
import com.tencent.tauth.Tencent;

/**
 * Created by Administrator on 2017/7/27 0027.
 */

public class qq_egfx extends Activity{
    private EditText bt,gs,yy,lj;
    private RadioButton jc,hj,zdy,bdtp,wltp;

    private EditText tp;


    private Tencent tencent ;

    private String tpdz=null;

    private static final int aaa=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_egfx);

        bt= (EditText) findViewById(R.id.egfx_bt);
        gs= (EditText) findViewById(R.id.egfx_gs);
        yy= (EditText) findViewById(R.id.egfx_yy);
        lj= (EditText) findViewById(R.id.egfx_lj);

        tp= (EditText) findViewById(R.id.egfx_tp);


        jc= (RadioButton) findViewById(R.id.egfx_jc);
        hj= (RadioButton) findViewById(R.id.egfx_hj);
        zdy= (RadioButton) findViewById(R.id.egfx_zdy);

        bdtp= (RadioButton) findViewById(R.id.egfx_bdtp);
        wltp= (RadioButton) findViewById(R.id.egfx_wltp);


        tencent= Tencent.createInstance("100000001",this);

        jc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(jc.isChecked())
                {
                    yy.setVisibility(View.GONE);
                    hj.setChecked(false);
                    zdy.setChecked(false);
                }
            }
        });

        hj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(hj.isChecked())
                {
                    yy.setVisibility(View.GONE);
                    jc.setChecked(false);
                    zdy.setChecked(false);
                }
            }
        });

        zdy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(zdy.isChecked())
                {
                    yy.setVisibility(View.VISIBLE);
                    hj.setChecked(false);
                    jc.setChecked(false);
                }
            }
        });

        wltp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(wltp.isChecked())
                {
                    bdtp.setChecked(false);
                    tp.setText("");
                }
            }
        });

        bdtp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(bdtp.isChecked())
                {
                    wltp.setChecked(false);
                    tp.setText("");
                    egfx_tpxz();

                }
            }
        });



    }

    public void egfx_fs(View view)
    {
        String sbt=bt.getText().toString();
        String sgs=gs.getText().toString();
        String syy=yy.getText().toString();
        String slj=lj.getText().toString();
        if(wltp.isChecked() && tp.getText().length()!=0) {
            tpdz = tp.getText().toString();
            if(tpdz.indexOf("http://")==-1 || tpdz.indexOf("https://")==-1)
            {
                tpdz="http://"+tpdz;
            }
        }
        if(tpdz.length()>0)
        {
            if(jc.isChecked() || hj.isChecked())
            {
                if(sbt.length()>0 && sgs.length()>0 && slj.length()>0)
                {
                    if(slj.indexOf("http://")==-1 || slj.indexOf("https://")==-1)
                    {
                        slj="http://"+slj;
                    }
                    if(jc.isChecked())
                    {
                        onClickShare(sbt,sgs,slj,"http://60.205.191.199/jc.mp3");
                    }
                    else
                    {
                        onClickShare(sbt,sgs,slj,"http://60.205.191.199/666.mp3");
                    }

                }
                else {
                    Toast.makeText(qq_egfx.this, "请输入完整的分享内容", Toast.LENGTH_SHORT).show();
                }
            }
            else {


                if(sbt.length()>0 && sgs.length()>0 && slj.length()>0 && syy.length()>0)
                {
                    if(slj.indexOf("http://")==-1 || slj.indexOf("https://")==-1)
                    {
                        slj="http://"+slj;
                    }
                    if(syy.indexOf("http://")==-1 || syy.indexOf("https://")==-1)
                    {
                        syy="http://"+syy;
                    }

                    onClickShare(sbt,sgs,slj,syy);
                }
                else
                {
                    Toast.makeText(qq_egfx.this, "请输入完整的分享内容", Toast.LENGTH_SHORT).show();
                }


            }
        }


        else {
            Toast.makeText(qq_egfx.this,"您还没有选择图片", Toast.LENGTH_SHORT).show();

        }


//        if(zdy.isChecked()!=true) {
//            if (sbt.length() !=0  && syy.length() != 0 && sgs.length() != 0 && slj.length() != 0 && stp.length() != 0) {
//                if(syy.indexOf("http://")==-1)
//                {
//                    syy="http://"+syy;
//                }
//                if(slj.indexOf("http://")==-1)
//                {
//                    slj="http://"+slj;
//                }
//
//            }
//            else {
//
//                Toast.makeText(qq_egfx.this, "请输入完整的分享内容", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//
//        else {
//
//                if (sbt.length() !=0  && sgs.length() != 0 && slj.length() != 0 && stp.length() != 0) {
//
//                    if(syy.indexOf("http://")==-1)
//                    {
//                        syy="http://"+syy;
//                    }
//                    if(slj.indexOf("http://")==-1)
//                    {
//                        slj="http://"+slj;
//                    }
//
//
//                    onClickShare(sbt,sgs,slj,syy);
//                } else {
//
//                    Toast.makeText(qq_egfx.this, "请输入完整的分享内容", Toast.LENGTH_SHORT).show();
//                }
//        }
    }

    private void onClickShare(String sbt, String sgs,String slj,String syy) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_AUDIO);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, sbt);
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, sgs);
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, slj);
        if(bdtp.isChecked())
        {
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, tpdz);
        }
        else {
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, tpdz);
        }
        params.putString(QQShare.SHARE_TO_QQ_AUDIO_URL, syy);
        tencent.shareToQQ(qq_egfx.this, params, null);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
        {
            if(data!=null)
            {
                try {
                    Uri uri = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = this.getContentResolver().query(uri,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

                    tpdz = cursor.getString(columnIndex);
                    cursor.close();
                    tp.setText(tpdz);
                }
                catch (Exception e)
                {
                    Toast.makeText(qq_egfx.this,"您的手机不支持本地图片，请选择网络图片",Toast.LENGTH_SHORT).show();
                }

            }
            else {
                Toast.makeText(qq_egfx.this,"您还没有选择图片", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void egfx_tpxz()
    {
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        startActivityForResult(intent,aaa);
    }

}
