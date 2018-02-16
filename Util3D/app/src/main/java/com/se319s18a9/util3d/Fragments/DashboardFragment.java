package com.se319s18a9.util3d.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.se319s18a9.util3d.R;
import com.se319s18a9.util3d.backend.User;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    Button settingsButton;
    Button logoutButton;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container != null) {
            container.removeAllViews();
        }

        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        settingsButton = v.findViewById(R.id.fragment_dashboard_button_settings);
        settingsButton .setOnClickListener(this);

        logoutButton = v.findViewById(R.id.fragment_dashboard_button_logout);
        logoutButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fragment_dashboard_button_createProject:
                // TODO
                break;
            case R.id.fragment_dashboard_button_openProject:
                // TODO
                break;
            case R.id.fragment_dashboard_button_settings:
                Toast.makeText(getContext(), R.string.global_appName, Toast.LENGTH_SHORT).show();
                Fragment settingsFragment = new SettingsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activity_main_frameLayout_root, settingsFragment);
                fragmentTransaction.addToBackStack(null).commit();
                break;
            case R.id.fragment_dashboard_button_logout:
                User.getInstance().signOut();
                Toast.makeText(getContext(), R.string.s_fragment_dashboard_alertMessage_loggedOut, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
