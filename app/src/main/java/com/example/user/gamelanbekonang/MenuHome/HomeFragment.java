package com.example.user.gamelanbekonang.MenuHome;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.gamelanbekonang.Adapter.AdapterIklan;
import com.example.user.gamelanbekonang.Beans.Iklan;
import com.example.user.gamelanbekonang.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Iklan> iklans;
    private ProgressDialog dialog;
    private AdapterIklan adapter;
    RecyclerView recyclerView;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
