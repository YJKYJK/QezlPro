package yanyan.qezlpro;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class GN_newdialog extends Dialog{

    private ImageButton gb;
    private TextView xx;

    private gbOnListener gbck;

    private String mxx;


    public GN_newdialog(Context context) {
        super(context,R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gn_newdialog);
        setCanceledOnTouchOutside(false);
        gb= (ImageButton) findViewById(R.id.gn_newdialog_gb);
        xx= (TextView) findViewById(R.id.gn_newdialog_xx);


        initdata();
        initEvent();

    }

    public void setnr(String mxx)
    {
        this.mxx=mxx;

    }

    private void initdata()
    {
        xx.setText(mxx);
    }


    public void setqdOnListener(GN_newdialog.gbOnListener mgb){

        this.gbck=mgb;
    }



    private void initEvent()
    {
        gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gbck.onqdclick();
                dismiss();
            }
        });
    }

    public interface gbOnListener
    {
        public void onqdclick();
    }
}
