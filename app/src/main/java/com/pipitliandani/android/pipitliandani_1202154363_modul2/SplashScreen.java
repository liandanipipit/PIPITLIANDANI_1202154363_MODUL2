package com.pipitliandani.android.pipitliandani_1202154363_modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    private static int interval = 2000; //mendeklarasikan nilai interval
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //meminta request Window
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);    //menampilkan layout activity_splash_screen

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);  //membuat intent
                startActivity(intent);  //membuat aktivitas intent
                Toast.makeText(SplashScreen.this, "PIPITLIANDANI_1202154363", Toast.LENGTH_LONG).show(); //membuat toast untuk menampilkan PIPITLIANDANI_1202154363
                this.finish(); //mengakhiri splashScreen
            }
            private void finish(){

            }
        }, interval); //mengakhiri splashScreen dengan interval 2000

    }
}
