package com.example.user.gamelanbekonang.menuAkun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.gamelanbekonang.R;
import com.example.user.gamelanbekonang.adapter.AdapterAkun;
import com.example.user.gamelanbekonang.logRes.LoginActivity;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.user.gamelanbekonang.logRes.LoginActivity.my_shared_preferences;


public class AkunFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView tv_id, tv_name, tv_email, tv_notelp;
    private ImageView iv;
    private ArrayList<String> InfoAkun;
    private ArrayList<Integer> GambarAkun;
    //nama listnya
    private String[] Nama = {"TENTANG", "BANTUAN"};
    //Daftar gambar
    private int[] Gambar = {R.drawable.ic_akun, R.drawable.ic_home};
    SharedPreferences sharedpreferences;
    Context context;
    Button btnlogin;
    private String TAG;

    public AkunFragment() {
        // Required empty public constructor

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_akun, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InfoAkun = new ArrayList<>();
        GambarAkun = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rv_akun);
        DaftarItem();

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new AdapterAkun(InfoAkun, GambarAkun);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
        sharedpreferences = context.getSharedPreferences(my_shared_preferences, MODE_PRIVATE);
        String id = (sharedpreferences.getString("id", ""));
        tv_id.setText(id);
        String image = (sharedpreferences.getString("image", ""));
        String name = (sharedpreferences.getString("name", ""));
        tv_name.setText(name);
        String email = (sharedpreferences.getString("email", ""));
        tv_email.setText(email);
        String notelp = (sharedpreferences.getString("notelp", ""));
        tv_notelp.setText(notelp);
        Log.d(TAG, "JKOEr: "+id+image+name+email+notelp);
        btnlogin = (Button) view.findViewById(R.id.btn_masuk);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent  (getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }

    private void DaftarItem() {
        for (int w=0; w<Nama.length; w++){
            GambarAkun.add(Gambar[w]);
            InfoAkun.add(Nama[w]);
        }
    }

}
