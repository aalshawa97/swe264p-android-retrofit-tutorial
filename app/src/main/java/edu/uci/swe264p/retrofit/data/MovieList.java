package edu.uci.swe264p.retrofit.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList {

    //page	1
    //total_results	6885
    //total_pages	345
    //results

    @SerializedName("results")
    private List<Movie> movieList;

    public MovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

}
