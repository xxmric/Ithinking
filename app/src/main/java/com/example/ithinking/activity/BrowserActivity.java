package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ithinking.R;

public class BrowserActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        mWebView = findViewById(R.id.webView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webSettings.setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
//        webSettings.setSupportZoom(true);//是否可以缩放，默认true
//        webSettings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
//        webSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
//        webSettings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
//        webSettings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
//        webSettings.setDomStorageEnabled(true);//DOM Storage
        webSettings.setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");//设置用户代理，一般不用

        String url = "http://m.baidu.com/";
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new WebViewClient() {


            @Override  //WebView代表是当前的WebView
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //表示在当前的WebView继续打开网页
                Log.w("访问URL=",request.getUrl().toString());
//                view.loadUrl(request.getUrl().toString());

                if(request.getUrl() == null) return false;
                String url2 = request.getUrl().toString();
                try {
                    if(url2.startsWith("weixin://") //微信
                            || url2.startsWith("alipays://") //支付宝
                            || url2.startsWith("mailto://") //邮件
                            || url2.startsWith("tel://")//电话
                            || url2.startsWith("dianping://")//大众点评
                            || url2.startsWith("baiduboxapp://")//百度
                        //其他自定义的scheme
                    ) {
                        Log.w("百度SCHAME",request.getUrl().toString());
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                    return true;//没有安装该app时，返回true，表示拦截自定义链接，但不跳转，避免弹出上面的错误页面
                }

                //处理http和https开头的url
                view.loadUrl(url2);
                return true;
            }

//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                handler.proceed();
//            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d("WebView","开始访问网页");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d("WebView","访问网页结束");
            }

        });
        mWebView.setWebChromeClient(new WebChromeClient() {

            private ProgressDialog progressDialog;
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // newProgress 1 ~ 100 之间的证书
                if (newProgress == 100) {
                    // 加载完成，关闭ProgressDialog
                    closeDialog();
                } else {
                    // 还在加载，打开ProgressDialog
                    openDialog(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                //设置当前网页标题为activity标题
                setTitle(title);
            }

            private void closeDialog() {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }
            private void openDialog(int newProgress) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(BrowserActivity.this);
                    progressDialog.setProgress(newProgress);
                    progressDialog.setTitle("正在加载");
                    progressDialog.show();
                } else {
                    progressDialog.setProgress(newProgress);
                }
            }

        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
