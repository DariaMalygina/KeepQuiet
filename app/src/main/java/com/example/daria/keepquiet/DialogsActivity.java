package com.example.daria.keepquiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

public class DialogsActivity extends AppCompatActivity {
    private Button signInButton;
    private RecyclerView dialogsList;
    private TextView errorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("ApiVersion", VKSdk.getApiVersion());
        setContentView(R.layout.activity_dialogs);

        signInButton = findViewById(R.id.sing_in_button);
        signInButton.setVisibility(View.INVISIBLE);

        dialogsList = findViewById(R.id.dialogs_list);
        dialogsList.setHasFixedSize(true);
        dialogsList.setVisibility(View.VISIBLE);

        errorView = findViewById(R.id.error_view);
        errorView.setVisibility(View.INVISIBLE);


        if (!VKSdk.isLoggedIn()) {
            signInButton.setVisibility(View.VISIBLE);
        } else {
            //TODO: request data for list
        }


        //VKRequest request = new VKRequest("account.setSilenceMode", VKParameters.from(VKApiConst.USER_ID, 384890977, "time", 20));
        /*VKRequest request = new VKRequest("account.setSilenceMode", VKParameters.from("chat_id", 90, "time", 0));

        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                Log.w("VKRequestListener", "onComplete");
            }
            @Override
            public void onError(VKError error) {
                Log.w("VKRequestListener", error.toString());
            }
            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {
                Log.w("VKRequestListener", "attemptFailed");
            }
        });*/

    }

    public void onClickSingInButton(View view) {
        VKSdk.login(this, "messages");
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                res.saveTokenToSharedPreferences(DialogsActivity.this, getString(R.string.saved_token));
                signInButton.setVisibility(View.INVISIBLE);

                //TODO: request data for list

            }

            @Override
            public void onError(VKError error) {
                errorView.setVisibility(View.VISIBLE);
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}