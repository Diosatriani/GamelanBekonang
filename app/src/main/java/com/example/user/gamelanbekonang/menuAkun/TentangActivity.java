package com.example.user.gamelanbekonang.menuAkun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.user.gamelanbekonang.R;

public class TentangActivity extends AppCompatActivity {

    private Toolbar mActionToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        mActionToolbar = (Toolbar) findViewById(R.id.tabs);
        setSupportActionBar(mActionToolbar);
        getSupportActionBar().setTitle("TENTANG");

//        WebView view = (WebView) findViewById(R.id.wv_webview);
//        String text = " Wirun merupakan nama desa yang berada di kecamatan Mojolaban yang memiliki akses yang mudah untuk dituju dari Kota Solo dan Karang Anyar.  satu kilometer dari Kota Solo, Desa Wirun menjadi lokasi yang banyak dikunjungi wisatawan lokal hingga mancanegara.\n" +
//                "                Salah satu potensi terbesar yang membuat Wirun dikenal secara global adalah pembuatan kerajinan gamelan oleh para warga desanya.  Oleh karena itu dibuatkan platform iklan berbasis android yang menyediakan sebuah tempat penjualan dengan teknologi yang berkembang pada zaman ini.  Untuk mempermudah pengrajin Gamelan menjual kerajinannya dan bertemu langsung dengan konsumen." +
//                "Tujuan" ;
//        view.loadData("<p style=\"text-align: Aligen Left\">"+ text+"<p>","text/html","UTF-8");

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
