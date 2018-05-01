package com.example.user.gamelanbekonang.menuFavorite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
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

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;
import static com.example.user.gamelanbekonang.logRes.LoginActivity.my_shared_preferences;


public class FavoriteFragment extends Fragment {
    SharedPreferences sharedpreferences;
    Context context;
    private TextView tv_id, tv_name, tv_email, tv_notelp;
    private ImageView iv;
    public static final  String value = "id";
    private int i;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_id =  view.findViewById(R.id.tv_id);
        tv_name = view.findViewById(R.id.tv_namep);
        tv_email = view.findViewById(R.id.tv_emailp);
        tv_notelp = view.findViewById(R.id.tv_notelp);

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(getContext());
//        sharedpreferences = context.getSharedPreferences(my_shared_preferences, MODE_PRIVATE);
        final String id = (sharedPreferences.getString("id", ""));
        tv_id.setText(id);
        String image = (sharedPreferences.getString("image", ""));
        String name = (sharedPreferences.getString("name", ""));
        tv_name.setText(name);
        String email = (sharedPreferences.getString("email", ""));
        tv_email.setText(email);
        String notelp = (sharedPreferences.getString("notelp", ""));
        tv_notelp.setText(notelp);
        Log.d(TAG, "JKOEr: "+id+image+name+email+notelp);


    }
    
}
