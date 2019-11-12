package com.project.coffeeshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ordercoffee extends AppCompatActivity
{

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mprices = new ArrayList<>();
    private ArrayList<String> mImageURLS = new ArrayList<>();



    RecyclerView menu;
    ImageButton viewCart;
    ArrayList<String>a;
    ArrayList<Integer>p;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordercoffee);

        //layout objects
        menu = findViewById(R.id.itemlist);
        viewCart = findViewById(R.id.viewcartbutton);

        initImageBitmaps();

        viewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i= new Intent(ordercoffee.this, cart.class);
                i.putStringArrayListExtra("index",a);
                i.putIntegerArrayListExtra("prices",p);

                startActivity(i);


            }
        });
    }



    private void initImageBitmaps()
    {
        //Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mNames.add("Caffe Mocha");
        mprices.add(250);
        mImageURLS.add("https://firebasestorage.googleapis.com/v0/b/cofee-shop.appspot.com/o/menu%2FCaffe%20Mocha.jpg?alt=media&token=1fd87827-8f9b-4433-b62d-6b33892739ec");

        mNames.add("Cappuccino");
        mprices.add(250);
        mImageURLS.add("https://firebasestorage.googleapis.com/v0/b/cofee-shop.appspot.com/o/menu%2FCappuccino.jpg?alt=media&token=1c9a3dfc-40d4-4a4c-9e67-9c91c547f4b7");

        mNames.add("Coffee");
        mprices.add(200);
        mImageURLS.add("https://firebasestorage.googleapis.com/v0/b/cofee-shop.appspot.com/o/menu%2FCoffee.jpg?alt=media&token=e58a2fd6-6c9d-4b99-b82a-7148e76add76");

        mNames.add("Espresso");
        mprices.add(240);
        mImageURLS.add("https://firebasestorage.googleapis.com/v0/b/cofee-shop.appspot.com/o/menu%2FEsspresso.jpg?alt=media&token=be212790-1823-4754-aeca-cb6818506ccb");

        mNames.add("Iced Coffee");
        mprices.add(240);
        mImageURLS.add("https://firebasestorage.googleapis.com/v0/b/cofee-shop.appspot.com/o/menu%2FIced%20Coffee.jpg?alt=media&token=fcf118ea-08c8-495f-8fbe-95a8ebbfae10");

        mNames.add("Iced Latte");
        mprices.add(300);
        mImageURLS.add("https://firebasestorage.googleapis.com/v0/b/cofee-shop.appspot.com/o/menu%2FIced%20Latte.jpg?alt=media&token=11dc7c37-e9fe-4a8c-8269-264295b42a1d");



        InitRecyclerView();

    }
    private void InitRecyclerView()
    {
        RecyclerView list = findViewById(R.id.itemlist);
        recyclerviewadaptor adapter = new recyclerviewadaptor(this, mNames,mImageURLS,mprices);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        a = adapter.getIndexarraylist();
        p = adapter.getPricearraylist();
    }
}



