package com.mrcoder.retrofitexample.retrofit;

import com.mrcoder.retrofitexample.model.Country;
import com.mrcoder.retrofitexample.model.Hero;
import com.mrcoder.retrofitexample.model.RegionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://simplifiedcoding.net/demos/";
    String COUNTRY_URL = "https://restcountries.eu/rest/v2/";


    @GET("marvel")
    Call<List<Hero>> getHeroes();

    @GET("all?fields=region")
    Call<List<RegionModel>> getRegions();

    @GET("region/asia")
    Call<List<Country>> getCountry();
}

