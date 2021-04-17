package com.example.customers;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editName, editId, editAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSubmit(View view) {
        editName  = (EditText) findViewById(R.id.editName);
        editId  = (EditText) findViewById(R.id.editId);
        editAddress  = (EditText) findViewById(R.id.editAddress);

        String nameText = editName.getText().toString();
        String idText = editId.getText().toString();
        String addressText = editAddress.getText().toString();

        String message = "No Errors!";

        if (nameText.trim().isEmpty() || idText.trim().isEmpty() || addressText.trim().isEmpty())
            message = "All fields are required!";
        else if (!nameText.matches("^[a-zA-Z]*$")) {
            message = "Only letters in the name please!";
        }
        else {
            try {
                int temp = Integer.parseInt(idText);

                if (temp < 0 || temp > 1000) {
                    message = "Enter a number between 0-1000!";
                }
            }
            catch (Exception e) {
                message = "Please enter a number for the ID!";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}