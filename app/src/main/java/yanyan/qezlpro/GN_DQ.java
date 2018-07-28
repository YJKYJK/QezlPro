package yanyan.qezlpro;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class GN_DQ{

    private Context context;
    private String name;
    public GN_DQ(Context context, String name){
        this.name=name;
        this.context=context;

    }
    public String DQ()
    {
        String fhnr=null;
        try {
            InputStream inputStream=context.getAssets().open(name);
            int size=inputStream.available();
            byte[] buff=new byte[size];
            inputStream.read(buff);
            inputStream.close();
         fhnr=new String(buff,"GBK");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fhnr==null)
        {
            fhnr="121212";
        }
        return  fhnr;
    }
}
