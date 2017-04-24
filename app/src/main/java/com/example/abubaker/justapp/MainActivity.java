package com.example.abubaker.justapp;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox ch;
    int quantity =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increment(View view)
    {
        quantity = quantity+1;
        display(quantity);

    }



    public void decrement(View view)
    {
        quantity= quantity-1;
        display(quantity);
    }

    public void submitOrder(View view)
    {
          EditText getName  = (EditText) findViewById(R.id.nameField);
          String name = getName.getText().toString();
          CheckBox whipedCream = (CheckBox) findViewById(R.id.whipedCreams);
          Boolean isCheckedWhipedCream = whipedCream.isChecked();
          CheckBox choclate = (CheckBox) findViewById(R.id.choclate);
          Boolean isCheckedChoclate = choclate.isChecked();
          TextView getQuantity = (TextView) findViewById(R.id.quantity);
          String totalQuantity = getQuantity.getText().toString();
          int coffeeOfPrice = 5 * quantity;
        if(isCheckedWhipedCream)
        {
            coffeeOfPrice = coffeeOfPrice + (quantity * 3);
        }

        if(isCheckedChoclate)
        {
            coffeeOfPrice = coffeeOfPrice +(quantity*2);
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] t0 = {"abubakerorakzai1@gmail.com","coffeshop123@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL ,t0);
        intent.putExtra(Intent.EXTRA_SUBJECT , "this is abu baker");

      String message = displayFinalResult(name , isCheckedWhipedCream , isCheckedChoclate , totalQuantity , coffeeOfPrice);

        intent.putExtra(Intent.EXTRA_TEXT , message);
        intent.setType("message/rfc822");
        startActivity(intent);

    }

    private String displayFinalResult(String name , boolean isCheckedWhipedCream , boolean isChekedChoclate , String quantity , int coffeePrice) {

        TextView finalResult = (TextView) findViewById(R.id.finalResult);

        String s ="name "+name+"\nWhipedCream "+isCheckedWhipedCream+"\nChoclate "
                +isChekedChoclate+"\nQuantity "+quantity+"\nCoffee Price "+coffeePrice;

        finalResult.setText("name "+name+"\nWhipedCream "+isCheckedWhipedCream+"\nChoclate "
                +isChekedChoclate+"\nQuantity "+quantity+"\nCoffee Price "+coffeePrice);
        return s;

    }


    private int calculatePrice(int qua) {

        int p = qua *5;

        return p;
    }

    private void displayMessage(String message) {

        TextView p = (TextView) findViewById(R.id.finalResult);
        p.setText(""+message);
    }

    private void display(int i) {

        TextView t  = (TextView)findViewById(R.id.quantity);
        t.setText(""+i);
    }

    public  void displayPrice(int  price)
    {
        TextView pricet = (TextView)findViewById(R.id.finalResult);

        pricet.setText("$"+price);

    }


    public void isChecked(View view)
    {

    }

}
