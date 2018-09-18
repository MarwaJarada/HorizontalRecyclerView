package com.example.marwanjarada.masterdetail;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

        List<Item> mItems;

        public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> items) {
            super(context, resource, items);
            mItems = items;
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Get the data item for this position
            Item item = mItems.get(position);

            // View lookup cache stored in tag
            ViewHolder viewHolder;

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {

                // If there's no view to re-use, inflate a brand new view for row
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                convertView = inflater.inflate(R.layout.item_row, parent, false);

                viewHolder = new ViewHolder(convertView);

                // Cache the viewHolder object inside the fresh view
                convertView.setTag(viewHolder);

            } else {
                // View is being recycled, retrieve the viewHolder object from tag
                viewHolder = (ViewHolder) convertView.getTag();
            }

            // Populate the data from the data object via the viewHolder object into the template view
            viewHolder.textViewTitle.setText(item.getTitle());

            // Return the completed view to render on screen
            return convertView;
        }

        // Returns the total count of items in the list
        @Override
        public int getCount() {
            return mItems.size();
        }

        // Provide a direct reference to each of the views within a data item
        // Used to cache the views within the item layout for fast access
        public class ViewHolder {

            // Your holder should contain a member variable
            // for any view that will be set as you render a row
            TextView textViewTitle;
            ImageView imageViewImage;

            // We also create a constructor that accepts the entire item row
            // and does the view lookups to find each subview
            public ViewHolder(View rootView) {
                textViewTitle = rootView.findViewById(R.id.textView_item);
            }

        }


}

