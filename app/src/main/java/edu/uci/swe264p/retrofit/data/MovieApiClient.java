package edu.uci.swe264p.retrofit.data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The essence of the enum keyword:
 *
 * <pre><code>
 * public abstract class Enum
 * extends Object
 * implements Comparable <E extends Enum <E>>, Serializable
 * </code></pre>
 * <p>
 * Classes cannot directly extend 'java.lang.Enum' <br/>
 * ❌ public class MovieApiClient extends Enum<MovieApiClient> <br/>
 * ✔ public enum MovieApiClient <br/>
 */

//public enum MovieApiClient {
//    INSTANCE;
//}

public class MovieApiClient {

    private MovieApiClient() {
    }

    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    private static final String API_KEY = "ba8f1d4d4a7153ec4d56cff72c5a37aa";

    private static final MovieApiService SERVICE =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(MovieApiService.class);

    public static Call<Movie> getMovie(int id) {
        return SERVICE.getMovie(id, API_KEY);
    }

    public static Call<MovieList> getMovieList() {
        return SERVICE.getMovieList(API_KEY);
    }
}
