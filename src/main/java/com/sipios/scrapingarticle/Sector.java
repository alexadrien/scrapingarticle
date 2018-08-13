package com.sipios.scrapingarticle;

import java.util.List;

class Sector {
    private String name;
    private List<Performance> performances;

    public Sector(String name, List<Performance> performances) {
        this.name = name;
        this.performances = performances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }
}
