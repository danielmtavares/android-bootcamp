package com.example.dtavares.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends Activity {
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        EditText etItem = (EditText) findViewById(R.id.edText);
        String itemText = getIntent().getStringExtra("itemText");
        etItem.setText(itemText);

        pos = getIntent().getIntExtra("pos", Integer.MAX_VALUE);
    }

    public void onSubmit(View v) {
        EditText etItem = (EditText) findViewById(R.id.edText);
        Intent data = new Intent();
        data.putExtra("itemText", etItem.getText().toString());
        data.putExtra("pos", pos);
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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
}