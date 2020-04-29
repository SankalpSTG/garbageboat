package com.latencot.platoon.ui.homefragments.Adapters;

import android.graphics.drawable.Drawable;

public class GridItems {
    private Drawable imagedrawable;
    private String title;
    public GridItems(String title, Drawable imagedrawable){
        this.imagedrawable = imagedrawable;
        this.title = title;
    }

    public Drawable getImagedrawable() {
        return imagedrawable;
    }

    public String getTitle() {
        return title;
    }
}
