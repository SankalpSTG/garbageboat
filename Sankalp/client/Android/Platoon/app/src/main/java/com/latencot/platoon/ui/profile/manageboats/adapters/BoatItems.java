package com.latencot.platoon.ui.profile.manageboats.adapters;

import java.math.BigInteger;

public class BoatItems {
    int verified;
    String petname;
    String type;
    BigInteger registration_number, serial_id;

    public int getVerified() {
        return verified;
    }

    public String getPetname() {
        return petname;
    }

    public String getType() {
        return type;
    }

    public BigInteger getRegistration_number() {
        return registration_number;
    }

    public BigInteger getSerial_id() {
        return serial_id;
    }

    public BoatItems(int verified, String petname, String type, BigInteger registration_number, BigInteger serial_id) {
        this.verified = verified;
        this.petname = petname;
        this.type = type;
        this.registration_number = registration_number;
        this.serial_id = serial_id;
    }
}
