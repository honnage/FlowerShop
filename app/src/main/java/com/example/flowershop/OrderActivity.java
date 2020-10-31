package com.example.flowershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
    TextView tvOrder;
    Spinner spPhoneType;
    String str;
    Toolbar tbMenuBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvOrder = findViewById(R.id.idTvOrder);

        tbMenuBar = findViewById(R.id.idTbMenuBarOrder);
        setSupportActionBar(tbMenuBar);

        Intent i =getIntent();
//        String str = "Order: " + i.getStringExtra("ORDER");
        String str = "Order: " + i.getStringExtra(MainActivity.ORDER_KEY);
        tvOrder.setText(str);

        spPhoneType = findViewById(R.id.idSpPhoneType);
        spPhoneType.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(
                this, R.array.phone_type_array,
                android.R.layout.simple_spinner_dropdown_item);

        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPhoneType.setAdapter(a);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.order_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
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

    public void selectDelivery(View v){
        int id = v.getId();
        switch ((id)){
            case R.id.idRbSameDay:
                Toast.makeText(this,"You select Same Day Delivery.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idRbNextDay:
                Toast.makeText(this,"You select Next Day Delivery.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idRbPickUp:
                Toast.makeText(this,"You select Pickup by yourself.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void selectAge(View v){
        int id = v.getId();
        switch ((id)){
            case R.id.idRbAgel1:
                Toast.makeText(this,"You select Age Not more than 8.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idRbAgel2:
                Toast.makeText(this,"You select Age between 8 - 40.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idRbAgel3:
                Toast.makeText(this,"You select Age over 40.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        str = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void showDialog(View v){
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("คุณต้องการเคลียร์ข้อมูลทิ้งใช้หรือไหม");
        adb.setMessage("ถ้าหากกดปุ่ม OK จะทำการเคลียร์ข้อมูลทิ้ง");
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"You pressed OK",Toast.LENGTH_SHORT).show();

            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"You pressed CANCEL",Toast.LENGTH_SHORT).show();
            }
        });
        adb.show();

    }

    public void ChooseDate(View v){
        DialogFragment df = new DatePickerFragment();
        df.show(getSupportFragmentManager(),"DATE_PICKER");
    }

    public void ChooseTime(View v){
        DialogFragment tf = new TimePickerFragment();
        tf.show(getSupportFragmentManager(),"TIME_PICKER");
    }

    public void showDate(int y, int m, int d){
        String str;
        str = "Selected Date:" + d +"/" + m + "/" +y;
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    public void showTime(int h, int m){
        String str;
        str = "Selected Time:" + h +":" + m ;
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

}