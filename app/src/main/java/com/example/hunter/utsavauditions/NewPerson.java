package com.example.hunter.utsavauditions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewPerson extends Activity implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextClass;
    private EditText editTextFSSS;
    private EditText editTextPhoneNo;
    private EditText editTextAudComp;
    private Button btnAdd;
   private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person);


        editTextName = (EditText) findViewById(R.id.editTextName);
       editTextClass=(EditText)findViewById(R.id.editTextClass);
        editTextFSSS=(EditText)findViewById(R.id.editTextFSSS);
        editTextPhoneNo=(EditText)findViewById(R.id.editTextPhoneNo);
        editTextAudComp=(EditText)findViewById(R.id.editTextAudComp);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        createDatabase();
    }
    protected void createDatabase(){
        db=openOrCreateDatabase("PersonDB1", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS persons2(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR,Class VARCHAR,Shift VARCHAR,PhoneNo VARCHAR,AudComp VARCHAR);");

    }
    protected void insertIntoDB(){
        String name = editTextName.getText().toString().trim();
        String Class = editTextClass.getText().toString().trim();
        String  Shift= editTextFSSS.getText().toString().trim();
        String PhoneNo=editTextPhoneNo.getText().toString().trim();
        String AudComp=editTextAudComp.getText().toString().trim();


        if(name.equals("") || Class.equals("") || Shift.equals("") || PhoneNo.equals("") || AudComp.equals("")){
            Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }

        String query = "INSERT INTO persons2 (name,Class,Shift,PhoneNo,AudComp) VALUES('"+name+"', '"+Class+"','"+Shift+"','"+PhoneNo+"','"+AudComp+"');";
        db.execSQL(query);
        Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Inflate the menu;this adds item to the action bar if present
        getMenuInflater().inflate(R.menu.menu_main1,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings: {
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void onClick(View v)
    {
        if(v==btnAdd)
        {
            insertIntoDB();
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);

        }
    }

}

