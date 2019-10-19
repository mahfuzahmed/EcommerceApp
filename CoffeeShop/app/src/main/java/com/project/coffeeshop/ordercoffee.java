package com.project.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ordercoffee extends AppCompatActivity
{
    /*RecyclerView itemslist;
    ImageButton cart;
    String item_name_from_db;
    String format;
    FirebaseDatabase db;
    DatabaseReference myref;*/


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        /*//database
        db = FirebaseDatabase.getInstance();
        myref = db.getReference();

        //layout objects
        itemslist = findViewById(R.id.itemlist);
        cart = findViewById(R.id.viewcart_button);



        //set item name from database(incomplete)
        item_name_from_db = "Pizza";
        format = getString(R.string.addtocartitemname, item_name_from_db);*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordercoffee);


    }
}
