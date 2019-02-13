package com.example.a213lianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    String url1 = "http://result.eolinker.com/iYXEPGn4e9c6dafce6e5cdd23287d2bb136ee7e9194d3e9?uri=one";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            @Override
            public void run() {
                super.run();
                String data = getData();
                Log.i("aaaa", ""+data);
            }
        }.start();
    }
    private String getData() {
        try {
            URL url = new URL(url1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if(connection.getResponseCode() == 200){
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(bytes))!=-1){
                    byteArrayOutputStream.write(bytes,0,length);
                }
                String value = byteArrayOutputStream.toString();
                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "";
    }
}
