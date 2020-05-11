package com.latencot.platoon.ui.userpanel.adapters;

import android.graphics.drawable.Drawable;

public class DeveloperItems {
    String name;

    Drawable image;
    public DeveloperItems(String name, Drawable image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }
}
