package com.latencot.platoon.ui.userpanel.adapters;

import java.math.BigInteger;

public class SolutionItems {
    private BigInteger serial_id;
    private String header, description;

    public SolutionItems(BigInteger serial_id, String header, String description) {
        this.serial_id = serial_id;
        this.header = header;
        this.description = description;
    }

    public BigInteger getSerialId() {
        return serial_id;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }
}
