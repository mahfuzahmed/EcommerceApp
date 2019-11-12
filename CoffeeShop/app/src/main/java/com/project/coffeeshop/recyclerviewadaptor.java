package com.project.coffeeshop;


import android.app.AlertDialog;
import android.content.Context;

import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


//glide
import com.bumptech.glide.Glide;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerviewadaptor extends RecyclerView.Adapter<recyclerviewadaptor.ViewHolder>
{

    private static final String TAG = "recyclerviewadaptor";

    public ArrayList<String> mImagenames;
    public ArrayList<Integer>mItemprices;
    private ArrayList<String> mImages;


    public ArrayList<String> nameindexes;
    public ArrayList<Integer>itemprices;

    private Context mContext;

    public recyclerviewadaptor(Context mContext, ArrayList<String> mImagenames, ArrayList<String> mImages,ArrayList<Integer> mprices)
    {
        this.mImagenames = mImagenames;
        this.mImages = mImages;
        this.mItemprices = mprices;
        this.mContext = mContext;

        nameindexes = new ArrayList<String>();
        itemprices = new ArrayList<Integer>();
    }
    public ArrayList<String> getIndexarraylist()
    {
        return nameindexes;
    }
    public ArrayList<Integer> getPricearraylist()
    {
        return itemprices;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position)
    {
        Log.d(TAG,"onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.carditemimage);

        holder.carditemname.setText(mImagenames.get(position));


        holder.cardLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d(TAG, "onClick: clicked on"+mImagenames.get(position));
                Toast.makeText(mContext, mImagenames.get(position), Toast.LENGTH_SHORT).show();


                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                builder.setTitle("CART");

                builder.setTitle("Do you want to add item to cart?");

                builder.setCancelable(true);

                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        nameindexes.add(mImagenames.get(position));
                        itemprices.add(mItemprices.get(position));
                    }
                });

                builder.setNegativeButton("DISMISS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }
                });

                AlertDialog alertdialog = builder.create();
                alertdialog.show();
            }


        });


    }

    @Override
    public int getItemCount()
    {
        return mImagenames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView carditemimage;
        TextView carditemname;
        TextView itemprice;
        EditText quantity;
        RelativeLayout cardLayout;


        public ViewHolder(final View itemView)
        {
            super(itemView);



            quantity = itemView.findViewById(R.id.setquantity);
            carditemimage = itemView.findViewById(R.id.carditemimage);
            carditemname = itemView.findViewById(R.id.carditemname);
            cardLayout = itemView.findViewById(R.id.finalcartcardlayout);
            itemprice = itemView.findViewById(R.id.itemprice);


        }
    }


}
