package com.mytelecome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebView;
import android.widget.TextView;

import com.mytelecome.ApiController.ApiController;
import com.mytelecome.Constant.Constant;
import com.mytelecome.Modal.Login.Userlogin;
import com.mytelecome.Modal.VerifyInvoice.VerifyInvoice;
import com.mytelecome.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Qrinvoice extends AppCompatActivity {
    private String qrinvoice;
    private Call<VerifyInvoice> call;
    private TextView qrtext;
    WebView webview;
    private String unencodedHtml;
    private String ath_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrinvoice);
        qrinvoice = getIntent().getStringExtra(Constant.QRinvoice);
        if (ath_key == null) {
            SharedPreferences getShared = getSharedPreferences(Constant.Login, MODE_PRIVATE);
            ath_key = getShared.getString(Constant.Auth_Key, Constant.Auth_Key);
        }

        webview = (WebView) this.findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setSupportZoom(true);
        getdata();


    }

    private void getdata() {

        call = ApiController.getInstance().getapi().verifyInvoice(
                qrinvoice,
                Constant.apikey,
                Constant.VerifyInvoice,
                "317a2f77738f0e57c915e9699e89e7dd"
        );
        call.enqueue(new Callback<VerifyInvoice>() {
            @Override
            public void onResponse(Call<VerifyInvoice> call, Response<VerifyInvoice> response) {

                unencodedHtml = response.body().getData().getTable();
                String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
                        Base64.NO_PADDING);
                webview.loadData(encodedHtml, "text/html", "base64");
            }

            @Override
            public void onFailure(Call<VerifyInvoice> call, Throwable t) {

            }
        });

    }
}