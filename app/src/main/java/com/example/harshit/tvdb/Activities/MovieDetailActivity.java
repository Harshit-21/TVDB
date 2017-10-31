package com.example.harshit.tvdb.Activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harshit.tvdb.Adapters.GenreAdapter;
import com.example.harshit.tvdb.Application.MyApplication;
import com.example.harshit.tvdb.Pojo.Bean_Genre;
import com.example.harshit.tvdb.Pojo.Bean_GenreResponse;
import com.example.harshit.tvdb.Pojo.Bean_MovieDetails;
import com.example.harshit.tvdb.R;
import com.example.harshit.tvdb.Utils.AppConstant;
import com.example.harshit.tvdb.Utils.AppUtil;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener {
    Bean_MovieDetails bean_movieDetails;
    private CardView card_movieDetails;
    private RecyclerView recyler_moviesImages;
    private ImageView img_posterimage;
    private TextView tv_movietitle, tv_movierevenue, tv_movieruntime, tv_moviepopularity, tv_moviereleasedate, tv_moviestatus, tv_moviebudget, tv_movieVideos, tv_recommendedmovies, tv_moviecrew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        getDataFromBundle();
        initViews();
        setListners();
        getMovieDetails();
    }

    private void getMovieDetails() {
        if (bean_movieDetails.getId() != null) {
            if (AppUtil.isNetworkAvailable(this)) {
                MyApplication application = (MyApplication) getApplication();
                if (application != null) {
                    Call<Bean_MovieDetails> call = application.getRetrofitInstance().getMovieDetails(bean_movieDetails.getId(), AppConstant.API_KEY, AppConstant.ENG_LANGUAGE);
                    call.enqueue(new Callback<Bean_MovieDetails>() {
                        @Override
                        public void onResponse(@NonNull Call<Bean_MovieDetails> call, @NonNull Response<Bean_MovieDetails> response) {

                            if (!response.message().isEmpty()) {
                                Bean_MovieDetails bean_movieDetails = response.body();
                                handleMovieDetailData(bean_movieDetails);
                            }
                        }

                        @Override
                        public void onFailure(Call<Bean_MovieDetails> call, Throwable t) {
                            // Log error here since request failed
                            Log.e("ERROR", t.toString());
                            AppUtil.openNonInternetActivity(MovieDetailActivity.this, getResources().getString(R.string.something_went_wrong));
                            finish();
                        }
                    });


                }
            } else {
                AppUtil.openNonInternetActivity(this, getResources().getString(R.string.no_internet));
                finish();
            }
        }
    }

    private void handleMovieDetailData(Bean_MovieDetails bean_movieDetails) {
        if (bean_movieDetails != null) {
            tv_movietitle.setText(bean_movieDetails.getTitle() != null ? bean_movieDetails.getTitle() : "");
            tv_moviepopularity.setText(String.valueOf(bean_movieDetails.getPopularity() != null ? bean_movieDetails.getPopularity() : ""));
            tv_moviereleasedate.setText(!TextUtils.isEmpty(bean_movieDetails.getReleaseDate()) ? bean_movieDetails.getReleaseDate() : "");
            tv_moviestatus.setText(!TextUtils.isEmpty(bean_movieDetails.getStatus()) ? bean_movieDetails.getStatus() : "");
            tv_moviebudget.setText(String.valueOf(bean_movieDetails.getBudget()));
            tv_movierevenue.setText(String.valueOf(bean_movieDetails.getRevenue()));
            tv_movieruntime.setText(String.valueOf(bean_movieDetails.getRuntime()));
        } else {
            AppUtil.openNonInternetActivity(this, getResources().getString(R.string.something_went_wrong));
            finish();
        }
    }

    private void setListners() {
        tv_movieVideos.setOnClickListener(this);
        tv_recommendedmovies.setOnClickListener(this);
        tv_moviecrew.setOnClickListener(this);
    }

    private void initViews() {
        tv_movietitle = (TextView) findViewById(R.id.tv_movietitle);
        tv_moviepopularity = (TextView) findViewById(R.id.tv_moviepopularity);
        tv_moviereleasedate = (TextView) findViewById(R.id.tv_moviereleasedate);
        tv_moviestatus = (TextView) findViewById(R.id.tv_moviestatus);
        tv_moviebudget = (TextView) findViewById(R.id.tv_moviebudget);
        tv_movieVideos = (TextView) findViewById(R.id.tv_movieVideos);
        tv_recommendedmovies = (TextView) findViewById(R.id.tv_recommendedmovies);
        tv_moviecrew = (TextView) findViewById(R.id.tv_moviecrew);
        tv_movierevenue = (TextView) findViewById(R.id.tv_movierevenue);
        tv_movieruntime = (TextView) findViewById(R.id.tv_movieruntime);
        img_posterimage = (ImageView) findViewById(R.id.img_posterimage);
        recyler_moviesImages = (RecyclerView) findViewById(R.id.recyler_moviesImages);
        card_movieDetails = (CardView) findViewById(R.id.card_movieDetails);
    }

    private void getDataFromBundle() {
        bean_movieDetails = (Bean_MovieDetails) getIntent().getSerializableExtra("MOVIE_DETAILS");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_movieVideos:

            case R.id.tv_recommendedmovies:
            case R.id.tv_moviecrew:


        }
    }
}
