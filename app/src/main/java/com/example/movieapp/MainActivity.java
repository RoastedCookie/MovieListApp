package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieArrayList = new ArrayList<>();

        requestQueue = MySingleton.getInstance(this).getRequestQueue();
        fetchData();
    }

//    private void fetchData() {
//        String url = "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=1cf50e6248dc270629e802686245c2c8";
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONArray jsonArray = response.getJSONArray("results");
//                            JSONObject details = jsonArray.getJSONObject(i);
//                            String title = details.getString("original_title");
//                            String overView = details.getString("overview");
//                            int ratings = details.getInt("vote_average");
//                            String posterImg = details.getString("poster_path");
//
//                            Movie movie = new Movie(title, posterImg, overView, ratings);
//                            movieArrayList.add(movie);
//
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                    MovieAdapter adapter = new MovieAdapter(MainActivity.this, movieArrayList);
//                    recyclerView.setAdapter(adapter);
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//        requestQueue.add(jsonObjectRequest);
//    }
//}

    private void fetchData() {
        String url = "https://www.json-generator.com/api/json/get/crbeYBTWCq?indent=2";
//        String url = "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=1cf50e6248dc270629e802686245c2c8";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        String title = object.getString("title");
                        String overView = object.getString("overview");
                        double ratings = object.getDouble("rating");
                        String posterImg = object.getString("poster");

                        Movie movie = new Movie(title, posterImg, overView, ratings);
                        movieArrayList.add(movie);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    MovieAdapter adapter = new MovieAdapter(MainActivity.this, movieArrayList);
                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}

