package com.example.retrofit.models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class FlowerResponse implements Serializable
{

    @SerializedName("flowerlist")
    private List<FlowerList> flowerlist = null;

    public List<FlowerList> getFlowerlist() {
        return flowerlist;
    }

    public void setFlowerlist(List<FlowerList> flowerlist) {
        this.flowerlist = flowerlist;
    }

}
