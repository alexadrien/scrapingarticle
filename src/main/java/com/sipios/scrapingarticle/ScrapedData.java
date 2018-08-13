package com.sipios.scrapingarticle;

import java.util.ArrayList;
import java.util.List;

class ScrapedData {
    private List<Sector> sectors = new ArrayList<Sector>();

    public ScrapedData() {
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }
}

