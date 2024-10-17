package com.redhorse.caclulatoer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    private EditText editText;
    private WebView webViewSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        editText = findViewById(R.id.activity_sub__editTextUrl);
        webViewSub = findViewById(R.id.activity_sub__webViewSub);

        WebSettings webSettings = webViewSub.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webViewSub.setWebViewClient(new WebViewClient());

        editText.setOnEditorActionListener((v, actionId, event)->{
         if(actionId == EditorInfo.IME_ACTION_SEARCH){
             String url = editText.getText().toString().trim();

             if(url.startsWith("https://") == false && url.startsWith("http://") == false){
                 url = "http://" + url;

                 editText.setText(url);
             }

             goToUrl(url);

             // 키보드 내리기
             InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
             imm.hideSoftInputFromWindow(v.getWindowToken(),0);

             return true;
         }
         return false;
        });
    }

    private void goToUrl(String url) {
        webViewSub.loadUrl(url);
    }

    public void refreshButton(View view) {
    }
}