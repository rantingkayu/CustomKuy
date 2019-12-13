package com.example.customkuy.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.customkuy.KonfirmasiBarangAnda;
import com.example.customkuy.R;
import com.example.customkuy.RiwayatTransaksiActivity;
import com.example.customkuy.StatusPesananActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotifFragment extends Fragment {
    private TextView to_riwayat,to_meja,to_status;

    public NotifFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_notif, container, false);

        to_riwayat = rootView.findViewById(R.id.to_riwayat);
        to_meja = rootView.findViewById(R.id.to_meja);
        to_status = rootView.findViewById(R.id.to_status);


        to_riwayat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getActivity(),RiwayatTransaksiActivity.class);
                getActivity().startActivity(i);
            }
        });

        to_meja.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getActivity(),KonfirmasiBarangAnda.class);
                getActivity().startActivity(i);
            }
        });

        to_status.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getActivity(),StatusPesananActivity.class);
                getActivity().startActivity(i);
            }
        });

                return rootView;
            }
        }