package yanyan.qezlpro;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;///////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sumimakito.awesomeqr.AwesomeQRCode;

import zhou.colorpalette.ColorSelectDialog;


public class gj_gxewm extends Activity implements View.OnClickListener{
    public static Bitmap ewmtp;
    private final int BKG_IMAGE = 822;
    private final int LOGO_IMAGE = 379;



    private SeekBar seekBar;
    private TextView imagepx;
    private ColorSelectDialog colorSelectDialog;

    private int imagesize=800;
    private Button kbcolor,ewmnrcolor;


    private int csys=-9700897;
    private int colorqf=0;

    private int color_kb,color_nr=Color.BLACK;


    private Bitmap backgroundImage,logoImage;

    private TextView kb,nr;


  private EditText etcontents;
    private EditText bjbksize;
    private EditText ewmxs;
    private CheckBox sfyd,sfzdys;
    private boolean yd=true,zdys=true;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_gxewm);

        seekBar= (SeekBar) findViewById(R.id.gxewm_size);
        imagepx= (TextView) findViewById(R.id.gxewm_size_px);

        kbcolor= (Button) findViewById(R.id.gxewm_kbcolor);
        ewmnrcolor= (Button) findViewById(R.id.gxewm_ewmnrcolor);

        etcontents= (EditText) findViewById(R.id.gxewm_contents);
        bjbksize= (EditText) findViewById(R.id.gxewm_bjbksize);
        ewmxs= (EditText) findViewById(R.id.gxewm_ewmxs);
        sfyd= (CheckBox) findViewById(R.id.gxewm_sfwyd);
        sfzdys= (CheckBox) findViewById(R.id.gxewm_sfzdys);

        kb= (TextView) findViewById(R.id.gxewm_textkb);
        nr= (TextView) findViewById(R.id.gxewm_textnr);




        kbcolor.setEnabled(false);
        ewmnrcolor.setEnabled(false);



        kbcolor.setOnClickListener(this);
        ewmnrcolor.setOnClickListener(this);
        findViewById(R.id.gxewm_bgimage).setOnClickListener(this);
        findViewById(R.id.gxewm_logoimage).setOnClickListener(this);


        kbcolor.setBackgroundColor(Color.WHITE);
        ewmnrcolor.setBackgroundColor(Color.BLACK);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imagesize=progress+100;
                imagepx.setText("二维码大小-"+imagesize+"px");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //是否圆点
        sfyd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(sfyd.isChecked())
                {
                    yd=true;
                }
                else {
                    yd=false;
                }
            }
        });
        //是否自动颜色
        sfzdys.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(sfzdys.isChecked())
                {
                    color_kb=Color.WHITE;
                    color_nr=Color.BLACK;
                    nr.setTextColor(Color.GRAY);
                    kb.setTextColor(Color.GRAY);
                    kbcolor.setEnabled(false);
                    ewmnrcolor.setEnabled(false);
                    zdys=true;


                }
                else {
                    nr.setTextColor(Color.GREEN);
                    kb.setTextColor(Color.GREEN);
                    kbcolor.setEnabled(true);
                    ewmnrcolor.setEnabled(true);
                    zdys=false;
                }
            }
        });

    }

    public void gj_gxewm_sc(View view){

        //二维码像素
        float Ewmxs=(float) 0.5;
        if (ewmxs.getText().length()!=0)
        {
            Ewmxs=Float.parseFloat(ewmxs.getText().toString())/100;
            if(Ewmxs>1)
            {
                Ewmxs=1;
            }

        }



        generate(etcontents.getText().length()==0 ? "企鹅助理Pro":etcontents.getText().toString(),imagesize,
                bjbksize.getText().length()==0?10:Integer.parseInt(bjbksize.getText().toString()),
                Ewmxs,color_nr,color_kb,
                backgroundImage,true,zdys,true,128,yd,logoImage,10,8,0.2f);



    }

    private void generate(final String contents, final int size, final int margin, final float dotScale,
                          final int colorDark, final int colorLight, final Bitmap background, final boolean whiteMargin,
                          final boolean autoColor, final boolean binarize, final int binarizeThreshold, final boolean roundedDD,
                          final Bitmap logoImage, final int logoMargin, final int logoCornerRadius, final float logoScale)
    {

        new AwesomeQRCode.Renderer().contents(contents).size(size).margin(margin).dotScale(dotScale).
                colorDark(colorDark).colorLight(colorLight).background(background).whiteMargin(false)
                .autoColor(autoColor).binarize(false).binarizeThreshold(128).roundedDots(roundedDD).logo(logoImage)
                .logoMargin(10).logoRadius(8).logoScale(1).renderAsync(new AwesomeQRCode.Callback() {
            @Override
            public void onRendered(AwesomeQRCode.Renderer renderer, Bitmap bitmap) {
                ewmtp=bitmap;
                Intent intent=new Intent();
                intent.setClass(gj_gxewm.this,gj_gxewmjg.class);
                startActivity(intent);


            }

            @Override
            public void onError(AwesomeQRCode.Renderer renderer, Exception e) {

            }
        });


    }



    @Override
    public void onClick(View v) {

        if (colorSelectDialog == null) {
            colorSelectDialog = new ColorSelectDialog(this);
            colorSelectDialog.setOnColorSelectListener(new ColorSelectDialog.OnColorSelectListener() {
                @Override
                public void onSelectFinish(int color) {
                    csys=color;
                    if(colorqf==0)
                    {
                        color_kb=color;
                        gj_gxewm.this.kbcolor.setBackgroundColor(color);
                    }
                    else {
                        color_nr=color;
                        gj_gxewm.this.ewmnrcolor.setBackgroundColor(color);
                    }


                }
            });
        }
        colorSelectDialog.setLastColor(csys);

        switch (v.getId())
        {
            case R.id.gxewm_kbcolor:
                colorqf=0;
                colorSelectDialog.show();
                break;
            case R.id.gxewm_ewmnrcolor:
                colorqf=1;
                colorSelectDialog.show();
                break;
            //选择背景图片
            case R.id.gxewm_bgimage:
                bgimage();
                break;


            //选择logo
            case R.id.gxewm_logoimage:
                Logoimage();
                break;

        }
    }
    private void bgimage(){
        Intent intent;
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.setType("image/*");
        startActivityForResult(intent, BKG_IMAGE);
    }

    private void Logoimage()
    {
        Intent intent;
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.setType("image/*");
        startActivityForResult(intent, LOGO_IMAGE);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && data.getData() != null) {

                Uri imageUri = data.getData();
                if (requestCode == BKG_IMAGE) {
                    //backgroundImage = BitmapFactory.decodeFile(ContentHelper.absolutePathFromUri(MainActivity.this, imageUri));

                        backgroundImage=BitmapFactory.decodeFile(ContentHelper.absolutePathFromUri(this,imageUri));
                    Toast.makeText(this, "背景图片已添加成功", Toast.LENGTH_SHORT).show();



                } else if (requestCode == LOGO_IMAGE) {
                   logoImage = BitmapFactory.decodeFile(ContentHelper.absolutePathFromUri(this, imageUri));

                    Toast.makeText(this, "Logo图片已添加成功.", Toast.LENGTH_SHORT).show();

                }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }




public void gxewm_movebg(View view)
{
    backgroundImage=null;
    Toast.makeText(this, "背景图片已清除", Toast.LENGTH_SHORT).show();
}

    public void gxewm_movelogo(View view)
    {
       logoImage=null;
        Toast.makeText(this, "logo图片已清除", Toast.LENGTH_SHORT).show();
    }





}