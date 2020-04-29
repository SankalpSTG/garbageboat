package com.latencot.platoon.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class ImageClass {
    @SerializedName("serial_id")
    private BigInteger serial_id;

    @SerializedName("image")
    private String image;
}
