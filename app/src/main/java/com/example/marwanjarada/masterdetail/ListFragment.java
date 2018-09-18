package com.example.marwanjarada.masterdetail;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    RecyclerView mRecyclerView;
    ItemClickListener mCallBack;

    ArrayList<Item> category = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_list,container,false);
        RecyclerView listView = rootView.findViewById(R.id.listView_items);
        final ArrayList<Item> items = Item.getAllItems();

        RecyclerView.LayoutManager layoutManager=
                new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);

        listView.setLayoutManager(layoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(getContext(), items, new RecyclerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getContext(),DetailActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), "Item clicked", Toast.LENGTH_LONG).show();
            }
        });

        listView.setAdapter(adapter);



        return rootView;
    }



    public interface ItemClickListener{
        public void onItemClicked(Item item);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallBack = (ItemClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }



}
