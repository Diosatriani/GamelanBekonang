package com.example.user.gamelanbekonang.menuAkun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.user.gamelanbekonang.R;
import com.example.user.gamelanbekonang.menuBantuan.CaraDaftarActivity;
import com.example.user.gamelanbekonang.menuBantuan.MenandaiActivity;

public class BantuanActivity extends AppCompatActivity {

    private Toolbar mActionToolbar;
    private Spinner spinnerAkun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);

        spinnerAkun = findViewById(R.id.s_akun);
        ArrayAdapter<String> myAkun = new ArrayAdapter<String>(BantuanActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.akun));
        myAkun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAkun.setAdapter(myAkun);

        spinnerAkun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1){
                    startActivity(new Intent(BantuanActivity.this, CaraDaftarActivity.class));
                } else if (position == 2){
                    startActivity(new Intent(BantuanActivity.this, MenandaiActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mActionToolbar = (Toolbar) findViewById(R.id.tabs);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("BANTUAN");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
