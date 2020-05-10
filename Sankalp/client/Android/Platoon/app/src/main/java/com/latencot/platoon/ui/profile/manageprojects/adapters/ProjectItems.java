package com.latencot.platoon.ui.profile.manageprojects.adapters;

import java.math.BigInteger;

public class ProjectItems {
    BigInteger serial_id;
    String project_name, project_description;
    int is_anonymous;

    public ProjectItems(BigInteger serial_id, String project_name, String project_description, int is_anonymous) {
        this.serial_id = serial_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.is_anonymous = is_anonymous;
    }

    public BigInteger getSerial_id() {
        return serial_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public int getIs_anonymous() {
        return is_anonymous;
    }
}
