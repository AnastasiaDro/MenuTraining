package com.mymur.menutraining;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //массив строе
    ArrayList <String> stringsArray;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stringsArray = new ArrayList<>();
        stringsArray.add("ааа");
        stringsArray.add("ббб");
        stringsArray.add("ввв");
        stringsArray.add("ггг");
        stringsArray.add("ддд");
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecycler);
        myAdapter = new MyAdapter(stringsArray);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 111:
                myAdapter.removeItem(item.getGroupId());
                displayMessage("item deleted");
                return true;
            case 222:
                displayMessage("item added to your alphabet");
                return true;
            default:
                return  super.onContextItemSelected(item);
        }


    }

    private void displayMessage(String message) {
        Snackbar.make(findViewById(R.id.rootView), message, Snackbar.LENGTH_LONG).show();
    }




}
