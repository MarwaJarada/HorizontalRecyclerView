package com.example.marwanjarada.masterdetail;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Item {

        private ImageView image;
        private String title;


    public Item(String title) {
        this.title = title;
    }

        public Item(String title , ImageView image) {
            this.title = title;
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public ImageView getImage() {
            return image;
        }

        public void setImage(ImageView image) {
            this.image = image;
        }

        public static ArrayList<Item> getAllItems(){
        ArrayList<Item>items = new ArrayList<>();
            for (int x =0 ; x<10 ; x++){
                Item item = new Item("title "+x);
                items.add(item);

            }
            return items;
        }

    //        public static List<Item> generateDummyContent() {
//            List<Item> items = new ArrayList<>();
//            for (int i = 1; i <= 20; i++) {
//                items.add(new Item("Title #" + i, i + ": Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//            }
//            return items;
//        }

    }

