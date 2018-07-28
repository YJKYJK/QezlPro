package yanyan.qezlpro;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/7/11 0011.
 */

public class GN_Dialog extends Dialog {

    private TextView bt,xx;
    private Button qd,qx;

    private String setbt,setxx,setqd,setqx;

    private qdOnListener qdck;
    private qxOnListener qxck;

    private int lx=1;


    public void setqdOnListener(qdOnListener qd){

        this.qdck=qd;
    }

    public void setqxOnListener(qxOnListener qx)
    {
        this.qxck=qx;
    }

    public GN_Dialog(Context context) {
        super(context,R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gn_dialog);
        setCanceledOnTouchOutside(false);

        bt= (TextView) findViewById(R.id.gn_dialog_bt);
        xx=(TextView) findViewById(R.id.gn_dialog_xx);
        qd= (Button) findViewById(R.id.gn_dialog_qd);
        qx= (Button) findViewById(R.id.gn_dialog_qx);

        initdata();
        initEvent();
    }
    private void initdata(){
        if(setbt!=null)
        {
            bt.setText(setbt);
        }
        if(setxx!=null)
        {
            xx.setText(setxx);
        }
        if(setqd!=null)
        {
            qd.setText(setqd);
        }
        if (setqx!=null)
        {
            qx.setText(setqx);
        }
        if(lx!=1)
        {
            qx.setVisibility(View.GONE);
        }
    }
    public void setBt(String bt)
    {
        setbt=bt;
    }
    public  void setXx(String xx){
        setxx=xx;
    }
    public void setQd(String qd)
    {
        setqd=qd;
    }
    public void setQx(String qx){setqx=qx;}
    public interface qdOnListener{
        public void onqdclick();
    }
    public interface qxOnListener{
        public void onqxclick();
    }
    private void initEvent(){
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
    public void setdialog2(int lx)
    {
        this.lx=lx;
    }

}
