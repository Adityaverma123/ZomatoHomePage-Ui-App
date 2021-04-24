package com.example.zomatohomepage_frontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private DonateFragment donateFragment;
    private HistoryFragment historyFragment;
    private View view1,view2,view3;
    private ImageView cancel;
    private RelativeLayout banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        historyFragment=new HistoryFragment();
        donateFragment=new DonateFragment();
        homeFragment=new HomeFragment();
        view1=findViewById(R.id.view1);
        view2=findViewById(R.id.view2);
        view3=findViewById(R.id.view3);
        banner=findViewById(R.id.banner);
        cancel=findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banner.setVisibility(View.GONE);
            }
        });
        BottomNavigationView navigationView=findViewById(R.id.navigation_view);
        loadFragment(homeFragment);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected=null;
                switch (item.getItemId()){
                    case R.id.donate:
                        selected=donateFragment;
                        view1.setVisibility(View.INVISIBLE);
                        view2.setVisibility(View.INVISIBLE);
                        view3.setVisibility(View.VISIBLE);

                    break;
                    case R.id.history:
                        selected=historyFragment;
                        view1.setVisibility(View.INVISIBLE);
                        view2.setVisibility(View.VISIBLE);
                        view3.setVisibility(View.INVISIBLE);
                    break;
                    case R.id.order:
                        selected=homeFragment;
                        view1.setVisibility(View.VISIBLE);
                        view2.setVisibility(View.INVISIBLE);
                        view3.setVisibility(View.INVISIBLE);
                    break;
                }
                loadFragment(selected);
                return true;
            }
        });
    }

    private void loadFragment(Fragment selected) {
        getSupportFragmentManager().beginTransaction().replace(R.id.relative_layout,selected).commit();

    }
}