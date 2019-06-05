package webScraping.WebScraping;

import java.io.*;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class Scraper implements WebScraper{

    private String url;
    private String savePath;
    private String filename;
    private String html;

    public Scraper(String url, String savePath, String filename){
        this.url = url;
        this.savePath = savePath;
        this.filename = filename;
    }

    public String beginScraper(){

        return "Extracting data";

    }

    public void targetPage(){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.url)).build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            this.html = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveHTML(){

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream(this.savePath + this.filename), "UTF-8"))) {
   writer.write(this.html);
              }catch(FileNotFoundException ioe){
                  ioe.printStackTrace();
              }catch(UnsupportedEncodingException ioe){
                  ioe.printStackTrace();
              }catch(IOException ioe){
                  ioe.printStackTrace();
              }
    }

    public String closeScraper(){

        return "closing!!!";

    }

    public static void main(String[] args){
        
        String url = "http://www.delfi.ee";
        String path = "choose path";
        String filename = "page.html";

        Scraper kraap = new Scraper(url, path, filename);
        System.out.println(kraap.beginScraper());
        kraap.targetPage();
        kraap.saveHTML();
        System.out.println(kraap.closeScraper());        


    }

}
