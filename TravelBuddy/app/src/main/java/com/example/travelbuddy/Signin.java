package com.example.travelbuddy;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    Button login;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView google;

    private FirebaseAuth mAuth;
    private EditText email;
    EditText password;
    private Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        login = findViewById(R.id.login);

        mAuth= FirebaseAuth.getInstance();
        email= findViewById(R.id.email);
        password=findViewById(R.id.password);
        Register=findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signin.this, Login.class);
                startActivity(i);
            }
        });

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            navigateToDashboard();
        }

        google = findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

    }
    private void signIn() {
        Intent signinintent= gsc.getSignInIntent();
        startActivityForResult(signinintent,100);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 ){
            Task<GoogleSignInAccount> task= GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToDashboard();
            } catch (ApiException e) {
                Toast.makeText(this, "Something Went Wrong.Login Failed!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void navigateToDashboard() {
        finish();
        Intent db=new Intent(Signin.this, MainActivity.class);
        startActivity(db);
    }

    private void Register() {
        String user= email.getText().toString().trim();
        String pass= password.getText().toString().trim();
        if(user.isEmpty()){
            email.setError("Email can't be empty.");
        }
        if(pass.isEmpty()){
            password.setError("Password can't be empty.");
        }
        else{
            mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Signin.this, "User registered Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Signin.this, MainActivity.class));
                    } else {
                        Toast.makeText(Signin.this, "User not registered." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

    }
