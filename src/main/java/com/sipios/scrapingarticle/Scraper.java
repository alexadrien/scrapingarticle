package com.sipios.scrapingarticle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scraper {
    private static final String BASE_URL = "http://example.com/"; // The website's base url you want to scrape.
    private static final String MAIN_URL = "http://example.com/something"; // The website's precise page you want to scrape.

    // CSS query strings
    private static final String SECTOR_LINK_CSS_QUERY = "a.sector-data-table__sector-name-link";
    private static final String SECTOR_NAME_CSS_QUERY = ".sector-data-table__sector-row--selected a";
    private static final String SUB_SECTOR_NAME_CSS_QUERY = ".sector-data-table__industry-group-name";
    private static final String SUB_SECTOR_VALUE_CSS_QUERY = ".sector-data-table__industry-group-return";

    public static void main(String[] args) throws IOException {
        // Declare an object to store the sectors link
        ArrayList<String> stringLinksToSectors = new ArrayList<String>();

        // Use the chromedriver file at the root of this repository
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        // Switch on the ChromeDriver
        ChromeDriver driver = new ChromeDriver();

        Document document;

        // Get and parse the html page behind the url http://example.com/markets/sectors
        document = Jsoup.connect(MAIN_URL).get();

        // Find all the elements with the CSS query a.sector-data-table__sector-name-link
        Elements linksToSector = document.select(SECTOR_LINK_CSS_QUERY);

        // If Jsoup failed because of some security check,
        // let's try with active scraping
        if (linksToSector.size() == 0) {
            driver.get(MAIN_URL);
            document = Jsoup.parse(driver.getPageSource());
            linksToSector = document.select(SECTOR_LINK_CSS_QUERY);
        }

        // If the active scraping failed, it means the page requires human interaction.
        // This will show a chrome window on your computer. Please follow the instructions
        // to prove you're a human to the webpage
        if (linksToSector.size() == 0) {
            driver.getScreenshotAs(OutputType.FILE);
        }

        // For all the specific sector link (skipping the first 'All Sectors' link at i=0
        for (int i = 1; i < linksToSector.size(); i++) {
            stringLinksToSectors.add(BASE_URL + linksToSector.get(i).attr("href"));
        }

        ScrapedData resultData = new ScrapedData();

        // For all the link scraped before
        for (int i = 0; i < stringLinksToSectors.size(); i++) {
            String linkToCurrentSector = stringLinksToSectors.get(i);
            // Load the page behind the URL
            driver.get(linkToCurrentSector);

            // Find the sector name, the sub-sectors names and values
            String sectorName = driver.findElementByCssSelector(SECTOR_NAME_CSS_QUERY).getText();
            List<WebElement> subSectorName = driver
                    .findElementsByCssSelector(SUB_SECTOR_NAME_CSS_QUERY);
            List<WebElement> subSectorValue = driver
                    .findElementsByCssSelector(SUB_SECTOR_VALUE_CSS_QUERY);

            // The next few lines fill an array of Performance object with the results founded by ChromeDriver
            ArrayList<Performance> values = new ArrayList<Performance>();
            for (int j = 0; j < subSectorName.size(); j++) {
                values.add(
                        new Performance(
                                subSectorName.get(j).getText(),
                                subSectorValue.get(j).getText()
                        )
                );
            }

            // Fill a sector object with the current Sector page data
            Sector currentFinancialCategory = new Sector(sectorName, values);
            resultData.getSectors().add(currentFinancialCategory);
        }
        ObjectMapper mapper = new ObjectMapper();
        // Save the data in a json file
        mapper.writeValue(new File("results.json"), resultData);

        // Shut down ChromeDriver instance if scraping was sucessful
        if (linksToSector.size() != 0) {
            driver.close();
            System.out.println("Success!");
        } else {
            System.out.println("Something went wrong, can you check the new Chrome window and see if it requires a human interaction ?");
        }
    }
}

