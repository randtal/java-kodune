package webScraping.WebScraping;
import java.lang.*;

interface WebScraper{

    public String beginScraper();

    public void targetPage();

    public void saveHTML();

    public String closeScraper();

}