package com.example.flowershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String strOrder;
    FloatingActionButton fbShopping;
    Toolbar tbMenuBar;

    public static final String ORDER_KEY = "ORDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbMenuBar = findViewById(R.id.idTbMenuBar);
        setSupportActionBar(tbMenuBar);
                
        strOrder = getString(R.string.no_order);
        fbShopping = findViewById(R.id.idFbShoppingCart);
        fbShopping.setEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.idMenuOrder:
                Intent i = new Intent(this,OrderActivity.class);
                //i.putExtra("ORDER",strOrder);
                i.putExtra(ORDER_KEY,strOrder);
                startActivity(i);
                //Toast.makeText(this,"You select menu Order.",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idMenuStatus:
                Toast.makeText(this,"You select menu Status.",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idMenuFavorites:
                Toast.makeText(this,"You select menu Favorites.",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idMenuContact:
                Toast.makeText(this,"You select menu Contact.",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void orderWhiteFlower(View v){
        //strOrder = "You ordered White Flower";
        strOrder = getString(R.string.order_WhiteFlower);
        fbShopping.setEnabled(true);
        Toast.makeText(this,strOrder,Toast.LENGTH_LONG).show();
    }

    public void orderOrangeFlower(View v){
        //strOrder = "You ordered Orange Flower";
        strOrder = getString(R.string.order_OrangeFlower);
        fbShopping.setEnabled(true);
        Toast.makeText(this,strOrder,Toast.LENGTH_LONG).show();
    }

    public void orderYellowFlower(View v){
        //strOrder = "You ordered Yellow Flower";
        strOrder = getString(R.string.order_YellowFlower);
        fbShopping.setEnabled(true);
        Toast.makeText(this,strOrder,Toast.LENGTH_LONG).show();
    }

    public void order(View v){
        Intent i = new Intent(this,OrderActivity.class);
//        i.putExtra("ORDER",strOrder);
        i.putExtra(ORDER_KEY,strOrder);

        startActivity(i);
    }


}