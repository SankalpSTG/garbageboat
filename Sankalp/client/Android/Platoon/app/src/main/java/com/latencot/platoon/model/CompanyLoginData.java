package com.latencot.platoon.model;

import java.math.BigInteger;

public class CompanyLoginData {
    BigInteger serial_id;
    int verification_level;
    int account_level;

    public CompanyLoginData(BigInteger serial_id, int verification_level, int account_level) {
        this.serial_id = serial_id;
        this.verification_level = verification_level;
        this.account_level = account_level;
    }

    public BigInteger getSerial_id() {
        return serial_id;
    }

    public int getVerification_level() {
        return verification_level;
    }

    public int getAccount_level() {
        return account_level;
    }
    public boolean isVerified(){
        if(this.account_level == 1){
            return true;
        }
        return false;
    }
    public boolean hasCompletedProfile(){
        if(this.verification_level >= 2){
            return true;
        }
        return false;
    }
}
