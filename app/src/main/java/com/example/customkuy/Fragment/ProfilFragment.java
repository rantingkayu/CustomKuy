package com.example.customkuy.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.customkuy.EditProfilActivity;
import com.example.customkuy.R;
import com.example.customkuy.Welcom.MainWelcome;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilFragment extends Fragment {


    private String activity;

    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profil, container, false);


      Button btn_logout = (Button)rootView.findViewById(R.id.btn_logout);
     ImageView to_edit = (ImageView) rootView.findViewById(R.id.to_edit);



        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MainWelcome.class);
                getActivity().startActivity(i);
            }
        });


        to_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),EditProfilActivity.class);
                getActivity().startActivity(i);
            }
        });

        return rootView;

    }
}