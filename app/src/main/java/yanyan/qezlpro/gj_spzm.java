package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.internal.Util;

/**
 * Created by Administrator on 2017/8/7 0007.
 */

public class gj_spzm extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_spzm);
    }

    public void spzm_xz(View view)
    {
        Uri uri= Uri.parse("https://t.cn/R9OfXNG");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

    }


}
