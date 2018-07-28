package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public class gj_zbtp extends Activity {
    private WebView webView;

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_zbtp);
        webView= (WebView) findViewById(R.id.zbtp_web);

        webView.loadUrl("http://60.205.191.199/zbt/zhuangbi/");
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;

            }
        });
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress==100)
                {
                    if(progressDialog!=null && progressDialog.isShowing())
                    {
                        progressDialog.dismiss();

                    }

                }
                else {
                    if(progressDialog==null) {
                        progressDialog = new ProgressDialog(gj_zbtp.this);
                        progressDialog.setTitle("正在进入");
                        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressDialog.setProgress(newProgress);
                        progressDialog.show();
                    }
                    else {
                        progressDialog.setProgress(newProgress);
                    }
                }
            }
        });


    }
    public void zbtp_dk(View view)
    {

        Uri uri= Uri.parse("http://60.205.191.199/zbt/zhuangbi/");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}
