package com.project.coffeeshop;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerviewadaptor extends RecyclerView.Adapter<recyclerviewadaptor.ViewHolder>{

    private static final String TAG = "recyclerviewadaptor";


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView carditemimage;
        TextView carditemname;
        Button cardadditembutton;
        RelativeLayout cardlistitem;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            carditemimage = itemView.findViewById(R.id.carditemimage);
            carditemname = itemView.findViewById(R.id.carditemname);
            cardadditembutton = itemView.findViewById(R.id.additemtocartbutton);
            cardlistitem = itemView.findViewById(R.id.cardlayout);


        }
    }
}
