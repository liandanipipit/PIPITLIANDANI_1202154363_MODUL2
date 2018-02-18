package com.pipitliandani.android.pipitliandani_1202154363_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class DaftarMenu extends AppCompatActivity {
    private RecycleAdapter rAdapter;        //membuat deklarasi variabel rAdapter
    private ArrayList<String> listGambar, listTitle, listPrice;     //membuat deklarasi variabel listGambar, listTittle, listPrice


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu); //menampilkan layout activity_daftar_menu
        RecyclerView rView = (RecyclerView) findViewById(R.id.recycleView); //mencari recycle view dengan id recycle_view
        rView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this); //membuat Linear Layout Manager
        llm.setOrientation(LinearLayoutManager.VERTICAL);   //mengatur orientation linear leyout manager
        rView.setLayoutManager(llm);    //mengatur value set layout manager dengan variabel llm
        ambidata(); //mengambil data
        rAdapter = new RecycleAdapter(this, listGambar, listTitle, listPrice); //membuat Recycle Adapter
        rView.setAdapter(rAdapter); //mengatur value Adapter dengan variabel rAdapter
    }


    public void ambidata() { // method ambil data untuk mengambil data yang akan ditampilkan
        listGambar = new ArrayList<>(); //menambahkan gambar kedalam arraylist
        listGambar.add("ayam_goreng");
        listGambar.add("nasi_goreng");
        listGambar.add("ayam_geprek");
        listGambar.add("cumi");
        listGambar.add("ikan_bakar");
        listGambar.add("sayur_asem");

        listTitle = new ArrayList<>(); //menambahkan judul kedalam arraylist
        listTitle.add("Ayam Goreng");
        listTitle.add("Nasi Goreng");
        listTitle.add("Ayam Geprek");
        listTitle.add("Cumi Asam Manis Pedas");
        listTitle.add("Ikan Bakar");
        listTitle.add("Sayur Asem");

        listPrice = new ArrayList<>(); //menambahkan harga kedalam arraylist
        listPrice.add("25.000");
        listPrice.add("20.000");
        listPrice.add("25.000");
        listPrice.add("30.000");
        listPrice.add("45.000");
        listPrice.add("15.000");
    }
}
