
package com.example.marwanjarada.masterdetail;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marwanjarada.masterdetail.Item;
import com.example.marwanjarada.masterdetail.R;


import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    CustomItemClickListener mCallback;
    Context mContext;
    View rootView;
    private List<Item> mItem;
    int positionItem;

    public RecyclerAdapter(Context mContext, ArrayList<Item> items, CustomItemClickListener listener) {
        this.mItem = items;
        this.mContext = mContext;
        mCallback = listener;
    }


    public RecyclerAdapter(List<Item> item) {
        mItem = item;
    }



    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        rootView = inflater.inflate(R.layout.item_row, parent, false);

        final ViewHolder viewHolder = new ViewHolder(rootView);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int poo = positionItem;
                Toast.makeText(mContext,""+poo,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(mContext,DetailActivity.class);
                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }



    public interface CustomItemClickListener {
        void onItemClick(Item item);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        positionItem=position;
        Item item = mItem.get(position);
        holder.textView_title.setText(item.getTitle());
        mCallback.onItemClick(item);

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView textView_title;
       // ImageView imageView_categoryid;

        public ViewHolder(View rootView) {

            super(rootView);

            textView_title=rootView.findViewById(R.id.textView_item);
        //    imageView_categoryid = rootView.findViewById(R.id.imageView_item);

        }


    }



    public ArrayList<Item> getCategoryItems(){
        ArrayList<Item> categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Cooking"));
        categoryItems.add(new Item("Computer"));
        categoryItems.add(new Item("Software"));
        return  categoryItems;
    }

}

