package duan.it.thanh.duanmobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class loginactivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private GoogleApiClient mGoogleApiClient;
    private TextView mStatusTextView;
    private ProgressDialog mProgressDialog;
    CallbackManager callbackManager;
    private LoginButton FbLogin;
    private AccessToken mAccessToken;
    private static final String TAG = "loginactivity";
    private static final int RC_SIGN_IN = 9001;
    private static final int RC_FB_IN = 8001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_login);
        SignInButton btn_logingg = findViewById(R.id.logingg);

        btn_logingg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
                mGoogleApiClient = new GoogleApiClient.Builder(loginactivity.this)
                        .enableAutoManage(loginactivity.this /* FragmentActivity */, loginactivity.this /* OnConnectionFailedListener */)
                        .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                        .build();
                OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
                if (opr.isDone()) {
                    Log.d(TAG, "Got cached sign-in");
                    GoogleSignInResult result = opr.get();
                    handleSignInResult(result);
                } else {
                    showProgressDialog();
                    opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                        @Override
                        public void onResult(GoogleSignInResult googleSignInResult) {
                            hideProgressDialog();
                            handleSignInResult(googleSignInResult);
                        }
                    });
                }
                signIn();
                FbLogin.isEnabled();
            }
        });
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        FbLogin = (LoginButton)findViewById(R.id.loginfb);
        FbLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(loginactivity.this,mainactivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(loginactivity.this,"Welcome to App Thanh-IT", Toast.LENGTH_LONG).show();
                finish();
                LoginManager.getInstance().logOut();
            }
            @Override
            public void onCancel() {
                Toast.makeText(loginactivity.this,"Login attempt canceled.", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(FacebookException e) {
                Toast.makeText(loginactivity.this,"Login attempt failed.", Toast.LENGTH_LONG).show();
            }
        });
    }

    // [START onActivityResult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
            Intent i = new Intent(loginactivity.this,mainactivity.class);
            startActivity(i);
            Toast.makeText(loginactivity.this,"Welcome to App Thanh-IT", Toast.LENGTH_LONG).show();
            finish();
        }
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    // [END onActivityResult]
    // [START handleSignInResult]
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
    }
    // [END handleSignInResult]
    // [START signIn]
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }
    // [END signIn]
    // [START revokeAccess]
    private void revokeAccess() {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
                        updateUI(false);
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END revokeAccess]

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }
    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }
    private void updateUI(boolean signedIn) {
        if (signedIn) {
            findViewById(R.id.logingg).setVisibility(View.GONE);
        } else {
            findViewById(R.id.logingg).setVisibility(View.VISIBLE);
        }
    }

}
