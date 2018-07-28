package yanyan.qezlpro;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/2 0002.
 */

public class gn_gj extends Activity {

    private Context c;

    public gn_gj(Context c)
    {

        this.c=c;
    }
    public void fz(String a){
   ClipboardManager cp =(ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData fz2;
        fz2= ClipData.newPlainText("text",a);
        cp.setPrimaryClip(fz2);
    }
    public void ts(String ts)
    {
        Toast.makeText(c,ts, Toast.LENGTH_LONG).show();
    }

}
