package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.list_item);

        List<Model> _list = new ArrayList<>();

        Model item = new Model("title1");
        Model item2 = new Model("title2");
        Model item3 = new Model("title3");
        Model item4 = new Model("title4");

        _list.add(item);
        _list.add(item2);
        _list.add(item3);
        _list.add(item4);



        AdapterTest adapter = new AdapterTest(_list , this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}