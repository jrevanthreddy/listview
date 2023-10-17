package com.example.listviewtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listviewtask.adaptor.MyCustomAdaptor;
import com.example.listviewtask.model.FoodMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    ArrayList<FoodMenu> foodMenuArrayList;

    FoodMenu foodMenu, foodMenu1, foodMenu2, foodMenu3, foodMenu4, foodMenu5, foodMenu6, foodMenu7;

    private static MyCustomAdaptor myCustomAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        foodMenuArrayList = new ArrayList<>();

        foodMenu = new FoodMenu("Chicken sandwich", "chickensandwich", "₹299", R.drawable.chicken_sandwich);
        foodMenu1 = new FoodMenu("Noodels", "Noodels", "₹199", R.drawable.noodels3);
        foodMenu2 = new FoodMenu("Pasta", "Pasta", "₹399", R.drawable.pasta5 );
        foodMenu3 = new FoodMenu("Pizza", "Pizza", "₹499", R.drawable.pizza3);
        foodMenu4 = new FoodMenu("Tandoori Chicken", "Tandoori Chicken", "₹699", R.drawable.tandoorichicken4);
        foodMenu5 = new FoodMenu("Grilled Chicken","Grilled Chicken","₹499",R.drawable.grilledchicken3);
        foodMenu6 = new FoodMenu("Grilled Fish","grilled fish","₹399",R.drawable.grilledfish3);
        foodMenu7 = new FoodMenu("Mutton Biryani","Button Biryani","₹699",R.drawable.muttoncurry);


        foodMenuArrayList.add(foodMenu);
        foodMenuArrayList.add(foodMenu1);
        foodMenuArrayList.add(foodMenu2);
        foodMenuArrayList.add(foodMenu3);
        foodMenuArrayList.add(foodMenu4);
        foodMenuArrayList.add(foodMenu5);
        foodMenuArrayList.add(foodMenu6);
        foodMenuArrayList.add(foodMenu7);


        myCustomAdaptor = new MyCustomAdaptor(foodMenuArrayList,getApplicationContext());
        listView.setAdapter(myCustomAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "" + myCustomAdaptor.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}