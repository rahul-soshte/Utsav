package com.example.hunter.utsavauditions;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Inflate the menu;this adds item to the action bar if present
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_new_person:
                //Code to run when the New Person item is clicked
                Intent intent=new Intent(this,NewPerson.class);
                startActivity(intent);
                return true;

            default:return  super.onOptionsItemSelected(item);

        }


    }



}
