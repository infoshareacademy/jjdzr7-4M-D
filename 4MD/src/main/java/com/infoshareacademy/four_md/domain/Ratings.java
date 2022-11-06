package com.infoshareacademy.four_md.domain;

public enum Ratings {
    R0(0), R1(1), R2(2), R3(3), R4(4), R5(5);

    private int numVal;

    Ratings(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
