package com.mrcoder.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

public class RegionModel {
    @SerializedName("region")
    private String name;

    public RegionModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionModel that = (RegionModel) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
