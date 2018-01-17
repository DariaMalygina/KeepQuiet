package com.example.daria.keepquiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class DialogsActivity extends AppCompatActivity {
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        VKSdk.login(this);
        info = findViewById(R.id.info);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Открыть список диалогов
                info.setText("login");
            }

            @Override
            public void onError(VKError error) {
                // Отобразить окно ошибки
                info.setText("error");
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
