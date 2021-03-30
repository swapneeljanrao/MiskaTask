package com.mrcoder.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.List;

public class Country {

    String name;
    String capital;
    String flag;
    String region;
    String subregion;
    String population;
    /*List<Border> borders;
    List<Language> languages;*/
    /*JSONArray borders;
    JSONArray languages;*/

    /*public Country(String name, String capital, String flag, String region, String subregion, String population, JSONArray borders, JSONArray languages) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.borders = borders;
        this.languages = languages;
    }*/
    public Country(String name, String capital, String flag, String region, String subregion, String population) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
    }

    public Country() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    /*public JSONArray getBorders() {
        return borders;
    }

    public void setBorders(JSONArray borders) {
        this.borders = borders;
    }

    public JSONArray getLanguages() {
        return languages;
    }

    public void setLanguages(JSONArray languages) {
        this.languages = languages;
    }*/

    /*public List<Border> getBorders() {
        return borders;
    }

    public void setBorders(List borders) {
        this.borders = borders;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List languages) {
        this.languages = languages;
    }*/
}
