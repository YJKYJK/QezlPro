package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2017/7/18 0018.
 */

public class qq_wjdm extends Activity {

    private WebView webView;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qq_wjdm);

        webView= (WebView) findViewById(R.id.wjdm_web);

        webView.loadUrl("http://60.205.191.199:80/wj");
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
                        progressDialog = new ProgressDialog(qq_wjdm.this);
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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            if(webView.canGoBack())
            {
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
