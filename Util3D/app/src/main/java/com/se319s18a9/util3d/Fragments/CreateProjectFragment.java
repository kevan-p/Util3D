package com.se319s18a9.util3d.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.se319s18a9.util3d.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateProjectFragment extends Fragment {

    public CreateProjectFragment() {
        // Empty constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    public void onClick(View v) {
        // TODO: Add Switch statement for save buttons
    }

}
