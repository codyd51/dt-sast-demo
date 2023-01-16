package com.datatheorem.dt_sast_demo;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class App {
    public static void main(String[] args) {
        WebView wv = new WebView(new AppCompatActivity());
        wv.addJavascriptInterface(null, "javascriptInvoke");
        wv.loadUrl("https://untrusted-web-content.com");

        System.out.printf("OAuth refresh token: 1/DGXUA3FmzHZnjEJDvX8ynqJCALJpo6ZT3IVNK6aBYHU");

		System.out.println("Test with Victor");
    }
}
