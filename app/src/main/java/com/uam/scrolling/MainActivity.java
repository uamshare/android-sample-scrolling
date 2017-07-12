package com.uam.scrolling;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iforce on 7/12/2017.
 */

public class MainActivity extends AppCompatActivity {
    private ListView lvPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent i = new Intent(MainActivity.this, MyRecycleView.class);
                startActivity(i);

            }
        });

        lvPhone = (ListView)findViewById(R.id.listPhone);

        List<PhoneBook> listPhoneBook = new ArrayList<PhoneBook>();
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_user_online),
                "Srikanth Shet", "9742423365", "techneo1@gmail.com"));
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_user_offline),
                "Sridevi Vernekar", "9797979797", "sridevi@gmail.com"));
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_user_offline),
                "Srinath Shet", "9898989898", "srileo@gmail.com"));
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_user_online),
                "Srikanth A", "9742423365", "techneo1@gmail.com"));
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_user_offline),
                "Sridevi B", "9797979797", "sridevi@gmail.com"));
        listPhoneBook.add(new PhoneBook(
                BitmapFactory.decodeResource(getResources(), R.drawable.ic_user_offline),
                "Srinath C", "9898989898", "srileo@gmail.com"));
        PhoneBookAdapter adapter = new PhoneBookAdapter(this, listPhoneBook);
        lvPhone.setAdapter(adapter);
    }
}
