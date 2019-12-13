package com.example.customkuy.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.customkuy.CustomActivity;
import com.example.customkuy.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Button btn_custom = (Button) rootView.findViewById(R.id.btn_custom);

        btn_custom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getActivity(),CustomActivity.class);
                getActivity().startActivity(i);
            }
        });
        return rootView;
    }

}