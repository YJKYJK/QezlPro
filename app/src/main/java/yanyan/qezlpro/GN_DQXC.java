package yanyan.qezlpro;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class GN_DQXC {

    private Context context;
    public GN_DQXC(Context context){
        this.context=context;
    }
    public void XC(String xr, String xc) throws IOException {
        InputStream inputStream=context.getAssets().open(xr);
        FileOutputStream outputStream=new FileOutputStream("/mnt/sdcard/"+xc);
        byte[] buff=new byte[1024];
        int lan=inputStream.read(buff);
        while (lan>0)
        {
            outputStream.write(buff,0,lan);
            lan=inputStream.read(buff);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();

    }

}
