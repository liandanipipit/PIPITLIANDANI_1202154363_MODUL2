package com.pipitliandani.android.pipitliandani_1202154363_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DineIn extends AppCompatActivity {
    Spinner meja;   //mendeklarasikan variabel Spinner
    Button pesan;   //mendeklarasikan variabel Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in); //menampilkan layout activity_dine_in
        meja = (Spinner)findViewById(R.id.spinner);  //mencari Spinner dengan id spinner
        pesan = (Button)findViewById(R.id.pesanan);     //mencari Button dengan id pesanan
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        //membuat variabel ArrayAdapter dan mengambil resource labels array
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //mengatur Drop down view resource dengan simple_spinner_dropdown item
        meja.setAdapter(adapter);   //mengatur value meja dengan variabel adapter
        pesan.setOnClickListener(new View.OnClickListener() { //membuat event untuk button pesan
            @Override
            public void onClick(View v) {
                String info = meja.getSelectedItem().toString(); //mengconvert variabel meja ke dalam ke dalam String
                Toast.makeText(getApplicationContext(), "Anda memesan meja no " + info, Toast.LENGTH_LONG).show();  //Membuat text
                Intent i = new Intent(DineIn.this, DaftarMenu.class);   //membuat intent untuk berpindah ke class daftar menu
                startActivity(i); //memulai aktivitas intent
            }
        });
 //
    }
}
