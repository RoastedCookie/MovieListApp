package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

   Context context;
   private ArrayList<Movie> list;

    public MovieAdapter(Context context, ArrayList<Movie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.title.setText(movie.getTitle());
        holder.ratings.setText(String.valueOf(movie.getRatings()));
        holder.description.setText(movie.getDescription());
        Glide.with(context).load(movie.getPoster()).into(holder.posterImg);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);

                intent.putExtra("title", movie.getTitle());
                intent.putExtra("ratings", movie.getRatings());
                intent.putExtra("desc", movie.getDescription());
                intent.putExtra("poster", movie.getPoster());


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView posterImg;
        TextView title;
        TextView ratings;
        TextView description;
        RelativeLayout relativeLayout;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImg = itemView.findViewById(R.id.moviePoster);
            title = itemView.findViewById(R.id.movieTitle);
            ratings = itemView.findViewById(R.id.rating);
            description = itemView.findViewById(R.id.descriptionMovie);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}
