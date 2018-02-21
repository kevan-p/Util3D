package com.se319s18a9.util3d.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.se319s18a9.util3d.R;

public class CreateProjectFragment extends Fragment implements View.OnClickListener {

    Button createProjectButton;

    public CreateProjectFragment() {
        // Empty constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_createproject, container, false);

        createProjectButton = v.findViewById(R.id.fragment_createProject_button_create);
        createProjectButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        // TODO: Add Switch statement for save buttons
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

        switch(v.getId()) {
            case R.id.fragment_createProject_button_create:
                Fragment mapFragment = new MapFragment();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activity_main_frameLayout_root, mapFragment);
                fragmentTransaction.addToBackStack(null).commit();
            break;
        }
    }

}
