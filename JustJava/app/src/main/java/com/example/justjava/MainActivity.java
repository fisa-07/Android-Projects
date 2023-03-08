package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=0;
    int price=0;
    int topingprice=0;
    private void displayPrice(int p){ // for displaying price
        TextView price = (TextView) findViewById(R.id.txt4);
        price.setText("Rs "+p);
    }
    private void displayQuantity(int q){ // for displaying quantity
        TextView quantity = (TextView) findViewById(R.id.txt2);
        quantity.setText(""+q);
    }
//    private void displayMessage(String message) { // display order summary
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.txt4);
//        orderSummaryTextView.setText(message);
//    }
    public void decrement(View view) { // Decremetn button
        if(quantity>0){
           quantity--;
           int temp=10*quantity;
           displayPrice(temp);
           displayQuantity(quantity);
        }
        else
            displayQuantity(quantity);
    }
    public void increment(View view) { // increment button
        quantity++;
        displayQuantity(quantity);
        int temp=10*quantity;
        displayPrice(temp);
    }
    private String getName(){ // to fetch name from name colum
        EditText editText = (EditText) findViewById(R.id.name);
        String t = editText.getText().toString();
        return t;
    }
    private String getEmail(){ // to fetch name from email colum
        EditText editText = (EditText) findViewById(R.id.email);
        String t = editText.getText().toString();
        return t;
    }
    private String createOrderSummary(boolean addWhippedCream, boolean addChocolate) { // after hitting order button this function create order summary and return as string
        String priceMessage = "Name: " + getName();
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nToppings Price: " + topingprice + " per cup";
        priceMessage += "\nTotal: Rs " + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
    public void submitOrder(View view) { // order button

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.check);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();


        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.check1);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        if(hasChocolate && hasWhippedCream){
            price=(10+5)*quantity;
            topingprice=5;
        }
        else if(hasChocolate){
            price=(10+3)*quantity;
            topingprice=3;
        }
        else if (hasWhippedCream){
            price=(10+2)*quantity;
            topingprice=2;
        }
        else{
            price=(10+0)*quantity;
            topingprice=0;
        }
        String message = createOrderSummary(hasWhippedCream, hasChocolate);
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{getEmail()}); // String array is used
        email.putExtra(Intent.EXTRA_SUBJECT, "Just Java order summary for " + getName());
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822"); // for selecting/filtering mail app
        startActivity(Intent.createChooser(email, "Select mail client :"));
        //displayMessage(message);
    }
}