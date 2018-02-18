package com.pipitliandani.android.pipitliandani_1202154363_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;  //mendeklarasikan variabel Radio Group
    RadioButton rdTakeAway, rdDineIn;   //mendeklarasikan variabel RadioButton
    Button btnPesan;    //mendeklarasikan variabel Spinner
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //menampilkan layout activity_main
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup); //mencari RadioGroup dengan id radioGroup
        rdDineIn = (RadioButton)findViewById(R.id.dineIn);  //mencari RadioButton dengan id dineIn
        rdTakeAway = (RadioButton)findViewById(R.id.takeaway); //mencari RadioButton dengan id takeAway
        btnPesan = (Button)findViewById(R.id.pesan);    //mencari Button dengan id pesan
        btnPesan.setOnClickListener(new View.OnClickListener() {    //membuat event saat button pesan di klik
            @Override
            public void onClick(View v) {
                int selectedItem = radioGroup.getCheckedRadioButtonId(); //menselected item yang dipilih
                if (selectedItem==rdDineIn.getId()){    //jika selected item sama dengan rdDineIn
                    Intent intent = new Intent(MainActivity.this, DineIn.class); // maka akan berpindah ke activity DineIn
                    startActivity(intent);  //memulai aktivitas intent
                    Toast.makeText(MainActivity.this, "Dine In", Toast.LENGTH_LONG).show(); //membuat toast
                } else {    //jika selected item sama dengan rdDineIn
                    Intent intent1 = new Intent(MainActivity.this, TakeAway.class); // maka akan berpindah ke activity DineIn
                    startActivity(intent1);     //memulai aktivitas intent
                    Toast.makeText(MainActivity.this, "Take Away", Toast.LENGTH_LONG).show();   //membuat toast
                }
            }
        });

    }
}
