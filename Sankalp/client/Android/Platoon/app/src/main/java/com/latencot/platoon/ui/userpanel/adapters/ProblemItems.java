package com.latencot.platoon.ui.userpanel.adapters;

import android.graphics.drawable.Drawable;

import java.math.BigInteger;

public class ProblemItems {
    private BigInteger problem_id;
    private String problem_header;

    public ProblemItems(BigInteger problem_id, String problem_header) {
        this.problem_id = problem_id;
        this.problem_header = problem_header;
    }

    public BigInteger getProblem_id() {
        return problem_id;
    }

    public String getProblem_header() {
        return problem_header;
    }
}