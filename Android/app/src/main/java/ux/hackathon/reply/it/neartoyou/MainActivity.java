package ux.hackathon.reply.it.neartoyou;


import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.FacebookSdk;

import ux.hackathon.reply.it.neartoyou.nearintentservice.NearToYouIntentService;

import static com.facebook.FacebookSdk.getApplicationContext;
import static com.facebook.FacebookSdk.sdkInitialize;

public class MainActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        final LoginButton loginButton;
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("LOGIN SUCCESS CALLBACK", loginResult.getAccessToken().getUserId());
                Log.d("LOGIN SUCCESS CALLBACK", "Invoco la partenza dell'intent");
                startIntentService();
                Toast.makeText(getApplicationContext(), "I'll be with you!", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                Log.e(this.toString(), exception.getMessage());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void startIntentService() {
        // fa partire l'intent per la ripetizione periodica della chiamata
        Log.d("LOGIN SUCCESS CALLBACK", "Entro in startIntentService");
        serviceIntent = new Intent(this, NearToYouIntentService.class);
        this.startService(serviceIntent);
    }

}
