package com.example.movieapp;

public class Movie {
    private String title, poster, description;
    private double ratings;

    public Movie(String title, String poster, String description, double ratings) {
        this.title = title;
        this.poster = poster;
        this.description = description;
        this.ratings = ratings;
    }

    public String getTitle() {
        return title;
    }



    public String getPoster() {
        return poster;
    }



    public String getDescription() {
        return description;
    }


    public double getRatings() {
        return ratings;
    }


}
