package com.example.user.gamelanbekonang.menuHome;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.user.gamelanbekonang.R;
import com.squareup.picasso.Picasso;

public class DetailIklanActivity extends AppCompatActivity {
    private String gambarIklan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_iklan);

        Bundle bundle = getIntent().getExtras();
        final String judul = bundle.getString("judul");
//        tvDetUsername.setText(bundle.getString("username"));
//        tvDetWaktu.setText(bundle.getString("waktu"));
//        tvDetStatus.setText(bundle.getString("status"));
//        tvDetTujuan.setText(bundle.getString("tujuan"));
        gambarIklan = bundle.getString("image");

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(judul);

        loadBackdrop();


    }

    private void loadBackdrop() {
        final ImageView imageView = findViewById(R.id.backdrop);
        Picasso.get().load("http://bekonang-store.000webhostapp.com/images/"+gambarIklan).centerCrop().resize(1600, 850).error(R.mipmap.ic_launcher).into(imageView);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.sample_actions, menu);
//        return true;
//    }

    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
