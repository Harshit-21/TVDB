package com.example.harshit.tvdb.Interfaces;

import com.example.harshit.tvdb.Pojo.Bean_Genre;
import com.example.harshit.tvdb.Pojo.Bean_GenreResponse;
import com.example.harshit.tvdb.Pojo.Bean_MovieDetails;
import com.example.harshit.tvdb.Pojo.Bean_MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Harshit on 9/16/2017.
 */

public interface ApiInterface {
    //************************this is for getting the genre of the movie********************************
    @GET("genre/movie/list")
    Call<Bean_GenreResponse> getGenreList(@Query("api_key") String apiKey);

    //************************this is for getting the list of movies according to the genre********************************
    @GET("genre/{genre_id}/movies")
    Call<Bean_MovieResponse> getMovieAccToGenre(@Path("genre_id") String genre_id, @Query("api_key") String apiKey, @Query("language") String language, @Query("include_adult") boolean is_adult, @Query("sort_by") String order);

    //************************this is for getting to get movie details ********************************
    @GET("movie/{movie_id}")
    Call<Bean_MovieDetails> getMovieDetails(@Path("movie_id") int movie_id, @Query("api_key") String apiKey, @Query("language") String language);

    //            ******************this method is used to get alternative titles of the movie n all stuff********
    @GET("movie/{movie_id}/alternative_titles")
    Call<Bean_MovieResponse> getAlternativeTitles(@Path("movie_id") String movie_id, @Query("api_key") String apiKey);

    //            ********************get credit of the movie ********************************
    @GET("movie/{movie_id}/credits")
    Call<Bean_MovieResponse> getCredits(@Path("movie_id") String movie_id, @Query("api_key") String apiKey);

    //*************************to get images of the movie ********************
    @GET("movie/{movie_id}/images")
    Call<Bean_MovieResponse> getMovieImages(@Path("movie_id") String movie_id, @Query("api_key") String apiKey, @Query("language") String language);

    //            *********************to get the release date of the movie in diffrent country--------
    @GET("movie/{movie_id}/release_dates")
    Call<Bean_MovieResponse> getReleaseDates(@Path("movie_id") String movie_id, @Query("api_key") String apiKey);

    //            *******************to get the videos link to play on youtube**************
    @GET("movie/{movie_id}/videos")
    Call<Bean_MovieResponse> getVideos(@Path("movie_id") String movie_id, @Query("api_key") String apiKey, @Query("language") String language);


//    **********to get the transalations means to get the iso n all stuff********************

    @GET("movie/{movie_id}/translations")
    Call<Bean_MovieResponse> getDiffrentRegionsInfoOfMovie(@Path("movie_id") String movie_id, @Query("api_key") String apiKey);


    //          --------------------to get the recommended movies************************
    @GET("movie/{movie_id}/recommendations")
    Call<Bean_MovieResponse> getDiffrentRegionsInfoOfMovie(@Path("movie_id") String movie_id, @Query("api_key") String apiKey, @Query("language") String language);

    //            **********************to get the latest movies***************
    @GET("movie/latest")
    Call<Bean_MovieResponse> getLatestMovies(@Query("api_key") String apiKey, @Query("language") String language);

    //            **********************to get the now_playing movies***************

    @GET("movie/now_playing")
    Call<Bean_MovieResponse> getNowPlayingMovies(@Query("api_key") String apiKey, @Query("language") String language);

    //            **********************to get the popular movies***************

    @GET("movie/popular")
    Call<Bean_MovieResponse> getPopularMovies(@Query("api_key") String apiKey, @Query("language") String language);

    //            **********************to get the top_rated movies***************

    @GET("movie/top_rated")
    Call<Bean_MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey, @Query("language") String language);

    //            **********************to get the upcoming movies***************

    @GET("movie/upcoming")
    Call<Bean_MovieResponse> getupComingMovies(@Query("api_key") String apiKey, @Query("language") String language);


}
