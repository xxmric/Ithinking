package com.example.ithinking.util;

import android.annotation.SuppressLint;
import android.content.Context;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * okhttp3客户端封装类
 */
public class HttpClient {

    public final static int CONNECT_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 100;
    public final static int WRITE_TIMEOUT = 60;

    private OkHttpClient client;
    private static HttpClient mClient;
    private Context context;
    private HttpClient(Context c) {
        context = c;
        client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context)))
                .followRedirects(true)//允许重定向
                .followSslRedirects(true)
                .hostnameVerifier(new HostnameVerifier()
                {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        // TODO Auto-generated method stub
                        return false;
                    }
                })
                //配置Https
                .sslSocketFactory(createSSLSocketFactory())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .build();
    }

    /**
     * 默认信任所有的证书
     * TODO 最好加上证书认证，主流App都有自己的证书
     *
     * @return
     */
    @SuppressLint("TrulyRandom")
    private static SSLSocketFactory createSSLSocketFactory() {

        SSLSocketFactory sSLSocketFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllManager()},
                    new SecureRandom());
            sSLSocketFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return sSLSocketFactory;
    }
    private static class TrustAllManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
    private static class TrustAllHostnameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return false;
        }
    }

    public static HttpClient getInstance(Context c){
        if (mClient == null) {
            mClient = new HttpClient(c);
        }
        return  mClient;
    }


    // GET方法
    public void get(String url, HashMap<String,String> param, final MyCallback callback) {
        // 拼接请求参数
        if (!param.isEmpty()) {
            StringBuffer buffer = new StringBuffer(url);
            buffer.append('?');
            for (Map.Entry<String,String> entry: param.entrySet()) {
                buffer.append(entry.getKey());
                buffer.append('=');
                buffer.append(entry.getValue());
                buffer.append('&');
            }
            buffer.deleteCharAt(buffer.length()-1);
            url = buffer.toString();
        }
        Request.Builder builder = new Request.Builder().url(url);
        builder.method("GET", null);
        Request request = builder.build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.failed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.success(response);
            }
        });
    }

    public void get(String url, MyCallback callback) {
        get(url, new HashMap<String, String>(), callback);
    }

    // POST 方法
    public void post(String url, HashMap<String, String> param, final MyCallback callback) {
        FormBody.Builder formBody = new FormBody.Builder();
        if(!param.isEmpty()) {
            for (Map.Entry<String,String> entry: param.entrySet()) {
                formBody.add(entry.getKey(),entry.getValue());
            }
        }
        RequestBody form = formBody.build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.post(form)
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.failed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.success(response);
            }
        });
    }
    public interface MyCallback {
        void success(Response res) throws IOException;
        void failed(IOException e);
    }
}