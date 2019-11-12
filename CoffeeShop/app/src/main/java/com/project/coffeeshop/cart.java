package com.project.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cart extends AppCompatActivity
{
    TextView details;
    TextView price;
    TextView total;
    Button ordernow;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        details = findViewById(R.id.reciept);
        price = findViewById(R.id.totalMedPrice);
        total = findViewById(R.id.total);
        ordernow = findViewById(R.id.orderNowButton);

        ArrayList<String> newIndex = new ArrayList<>();
        ArrayList<Integer> newPrice = new ArrayList<>();


        Bundle extras = getIntent().getExtras();

        if (savedInstanceState == null)
        {

            if(extras == null)
            {
                newIndex= null;
            }
            else
            {
                newIndex = extras.getStringArrayList("index");
                newPrice = extras.getIntegerArrayList("prices");

            }
        }
        else
        {
            newIndex = extras.getStringArrayList("index");
            newPrice = extras.getIntegerArrayList("prices");
        }

        Integer sum = 0;

        for(int i = 0; i < newPrice.size(); i++)
        {
            sum = sum + newPrice.get(i);
        }




        StringBuilder sb = new StringBuilder();

        for(String s : newIndex)
        {

            sb.append(s);
            sb.append("\n");
        }

        details.setText(sb);
        price.setText(sum.toString());

        Integer t = sum+25;

        total.setText(t.toString());


        ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(cart.this,"Your Order Has been Placed",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
