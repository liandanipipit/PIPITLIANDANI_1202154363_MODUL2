package com.pipitliandani.android.pipitliandani_1202154363_modul2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.io.IOException;
import java.io.InputStream;

public class DetailMenu extends AppCompatActivity {

    TextView price, tittle;
    ImageView img;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //membuat method yang berfungsi ketika toolbar di klik maka akan berpindah ke main activity
        if (item.getItemId() == android.R.id.home) {    //
            Intent intent = new Intent(this, MainActivity.class); //membuat intent untuk toolbar
            startActivity(intent);  //memulai aktivitas intent
        }
        return super.onOptionsItemSelected(item); //mengembalikan method onOptionsItemSelected
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);  //menampilkan layout activity_detail_menu
        Intent intent = getIntent();    //mendapatkan intent dari Daftar Menu.class
        final String judul = intent.getStringExtra("TITLE").toString(); //mendapatkan value TITLE dari DaftarMenu.class
        final String harga = intent.getStringExtra("PRICE").toString(); // mendapatkan value PRICE dari DaftarMenu.class
        final String image = intent.getStringExtra("IMAGE").toString(); //mendapatkan value IMAGE dari DaftarMenu.class
        tittle = (TextView)findViewById(R.id.tittle);   //mencari textView dengan id tittle
        price = (TextView)findViewById(R.id.harga);     //mencari textView dengan id harga
        img = (ImageView)findViewById(R.id.imgDetail);  //mencari textView dengan id imgDetail
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //mencari Toolbar dengan id toolbar
        setSupportActionBar(toolbar);   //mengatur kompatibilitas toolbar terhadap detail menu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mengaktifkan back button toolbar
        tittle.setText(judul);  //mengatur value tittle dengan value judul
        price.setText(harga);   //mengatur value tittle dengan value harga
        InputStream is;     //mendeklarasikan variabel InputStream
        AssetManager assetManager = this.getAssets();   //membuat objek asset manager
        try {
            is = assetManager.open(image +".png");  //membuka aset berupa gambar
            Bitmap bitmap = BitmapFactory.decodeStream(is); //membuat bitmap
            img.setImageBitmap(bitmap); //mengatur value img dengan variabel bitmap
            is.close(); //menutup Input Stream
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, intent.getStringExtra("TITLE").toString(), Toast.LENGTH_SHORT).show(); //membuat Toast dengan value TITTLE dari class DaftarMenu

    }
}
