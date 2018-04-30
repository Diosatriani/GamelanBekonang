package com.example.user.gamelanbekonang.menuAkun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.gamelanbekonang.R;
import com.example.user.gamelanbekonang.menuBantuan.CaraDaftarActivity;
import com.example.user.gamelanbekonang.menuBantuan.JualBeliActivity;
import com.example.user.gamelanbekonang.menuBantuan.KebijakanActivity;
import com.example.user.gamelanbekonang.menuBantuan.KetentuanActivity;
import com.example.user.gamelanbekonang.menuBantuan.SyaratActivity;

public class BantuanActivity extends AppCompatActivity {

    private Toolbar mActionToolbar;
    private TextView akun,tip, syarat, syaratU, privasi;
//    private Spinner spinnerAkun;
//    private Spinner spinnerTips;
//    private Spinner spinnerSyarat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);


        mActionToolbar = (Toolbar) findViewById(R.id.tabs);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("BANTUAN");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

//        spinnerAkun = findViewById(R.id.s_akun);
//        ArrayAdapter<String> myAkun = new ArrayAdapter<String>(BantuanActivity.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.akun));
//        myAkun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerAkun.setAdapter(myAkun);
//
//        spinnerAkun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 1){
//                    startActivity(new Intent(BantuanActivity.this, CaraDaftarActivity.class));
//                } else if (position == 2){
//                    startActivity(new Intent(BantuanActivity.this, SyaratActivity.class));
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

//        spinnerTips = findViewById(R.id.s_tips);
//        ArrayAdapter<String> myTips = new ArrayAdapter<String>(BantuanActivity.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tips));
//        myAkun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerTips.setAdapter(myTips);
//
//        spinnerTips.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                 if (position == 0){
//                    startActivity(new Intent(BantuanActivity.this, JualBeliActivity.class));
//                }else if (position ==1){
//                    startActivity(new Intent(BantuanActivity.this, JualBeliActivity.class));
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

//        spinnerSyarat = findViewById(R.id.s_syarat);
//        ArrayAdapter<String> mySyarat = new ArrayAdapter<String>(BantuanActivity.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.syarat));
//        mySyarat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerSyarat.setAdapter(mySyarat);
//
//        spinnerTips.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0){
//                    startActivity(new Intent(BantuanActivity.this, JualBeliActivity.class));
//                }else if (position ==1){
//                    startActivity(new Intent(BantuanActivity.this, JualBeliActivity.class));
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        akun = findViewById(R.id.tv_akun);
        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BantuanActivity.this, CaraDaftarActivity.class);
                startActivity(intent);
            }
        });

        tip = findViewById(R.id.tv_tips);
        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BantuanActivity.this, JualBeliActivity.class);
                startActivity(intent);
            }
        });

//        syarat = findViewById(R.id.tv_syarat);
//        syarat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(BantuanActivity.this, SyaratActivity.class);
//                startActivity(intent);
//            }
//        });

        syaratU = findViewById(R.id.tv_syaratumum);
        syaratU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BantuanActivity.this, KetentuanActivity.class);
                startActivity(intent);
            }
        });

        privasi = findViewById(R.id.tv_privasi);
        privasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BantuanActivity.this, KebijakanActivity.class);
                startActivity(intent);
            }
        });
    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
