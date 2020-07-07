package com.ntu.dip2020;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;
    /*private GoogleSignInClient mGoogleSignInClient;
    public Button SignIn;
    private CloudStoreInterface cloudStore;
    private FirebaseInterface firebase;
    private Intent intent;
    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private static final String TAG = "MyActivity";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSignInIntent();
        /*intent = getIntent();
        mAuth = FirebaseAuth.getInstance();
        SignIn = (Button)findViewById(R.id.btn_login);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });*/
    }


    public void createSignInIntent() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.EmailBuilder().build());
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder().setIsSmartLockEnabled(true)
                .setAvailableProviders(providers)
                .build(),RC_SIGN_IN);
    }

    // [START auth_fui_result]
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            } else {
                assert response != null;
                Toast.makeText(this, ""+ Objects.requireNonNull(response.getError()).getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}