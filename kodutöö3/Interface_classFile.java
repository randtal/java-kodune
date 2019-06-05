package rando_kodu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Interface_classFile implements executingFile {

    String filePath;
    String file_content;
    String[] array_of_words;
    String lowercaseText;

	public Interface_classFile(String path){
        this.filePath = path;
    }

    public String readFile(){
    	System.out.println("Reading text from file.");
        Path file_path = Paths.get(this.filePath);
        try {
            byte[] file_content_in_bytes = Files.readAllBytes(file_path);
            this.file_content = new String(file_content_in_bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.file_content;
    }

    public String[] cutTextIntoWords(){
    	System.out.println("Cutting text to words");
    	// selle rea tegelt oleks võinud väga vabalt ülemisse funktsiooni liita enne catchi
        this.array_of_words = this.file_content.split("\\s+");
        System.out.println("Counted " + this.array_of_words.length + " words");
        return this.array_of_words;
    }

    public String changeToLowercase(){
    	System.out.println("Changing all words to lowercase");
    	
    	for (int i = 0; i < this.array_of_words.length; i++) {
			String word_in_lowercase = this.array_of_words[i].toLowerCase();
			this.lowercaseText = this.lowercaseText + " " + word_in_lowercase;
			this.array_of_words[i] = word_in_lowercase;
		}
    	return this.lowercaseText;
    }

    public Integer countWords(int wordLen){
        int counter = 0;
        for(int i = 0; i < this.array_of_words.length; i++){
            String word = this.array_of_words[i];
            if(word.length() > wordLen){
                counter++;
            }
        }
        return counter;
    }
}
