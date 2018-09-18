
package com.example.marwanjarada.masterdetail;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


        return viewHolder;
    }

    public interface CustomItemClickListener {
        void onItemClick(View v, int position);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        Item item = mItem.get(position);
        holder.textView_title.setText(item.getTitle());
        mCallback.onItemClick(rootView, position);

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView textView_title;

        public ViewHolder(View rootView) {

            super(rootView);

            textView_title=rootView.findViewById(R.id.textView_item);

        }


    }
}

