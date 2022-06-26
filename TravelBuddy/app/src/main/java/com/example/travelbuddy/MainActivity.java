package com.example.travelbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    NavigationBarView NavigationBarView;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    Button signout;
    TextView email;
    RecyclerView mRecyclerView;
//    Button wallet;
    ArrayList<RecyclerViewAdapter> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationBarView = findViewById(R.id.bottom_nav);
        NavigationBarView.setSelectedItemId(R.id.home);
        NavigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.timeline:
                        startActivity(new Intent(getApplicationContext(),Timeline.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(),setting.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.wallet:
                        startActivity(new Intent(getApplicationContext(),Wallet.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
        signout = findViewById(R.id.signout);
        email = findViewById(R.id.email);
//        wallet = findViewById(R.id.wallet);
        mRecyclerView = findViewById(R.id.recycler);
        Integer[] photo = {R.drawable.badrinath, R.drawable.gangotri, R.drawable.kedarnath, R.drawable.yamunotri};
        String[] chardham = {"Badrinath", "Gangotri", "Kedarnath", "Yamunotri"};

        mainModels = new ArrayList<>();
        for (int i = 0; i < photo.length; i++) {
            RecyclerViewAdapter model = new RecyclerViewAdapter(photo[i], chardham[i]);
            mainModels.add(model);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

//        mRecyclerView.addOnItemTouchListener(new RecyclerItemClick);

        mainAdapter = new MainAdapter(MainActivity.this, mainModels);
        mRecyclerView.setAdapter(mainAdapter);


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String name = acct.getDisplayName();
            email.setText(name);
        }
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signout();
            }
        });
//        wallet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent w = new Intent(MainActivity.this, Wallet.class);
//                startActivity(w);
//            }
//        });

    }

   public void signout() {
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });
    }

}
