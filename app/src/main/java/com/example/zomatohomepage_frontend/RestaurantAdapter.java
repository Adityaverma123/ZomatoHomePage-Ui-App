package com.example.zomatohomepage_frontend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    Context context;
    List<Restaurants> restaurants;
    public RestaurantAdapter(Context context,List<Restaurants> restaurants){
        this.restaurants=restaurants;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.restaurant_item,null,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.total_people.setText(restaurants.get(position).getTotal_people()+"+ people ordered from here since lockdown");
        holder.res_name.setText(restaurants.get(position).getRes_name());
        holder.ratings.setText(restaurants.get(position).getRatings());
        holder.one_price.setText("₹"+restaurants.get(position).getOne_price()+" for one");
        holder.imageView.setImageResource(restaurants.get(position).getImage_res());

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView one_price,ratings,res_name,food_type,total_people;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.food_image);
            one_price=itemView.findViewById(R.id.one_price);
            ratings=itemView.findViewById(R.id.ratings);
            res_name=itemView.findViewById(R.id.res_name);
            food_type=itemView.findViewById(R.id.food_type);
            total_people=itemView.findViewById(R.id.total_people);

        }
    }
}
