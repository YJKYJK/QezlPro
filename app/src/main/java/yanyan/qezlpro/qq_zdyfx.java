package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.tencent.connect.share.QQShare;
import com.tencent.tauth.Tencent;

/**
 * Created by Administrator on 2017/7/1 0001.
 */

public class qq_zdyfx extends Activity {

    private Tencent tencent ;
    private EditText e1,e2,e3,e4;
    private RadioButton wl,bd;
    private static final int aaa=0;
    private String tpdz=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_zdyfx);
        tencent= Tencent.createInstance("100000001",this);
        e1= (EditText) findViewById(R.id.zdyfx_bt);
        e2= (EditText) findViewById(R.id.zdyfx_xq);
        e3= (EditText) findViewById(R.id.zdyfx_tp);
        e4= (EditText) findViewById(R.id.zdyfx_lj);
        wl= (RadioButton) findViewById(R.id.zdyfx_wltp);
        bd= (RadioButton) findViewById(R.id.zdyfx_bdtp);


        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bd.isChecked())
                {
                    wl.setChecked(false);
                    hqbdtp();
                }
            }
        });

        wl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wl.isChecked())
                {
                    bd.setChecked(false);
                }
            }
        });
    }
    public void zdyfx_sc(View view)
    {
        String a1=e1.getText().toString();
        String a2=e2.getText().toString();
        String a3=e3.getText().toString();
        String a4=e4.getText().toString();
        if (a1.length()!=0 && a2.length()!=0 && a3.length()!=0 && a4.length()!=0)
        {
            if(a3.indexOf("http://")==-1 )
        {
            if(a3.indexOf("https://")==-1 ) {
                if (wl.isChecked()) {
                    a3 = "http://" + a3;
                }
            }
        }

            if(a4.indexOf("http://")==-1)
            {
                if(a4.indexOf("https://")==-1) {
                    a4 = "http://" + a4;
                }

            }

            onClickShare(a1,a2,a3,a4);


        }
        else {
            Toast.makeText(qq_zdyfx.this,"您还没有输入完整内容", Toast.LENGTH_LONG).show();
        }
    }

    private void onClickShare(String bt, String xq, String tp, String lj) {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, bt);
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY,  xq);
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL,  lj);
        if(wl.isChecked()){
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, tp);
        }
        else
        {
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, tpdz);
        }



        tencent.shareToQQ(qq_zdyfx.this, params, null);
    }

    private void hqbdtp()
    {
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        startActivityForResult(intent,aaa);
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
                    e3.setText(tpdz);
                }
                catch (Exception e)
                {
                    Toast.makeText(qq_zdyfx.this,"您的手机不支持本地图片，请使用网络图片",Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(qq_zdyfx.this,"您还没有选择图片", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
