package com.uam.scrolling;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MyRecycleView extends AppCompatActivity {
    //Declare the Adapter, RecyclerView and our custom ArrayList
    RecyclerView recyclerView;
    CustomAdapter adapter;
    private ArrayList<CustomPojo> listContentArr= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyRecycleView.this, CircleView.class);
                startActivity(i);

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        //As explained in the tutorial, LineatLayoutManager tells the RecyclerView that the view
        //must be arranged in linear fashion
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new CustomAdapter(this);
        //Method call for populating the view
        populateRecyclerViewValues();
    }

    private void populateRecyclerViewValues() {
        /** This is where we pass the data to the adpater using POJO class.
         *  The for loop here is optional. I've just populated same data for 50 times.
         *  You can use a JSON object request to gather the required values and populate in the
         *  RecyclerView.
         * */
//        for(int iter=1;iter<=50;iter++) {
//            //Creating POJO class object
//            CustomPojo pojoObject = new CustomPojo();
//            //Values are binded using set method of the POJO class
//            pojoObject.setName("Hari Vigensh Jayapalan");
//            pojoObject.setContent("Hello RecyclerView! item: "+iter);
//            pojoObject.setTime("10:45PM");
//            //After setting the values, we add all the Objects to the array
//            //Hence, listConentArr is a collection of Array of POJO objects
//            listContentArr.add(pojoObject);
//        }
        listContentArr.add(new CustomPojo("02BW01803","12-01-2017","Off Highway Trucks 789C", 90));
        listContentArr.add(new CustomPojo("0B1P06084","12-02-2017","Articulated Trucks 740", (float) 85.5));
        listContentArr.add(new CustomPojo("0DFM00849","12-03-2017","Hydraulic Excavators 320D2", 70));

        //We set the array to the adapter
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }
}
