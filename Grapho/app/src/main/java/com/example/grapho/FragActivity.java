package com.example.grapho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        BottomNavigationView botnav=findViewById(R.id.bottom_navigation);
            botnav.setOnNavigationItemSelectedListener(navListener);
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.about){
            Intent intent=new Intent(getApplicationContext(),AboutActivity.class);
            startActivity(intent);
            return true;

        }
        return false;

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment sele=null;
            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    sele=new HomeFragment();
                    break;

                case R.id.base:
                    sele=new BasicFragment();
                    break;

                case R.id.adv:
                    sele=new AdvanceFragment();
                    break;


            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,sele).commit();
        return true;
        }
    };
}
