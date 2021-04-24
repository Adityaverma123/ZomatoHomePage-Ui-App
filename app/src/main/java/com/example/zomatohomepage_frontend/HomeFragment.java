package com.example.zomatohomepage_frontend;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

private CuisineAdapter cuisineAdapter;
private List<String>names;
private RecyclerView cuisine_recyclerView;
private RelativeLayout see_more,see_less;
private LinearLayout circular_view;
private List<Restaurants>restaurants;
private RecyclerView recyclerView;
private RestaurantAdapter adapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        names=new ArrayList<>();
        names.add("Cuisines");
        names.add("Rating:4.0+");
        names.add("MAX SAFETY");
        names.add("Fastest Delivery");
        names.add("Offers");
        names.add("Takeaway");
        names.add("More");
        cuisineAdapter=new CuisineAdapter(getContext(),names);
        cuisine_recyclerView=view.findViewById(R.id.cuisine_recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        cuisine_recyclerView.setLayoutManager(manager);
        cuisine_recyclerView.setAdapter(cuisineAdapter);
        see_more=view.findViewById(R.id.see_more);
        see_less=view.findViewById(R.id.see_less);
        circular_view=view.findViewById(R.id.cirular_down);
        see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circular_view.setVisibility(View.VISIBLE);
            }
        });
        see_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circular_view.setVisibility(View.GONE);
            }
        });
        recyclerView=view.findViewById(R.id.restaurants);
        restaurants=new ArrayList<>();
        restaurants.add(new Restaurants(
                "La pino'z Pizza",
                "Fast Food, Pizza",
                "4.0","150",
                "1825",
                R.drawable.food1));
        restaurants.add(new Restaurants(
                "Samosa Factory",
                "Street Food",
                "3.4","50",
                "5100",
                R.drawable.food2));
        restaurants.add(new Restaurants(
                "Madras Cafe",
                "South Indian, Fast Food",
                "4.1","100",
                "14050",
                R.drawable.food3));
        LinearLayoutManager manager1=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager1);
        adapter=new RestaurantAdapter(getContext(),restaurants);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        return view;
    }
}