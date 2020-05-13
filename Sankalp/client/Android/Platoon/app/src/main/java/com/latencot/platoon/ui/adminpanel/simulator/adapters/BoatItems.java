package com.latencot.platoon.ui.adminpanel.simulator.adapters;

import java.math.BigInteger;

public class BoatItems {
    BigInteger id;
    String name, type;

    public BoatItems(BigInteger id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
