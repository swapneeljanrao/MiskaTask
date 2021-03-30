package com.mrcoder.retrofitexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrcoder.retrofitexample.adapter.HeroesAdapter;
import com.mrcoder.retrofitexample.adapter.CountryAdapter;
import com.mrcoder.retrofitexample.model.Country;
import com.mrcoder.retrofitexample.model.Hero;
import com.mrcoder.retrofitexample.view_model.Country_ViewModel;
import com.mrcoder.retrofitexample.view_model.HeroesViewModel;

import android.os.Bundle;

import java.util.List;

import timber.log.Timber;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroesAdapter adapter;
    CountryAdapter countryAdapter;

    List<Hero> heroList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_countries);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*HeroesViewModel model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new HeroesAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });*/

        Country_ViewModel country_viewModel = ViewModelProviders.of(this).get(Country_ViewModel.class);

        country_viewModel.getCountry().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countryList) {
                countryAdapter = new CountryAdapter(MainActivity.this, MainActivity.this, countryList);
                recyclerView.setAdapter(countryAdapter);
            }
        });

    }
}