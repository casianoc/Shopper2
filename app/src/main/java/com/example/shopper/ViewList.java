package com.example.shopper;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ViewList extends AppCompatActivity {

    Intent intent;

    // fields used to get shopping list id passed from Main Activity
    long id;
    Bundle bundle;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get the id
        bundle = this.getIntent().getExtras();
        id = bundle.getLong("_id");

        dbHandler = new DBHandler(this, null);

        // call database method that returs shopping list name
        String shoppingListName = dbHandler.getShoppingListName((int) id);

        // set title of this activity to the shopping list name
        this.setTitle(shoppingListName);
    }


    /**
     * This method further initializes the Action Bar of
     * the Main Activity. It gets tge code we wrote in the
     * menu main and incorporates it into the Action Bar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_list, menu);
        return true;
    }

    public void openAddItem(View view) {
    }
}
