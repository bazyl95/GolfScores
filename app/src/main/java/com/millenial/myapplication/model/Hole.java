package com.millenial.myapplication.model;

public class Hole {
    private int mScore;
    private int mHoleIndex;

    public Hole(int mHoleIndex, int mScore) {
        this.mScore = mScore;
        this.mHoleIndex = mHoleIndex;
    }

    public String getmHoleName() {
        return "Hole " + (mHoleIndex + 1) + ":";
    }

    public int getmHoleIndex() {
        return mHoleIndex;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public void setmHoleIndex(int mHoleIndex) {
        this.mHoleIndex = mHoleIndex;
    }
}
