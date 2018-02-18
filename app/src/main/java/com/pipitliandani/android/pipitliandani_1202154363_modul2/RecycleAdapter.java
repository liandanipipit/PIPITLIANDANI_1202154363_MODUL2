package com.pipitliandani.android.pipitliandani_1202154363_modul2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by User on 17/02/2018.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    protected static ArrayList<String> listGambar, listTitle, listPrice;    //mendeklarasikan variabel ArrayList
    protected Activity activity;    //mendeklarasikan variabel Activity

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTextView, mPrice; //mendeklarasikan variabel TextView
        private ImageView mImage;   //mendeklarasikan variabel ImageView
        private final Context context;  //mendeklarasikan variabel Context

        public ViewHolder (View view){  //constructor dari inner class ViewHolder
            super(view);
            context = view.getContext();     //mendapatkan context
            view.setOnClickListener(this);  //membuat event saat list di klik
            mTextView=(TextView)view.findViewById(R.id.txt_card);   //mencari TextView dengan id txtCard
            mImage=(ImageView)view.findViewById(R.id.img_card); //mencari ImageView dengan img_card
            mPrice = (TextView)view.findViewById(R.id.txt_price);   //mencari TextView dengan id txt_price
        }

        @Override
        public void onClick(View v) {
            Intent menu = new Intent(context, DetailMenu.class);    //membuat intent untuk berpindah ke DetailMenu.class
            menu.putExtra("TITLE", listTitle.get(getAdapterPosition()));    //mengambil list judul
            menu.putExtra("PRICE", listPrice.get(getAdapterPosition()));    //mengambil list price
            menu.putExtra("IMAGE", listGambar.get(getAdapterPosition()));   //mengambil list gambar

            context.startActivity(menu);    //memulai aktivitas intent
        }
    }
    public RecycleAdapter() {}
    public RecycleAdapter(Activity activity,ArrayList<String> listGambar, ArrayList<String> listTitle, ArrayList<String> listPrice) {
        this.listGambar = listGambar;   //membuat variabel list gambar
        this.listTitle = listTitle;     //membuat variabel list tittle
        this.listPrice = listPrice;     //membuat variabel list price
        this.activity = activity;       //membuat variabel activity
    }
    @Override
    public int getItemCount() {
        return listGambar.size();
    }   //mengembalikan nilai ukuran gambar
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())   // class yang bisa digunakan untuk membuat java object view dari layout yang kita buat di xml.
                .inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);  //membuat ViewHolder
        return vh;  //mengembalikan variabel vh
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(listTitle.get(position)); //mengatur textView list tittle berdasarkan indeks array
        holder.mPrice.setText(listPrice.get(position)); //mengatur textView list tittle berdasarkan indeks array

        // menampilkan gambar dari folder assets
        AssetManager assetManager = activity.getAssets();
        InputStream is;
        try {
            is = assetManager.open(listGambar.get(position)+".png");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            holder.mImage.setImageBitmap(bitmap);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
