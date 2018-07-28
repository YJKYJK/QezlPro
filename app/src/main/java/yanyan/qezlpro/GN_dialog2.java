package yanyan.qezlpro;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class GN_dialog2 extends Dialog {
    private Button qd, qx;
    private TextView bt, xx;
    private ImageView tp;


    private GN_Dialog.qdOnListener qdck;
    private GN_Dialog.qxOnListener qxck;

    private Bitmap bitmap;
    String mqd,mqx,mbt,mxx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gn_dialog2);
        setCanceledOnTouchOutside(false);
        qd = (Button) findViewById(R.id.gn_dialog2_qd);
        qx = (Button) findViewById(R.id.gn_dialog2_qx);
        bt = (TextView) findViewById(R.id.gn_dialog2_bt);
        xx = (TextView) findViewById(R.id.gn_dialog2_xx);
        tp = (ImageView) findViewById(R.id.gn_dialog2_tp);
        initEvent();
        initdata();
    }

    public void setNr(Bitmap mtp, String mbt, String mxx, String mqd, String mqx) {
       this.bitmap=mtp;
        this.mbt=mbt;
        this.mxx=mxx;
        this.mqd=mqd;
        this.mqx=mqx;

    }

    public void setqdOnListener(GN_Dialog.qdOnListener qd){

        this.qdck=qd;
    }

    public void setqxOnListener(GN_Dialog.qxOnListener qx)
    {
        this.qxck=qx;
    }

    private void initdata()
    {
        tp.setImageBitmap(bitmap);
        bt.setText(mbt);
        xx.setText(mxx);
        qd.setText(mqd);
        qx.setText(mqx);
    }



    public GN_dialog2(Context context) {
        super(context,R.style.MyDialog);
    }

    public GN_dialog2(@NonNull Context context, @StyleRes int themeResId) {
        super(context, R.style.MyDialog);
    }

    protected GN_dialog2(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    private void initEvent() {
        qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qdck.onqdclick();

                dismiss();
            }
        });
        qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qxck.onqxclick();
                dismiss();
            }
        });
    }
    public interface qdOnListener{
        public void onqdclick();
    }
    public interface qxOnListener{
        public void onqxclick();
    }
}
