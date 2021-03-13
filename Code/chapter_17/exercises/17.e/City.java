package com.claudiodesio.lambda.data;

public class City {

    private String name;

    private boolean stateCapital;

    private boolean onTheSea;

    public City(String name, boolean stateCapital, boolean onTheSea) {
        this.name = name;
        this.stateCapital = stateCapital;
        this.onTheSea = onTheSea;
    }

    public boolean isOnTheSea() {
        return onTheSea;
    }

    public void setOnTheSea(boolean onTheSea) {
        this.onTheSea = onTheSea;
    }

    public boolean isStateCapital() {
        return stateCapital;
    }

    public void setStateCapital(boolean stateCapital) {
        this.stateCapital = stateCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}