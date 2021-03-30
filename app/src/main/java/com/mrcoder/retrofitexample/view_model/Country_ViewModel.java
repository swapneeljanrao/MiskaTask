package com.mrcoder.retrofitexample.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mrcoder.retrofitexample.model.Country;
import com.mrcoder.retrofitexample.retrofit.Api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class Country_ViewModel extends ViewModel {

    private MutableLiveData<List<Country>> countryList;


    public LiveData<List<Country>> getCountry() {
        if (countryList == null) {
            countryList = new MutableLiveData<List<Country>>();

            loadCountries();

        }
        return countryList;
    }


    private void loadCountries() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.COUNTRY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api country_api = retrofit.create(Api.class);
        Call<List<Country>> coutry_call = country_api.getCountry();

        coutry_call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                countryList.setValue(response.body());
                Timber.e(response.toString());

                /*JSONArray countryArray = new JSONArray(response.body());
                for (int i = 0; i < countryArray.length(); i++) {
                    Country country = new Country();
                    try {
                        JSONObject countryObject = countryArray.getJSONObject(i);
                        country.setName(countryObject.getString("name"));
                        country.setRegion(countryObject.getString("region"));
                        country.setSubregion(countryObject.getString("subregion"));
                        country.setCapital(countryObject.getString("capital"));
                        country.setPopulation(countryObject.getString("population"));
                        country.setFlag(countryObject.getString("flag"));
                        country.setBorders(countryObject.getJSONArray("borders"));
                        country.setLanguages(countryObject.getJSONArray("languages"));

//                        countryArrayList.add(country);
                        countryList.setValue(country);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {

            }
        });
    }
}
