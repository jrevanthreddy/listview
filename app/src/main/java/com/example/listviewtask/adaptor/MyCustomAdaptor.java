package com.example.listviewtask.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewtask.R;
import com.example.listviewtask.model.FoodMenu;

import java.util.ArrayList;

public class MyCustomAdaptor extends ArrayAdapter<FoodMenu> {

    ArrayList<FoodMenu> foodMenuArrayList;
    Context context;

    public MyCustomAdaptor(ArrayList<FoodMenu> foodMenuArrayList, Context context) {
        super(context, R.layout.image_list,foodMenuArrayList);
        this.foodMenuArrayList = foodMenuArrayList;
    }
    private static class ViewHolder {
        TextView name, price, description;
        ImageView imageView;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        FoodMenu foodMenu = getItem(position);
        ViewHolder  foodViewHolder;
        final View result;

        if (convertView == null){
            foodViewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.image_list,parent,false);

            foodViewHolder.name = (TextView) convertView.findViewById(R.id.name);
            foodViewHolder.price = (TextView) convertView.findViewById(R.id.price);
            foodViewHolder.description = (TextView) convertView.findViewById(R.id.description);
            foodViewHolder.imageView = (ImageView) convertView.findViewById(R.id.imagename);

            result = convertView;

            convertView.setTag(foodViewHolder);
        }else {
            foodViewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        foodViewHolder.name.setText(foodMenu.getName());
        foodViewHolder.price.setText(foodMenu.getPrice());
        foodViewHolder.description.setText(foodMenu.getDescription());
        foodViewHolder.imageView.setImageResource(foodMenu.getImage());

        return convertView;
    }
}
