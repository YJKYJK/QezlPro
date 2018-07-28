package yanyan.qezlpro;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ant.liao.GifView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/14 0014.
 */

public class gj_gxewmjg extends Activity{
    private ImageView jg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_gxewmjg);
        jg= (ImageView) findViewById(R.id.gj_gxewm_jg);


        Bitmap b = gj_gxewm.ewmtp;
        jg.setImageBitmap(b);


    }


    public void gj_gxewmjg_bc(View view)
    {
        FileOutputStream fos=null;
        SimpleDateFormat cc=new SimpleDateFormat("MMddHHmmss");
        Date cure=new Date(System.currentTimeMillis());
        final String aaa=cc.format(cure);

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        gj_gxewm.ewmtp.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        File outputFile = new File("/mnt/sdcard/qezl/"+aaa + ".png");
        try {
            fos = new FileOutputStream(outputFile);
            fos.write(byteArray);
            fos.close();
            Toast.makeText(gj_gxewmjg.this,"保存成功",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
