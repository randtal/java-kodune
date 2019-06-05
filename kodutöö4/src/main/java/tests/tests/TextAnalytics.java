package tests.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class TextAnalytics{
    
    String file_path;
    String fileContent;
    String[] array_of_words;
    HashMap<String, Integer> repeatWord = new HashMap<String, Integer>();


    public TextAnalytics(String filePath){
        
        this.file_path = filePath;
        this.readFile();
        this.cutTextIntoWords();
    }
    
    public String readFile(){

        Path file_path = Paths.get(this.file_path);
        try {
            byte[] fileContent_in_bytes = Files.readAllBytes(file_path);
            String fileContent = new String(fileContent_in_bytes, StandardCharsets.UTF_8);
            this.fileContent = fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public String[] cutTextIntoWords(){
        String[] array_of_words = this.fileContent.split(" ");
        this.array_of_words = array_of_words;
        return array_of_words;

    }

    public String returnInLowercase(){
        
        try{String s = new String(Files.readAllBytes(Paths.get(this.file_path)), StandardCharsets.UTF_8);
            return s.toLowerCase();
        }catch(IOException e){
            e.printStackTrace();
        }
        return "ok";
    }

    public String countWordsWithHash(){
        for(int i = 0; i < this.array_of_words.length; i++){
            if(!this.repeatWord.containsKey(this.array_of_words[i])){
                this.repeatWord.put(this.array_of_words[i], 1);
            }else{
                this.repeatWord.put(this.array_of_words[i], this.repeatWord.get(this.array_of_words[i] + 1));//with get you get a value
            } 
        }

        for(String word : this.repeatWord.keySet()){
                return(word + ": " + (Integer) this.repeatWord.get(word));
            
        }
        
        return "ok";
        //return repeatWord;
    }

}