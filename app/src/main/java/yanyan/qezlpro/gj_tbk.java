package yanyan.qezlpro;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class gj_tbk extends Activity {

    private WebView webView;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gj_bbzz);
        Uri uri= Uri.parse("http://60.205.191.199/tbk/");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
//        webView= (WebView) findViewById(R.id.bbzz_web);
//        webView.loadUrl("http://60.205.191.199/tbk/");
//        webView.setWebViewClient(new WebViewClient(){
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//
//            }
//        });
//        WebSettings webSettings=webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webView.setWebChromeClient(new WebChromeClient(){
//
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                if(newProgress==100)
//                {
//                    if(progressDialog!=null && progressDialog.isShowing())
//                    {
//                        progressDialog.dismiss();
//
//                    }
//
//                }
//                else {
//                    if(progressDialog==null) {
//                        progressDialog = new ProgressDialog(gj_tbk.this);
//                        progressDialog.setTitle("正在进入");
//                        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                        progressDialog.setProgress(newProgress);
//                        progressDialog.show();
//                    }
//                    else {
//                        progressDialog.setProgress(newProgress);
//                    }
//                }
//            }
//        });


    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode== KeyEvent.KEYCODE_BACK)
//        {
//            if(webView.canGoBack())
//            {
//                webView.goBack();
//                return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}


