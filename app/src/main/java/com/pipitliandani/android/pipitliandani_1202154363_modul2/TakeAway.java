package com.pipitliandani.android.pipitliandani_1202154363_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TakeAway extends AppCompatActivity {
Button pesanTakeAway; ////mendeklarasikan variabel Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);    //menampilkan layout activity_take_away
        pesanTakeAway = (Button)findViewById(R.id.btnPesan); //mencari Button dengan id btnPesan
        pesanTakeAway.setOnClickListener(new View.OnClickListener() { //membuat event untuk button pesan
            @Override
            public void onClick(View v) {
                Intent takeAway = new Intent(TakeAway.this, DaftarMenu.class);  //membuat intent untuk berpindah ke class DaftarMenu
                Toast.makeText(getApplicationContext(), "pesanan anda telah terkirim", Toast.LENGTH_LONG).show();   //membuat Toast
                startActivity(takeAway);    //memulai aktivitas
            }
        });

    }
}
