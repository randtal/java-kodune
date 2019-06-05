package Mandatory_three;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class interface_classFile implements executingFile{

    String filePath;
    String file_content;
    String[] array_of_words;
    String lowercaseText;

    public interface_classFile(String path){
        
        this.filePath = path;
    }

    public String readFile(){

        Path file_path = Paths.get(this.filePath);
        try {
            byte[] file_content_in_bytes = Files.readAllBytes(file_path);
            String file_content = new String(file_content_in_bytes, StandardCharsets.UTF_8);
            this.file_content = file_content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.file_content;
    }

    public String[] cutTextIntoWords(){
        String[] array_of_words = this.file_content.split(" ");
        this.array_of_words = array_of_words;
        return array_of_words;
    }

    public String returnInLowercase() throws IOException{
        try{String s = new String(Files.readAllBytes(Paths.get(this.filePath)), StandardCharsets.UTF_8);
            return s.toLowerCase();
            }catch(IOException e){
                e.printStackTrace();
            }
            return "ok";
            
    }
    
    public String countWords(int wordLen){
        int counter = 0;
        for(int i = 0; i < this.array_of_words.length; i++){
            String word = this.array_of_words[i];
            if(word.length() > wordLen){
                counter++;
            }
        }
        return "Nii palju sõnu esineb" + counter;
    }

}