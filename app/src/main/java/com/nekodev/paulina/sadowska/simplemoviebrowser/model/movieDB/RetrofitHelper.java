package com.nekodev.paulina.sadowska.simplemoviebrowser.model.movieDB;

import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Paulina Sadowska on 26.03.2017.
 */

public class RetrofitHelper {

    private OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new ParamsInterceptor())
                .build();
    }

    public MovieApi movieApi() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieApi.ENDPOINT)
                .client(okHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(MovieApi.class);
    }
}
