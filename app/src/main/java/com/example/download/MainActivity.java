package com.example.download;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    Button materialButton;
    DownloadManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.url);
        materialButton = findViewById(R.id.btn);



        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = (String) editText.getText().toString();
                manager = (DownloadManager) getSystemService(MainActivity.this.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(url.trim());
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Abhinav.pdf");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                request.allowScanningByMediaScanner();
                long reference = manager.enqueue(request);
            }
        });
    }
}