package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    EditText e;
    String firstNb="";
    String secondNb="";
    boolean ZeroExist=true ;
    String op="+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=findViewById(R.id.editText);
        // Désactiver le clavier
        e.setShowSoftInputOnFocus(false);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void numberEvent(View v){
        if(ZeroExist)
            e.setText("");
        ZeroExist=false;
        String nb=e.getText().toString();
        switch(v.getId()){
            case R.id.btnZero:
                nb+="0";
                break;
            case R.id.btnOne:
                nb+="1";
                break;
            case R.id.btnTwo:
                nb+="2";
                break;
            case R.id.btnThree:
                nb+="3";
                break;
            case R.id.btnFour:
                nb+="4";
                break;
            case R.id.btnFive:
                nb+="5";
                break;
            case R.id.btnSix:
                nb+="6";
                break;
            case R.id.btnSeven:
                nb+="7";
                break;
            case R.id.btnEight:
                nb+="8";
                break;
            case R.id.btnNine:
                nb+="9";
                break;
            case R.id.btnPoint:
                nb+=".";
                break;
            case R.id.btnNot:
                nb="-"+nb;
                break;
        }
        e.setText(nb);
    }
    public void operatorEvent(View v){
        ZeroExist=true;
       firstNb=e.getText().toString();
    switch (v.getId()){
        case R.id.btnDiv:op="/";
        break;
        case R.id.btnMinus:op="-";
            break;
        case R.id.btnMul:op="*";
            break;
        case R.id.btnPlus:op="+";
            break;
    }

    }

    public void equalEvent(View v){
       secondNb=e.getText().toString();
        double res=0.0;
        switch (op){
            case "+":
                //Convertir String to Double : // parseDouble() returns a primitive double value.
                // valueOf() returns an instance of the wrapper class Double
                // res=Double.valueOf(secondNb)+Double.valueOf(firstNb);
                res=Double.parseDouble(firstNb)+Double.parseDouble(secondNb);
                break;
            case "-":
                res=Double.parseDouble(firstNb)-Double.parseDouble(secondNb);
                break;
            case "*":
                res=Double.parseDouble(firstNb)*Double.parseDouble(secondNb);
                break;
            case "/":
                res=Double.parseDouble(firstNb)/Double.parseDouble(secondNb);
                break;
        }

        e.setText(firstNb+op+secondNb+"="+res+"");
    }
    public void percentEvent(View v){
      double nb=Double.parseDouble(e.getText().toString())/100;
      e.setText(nb+"");

    }
    public void clearEvent(View v){
        e.setText(" ");
        ZeroExist=true;
    }


}