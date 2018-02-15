package com.se319s18a9.util3d;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createProjectButton;
    Button openProjectButton;
    Button settingsButton;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createProjectButton = findViewById(R.id.activity_main_button_createProject);
        openProjectButton = findViewById(R.id.activity_main_button_openProject);
        settingsButton = findViewById(R.id.activity_main_button_settings);
        logoutButton = findViewById(R.id.activity_main_button_logout);

        // TODO: Replace with universal OnClick method with Switch statement
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProjectButton.setVisibility(View.GONE);
                openProjectButton.setVisibility(View.GONE);
                settingsButton.setVisibility(View.GONE);
                logoutButton.setVisibility(View.GONE);

//                Fragment settingsFragment = new Fragment();
//                FragmentManager fragmentManager = getFragmentManager();
//
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.activity_main_fragment_main, settingsFragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });
    }
}
