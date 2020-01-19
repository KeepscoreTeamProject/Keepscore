package com.uhi.keepscore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    RegisterFragment f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.btnTemp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1 = new RegisterFragment();
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle("Register");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayout_fragmentContainer, f1)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null).commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                Toast.makeText(this, "you clicked", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().popBackStack();
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                break;
            case R.id.menuItem_register:
                Toast.makeText(this, "you clicked Register", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem_signIn:
                Toast.makeText(this, "you clicked Sign in", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
