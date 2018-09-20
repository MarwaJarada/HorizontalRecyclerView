package com.example.marwanjarada.masterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import static java.security.AccessController.getContext;

public class ListActivity extends AppCompatActivity implements com.example.marwanjarada.masterdetail.ListFragment.ItemClickListener {

    Boolean isTablet = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acttivity_list);


        if(findViewById(R.id.container_layout) !=null){
            isTablet= true;
        }else {
            isTablet = false;

        }

    }

    @Override
    public void onItemClicked(Item item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", item.getTitle());
        startActivity(intent);
    }
    }
