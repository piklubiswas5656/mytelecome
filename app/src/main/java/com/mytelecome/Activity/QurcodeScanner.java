package com.mytelecome.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.mytelecome.Constant.Constant;
import com.mytelecome.R;

public class QurcodeScanner extends AppCompatActivity {
    private CodeScanner codeScanner;
    private TextView scantext;
    private CodeScannerView scannerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qurcode_scanner);
        scannerView = findViewById(R.id.scanner_view);
        scantext = findViewById(R.id.scantext);

        checkPermition();
    }

    public void runCodeScanner() {
        codeScanner = new CodeScanner(this, scannerView);
        codeScanner.setAutoFocusEnabled(true);
        codeScanner.setFormats(CodeScanner.ALL_FORMATS);
        codeScanner.setScanMode(ScanMode.CONTINUOUS);
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        String data = result.getText();
//                        scantext.setText(data);
//                    }
//                });

                Intent intent = new Intent(getApplicationContext(), Qrinvoice.class);
                intent.putExtra(Constant.QRinvoice, result.getText());
                startActivity(intent);
            }
        });
    }

    public void checkPermition() {
        Dexter.withContext(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        runCodeScanner();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();
    }

    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        codeScanner.releaseResources();
        super.onPause();
    }

}