package com.example.zomatohomepage_frontend;

public class Restaurants {
    private String res_name,food_type,ratings,one_price,total_people;
    private int image_res;

    public String getRes_name() {
        return res_name;
    }

    public String getFood_type() {
        return food_type;
    }

    public String getRatings() {
        return ratings;
    }

    public String getOne_price() {
        return one_price;
    }

    public String getTotal_people() {
        return total_people;
    }

    public int getImage_res() {
        return image_res;
    }

    public Restaurants(String res_name, String food_type, String ratings, String one_price, String total_people, int image_res) {
        this.res_name = res_name;
        this.food_type = food_type;
        this.ratings = ratings;
        this.one_price = one_price;
        this.total_people = total_people;
        this.image_res = image_res;
    }
}
