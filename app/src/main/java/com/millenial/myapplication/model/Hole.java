package com.millenial.myapplication.model;

public class Hole {
    private String mHoleName;
    private int mScore;
    private int mHoleNumber;

    public Hole(String mHoleName,int mHoleNumber, int mScore) {
        this.mHoleName = mHoleName;
        this.mScore = mScore;
        this.mHoleNumber = mHoleNumber;
    }

    public String getmHoleName() {
        return mHoleName;
    }

    public void setmHoleName(String mHoleName) {
        this.mHoleName = mHoleName;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public int getmHoleNumber() {
        return mHoleNumber;
    }

    public void setmHoleNumber(int mHoleNumber) {
        this.mHoleNumber = mHoleNumber;
    }
}
