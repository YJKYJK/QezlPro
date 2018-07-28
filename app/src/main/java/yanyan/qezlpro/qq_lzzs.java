package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class qq_lzzs extends Activity {
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    private ImageView i;
    private String wjm;
    private ProgressDialog p;




    private Bitmap bitmap;

    private GN_Dialog dialog;

    private static final int a=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_lzzs);

        spinner= (Spinner) findViewById(R.id.lzzs_lzlx);
        i= (ImageView) findViewById(R.id.lzzs_tp);




        list=new ArrayList<String>();
        list.add("全部");
        list.add("腾讯动漫会员");
        list.add("付费音乐包");
        list.add("好莱坞");
        list.add("红钻");
        list.add("黄钻");
        list.add("绿钻");
        list.add("情侣黄钻");
        list.add("会员");
        list.add("图书VIP");
        list.add("微云会员");
        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }


    //选择图片
    public void lzzs_xztp(View view)
    {
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        startActivityForResult(intent,a);
    }


//图片返回
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0){
            if(data!=null)
            {
                Uri uri=data.getData();
                i.setImageURI(uri);

                i.buildDrawingCache();
               bitmap =i.getDrawingCache();




//                try {
//                bitmap=MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            }
        }
    }


    public void dl()
    {
        switch (spinner.getSelectedItemPosition())
        {
            case 0:wjm="qb";break;
            case 1:wjm="Cache_461e33af73e13066";break;
            case 2:wjm="Cache_-23189ac94d321925";break;
            case 3:wjm="Cache_-72c62a21ad1ee838";break;
            case 4:wjm="Cache_406a6a3edfe44f9b";break;
            case 5:wjm="Cache_75d5fe8700b3d108";break;
            case 6:wjm="Cache_2f5a58a350b8ef6d";break;
            case 7:wjm="Cache_2298f106fd17dab5";break;
            case 8:wjm="Cache_64ae2bee6c750bc";break;
            case 9:wjm="Cache_-10ce96ef42a65356";break;
            case 10:wjm="Cache_-4a19110620443607";break;


        }
    }
    public void xr()
    {

        File file=new File("mnt/sdcard//tencent/MobileQQ/diskcache/"+wjm);
        try {
            file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream outputStream=null;
        try {
             outputStream=new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        try {
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void lzzs_dl(View view)

    {
        p = new ProgressDialog(qq_lzzs.this);
        p.setMessage("正在亮钻");
        p.show();
        dl();
        dialog=new GN_Dialog(qq_lzzs.this);
        dialog.setBt("亮钻成功");
        dialog.setQd("知道了");
        dialog.setdialog2(0);
        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
            @Override
            public void onqdclick() {

            }
        });


       if (bitmap!=null) {

           if(wjm=="qb") {
               for(int i=0;i<10;i++)
               {
                   switch (i)
                   {
                       case 0:wjm="Cache_461e33af73e13066";break;
                       case 1:wjm="Cache_-23189ac94d321925";break;
                       case 2:wjm="Cache_-72c62a21ad1ee838";break;
                       case 3:wjm="Cache_406a6a3edfe44f9b";break;
                       case 4:wjm="Cache_75d5fe8700b3d108";break;
                       case 5:wjm="Cache_2f5a58a350b8ef6d";break;
                       case 6:wjm="Cache_2298f106fd17dab5";break;
                       case 7:wjm="Cache_64ae2bee6c750bc";break;
                       case 8:wjm="Cache_-10ce96ef42a65356";break;
                       case 9:wjm="Cache_-4a19110620443607";break;
                   }
                   xr();
               }


           }
           else {
               xr();
           }
           p.dismiss();
           dialog.setXx("亮钻文件已写入，请重启QQ查看效果\n\n如果重启QQ仍然没有效果请重新登录一下QQ或者切换QQ账号\n\n提示：如果已有钻某些钻可能不会显示");
           dialog.show();

        }
        else{
           p.dismiss();
            Toast.makeText(this,"请选择图片", Toast.LENGTH_LONG).show();
        }


    }
    public void lzzs_yjlz(View view){

        p = new ProgressDialog(qq_lzzs.this);
        p.setMessage("正在亮钻");
        p.show();
        GN_DQXC lz=new GN_DQXC(qq_lzzs.this);
        try {
            lz.XC("1","tencent/MobileQQ/diskcache/Cache_-10ce96ef42a65356");
            lz.XC("2","tencent/MobileQQ/diskcache/Cache_-72c62a21ad1ee838");
            lz.XC("3","tencent/MobileQQ/diskcache/Cache_-23189ac94d321925");
            lz.XC("4","tencent/MobileQQ/diskcache/Cache_-4a19110620443607");
            lz.XC("5","tencent/MobileQQ/diskcache/Cache_2f5a58a350b8ef6d");
            lz.XC("6","tencent/MobileQQ/diskcache/Cache_64ae2bee6c750bc");
            lz.XC("7","tencent/MobileQQ/diskcache/Cache_75d5fe8700b3d108");
            lz.XC("8","tencent/MobileQQ/diskcache/Cache_406a6a3edfe44f9b");
            lz.XC("9","tencent/MobileQQ/diskcache/Cache_461e33af73e13066");
            lz.XC("10","tencent/MobileQQ/diskcache/Cache_2298f106fd17dab5");

            p.dismiss();
        } catch (IOException e) {
            e.printStackTrace();
            p.dismiss();
        }
        dialog=new GN_Dialog(qq_lzzs.this);
        dialog.setBt("亮钻成功");
        dialog.setXx("亮钻文件已写入，请重启QQ查看效果\n\n如果重启QQ仍然没有效果请重新登录一下QQ或者切换QQ账号\n\n提示：如果已有钻某些钻可能不会显示");
        dialog.setQd("知道了");
        dialog.setdialog2(0);
        dialog.show();
        dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
            @Override
            public void onqdclick() {

            }
        });

    }
private void sclz()
{
    String wj[]={"Cache_-10ce96ef42a65356","Cache_-72c62a21ad1ee838","Cache_-23189ac94d321925",
            "Cache_-4a19110620443607","Cache_2f5a58a350b8ef6d","Cache_64ae2bee6c750bc",
            "Cache_75d5fe8700b3d108","Cache_406a6a3edfe44f9b","Cache_461e33af73e13066","Cache_2298f106fd17dab5"};
    for(int i=0;i<wj.length;i++)
    {
        File file=new File("mnt/sdcard//tencent/MobileQQ/diskcache/"+wj[i]);
        if(file.exists())
        {
            file.delete();
        }
    }



}
public void lzzs_gblz(View view)
{
    sclz();
    dialog=new GN_Dialog(qq_lzzs.this);
    dialog.setBt("关闭成功");
    dialog.setXx("亮钻文件已删除，重启QQ即可");
    dialog.setQd("知道了");
    dialog.setdialog2(0);
    dialog.show();
    dialog.setqdOnListener(new GN_Dialog.qdOnListener() {
        @Override
        public void onqdclick() {

        }
    });
}

}
