package rando_kodu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program_main {

	public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Rando\\Desktop\\java\\kodutoo java\\artiklikogumik.txt";
        Interface_classFile exe = new Interface_classFile(path);
        
        exe.readFile();
        exe.cutTextIntoWords();
        exe.changeToLowercase();
        
        // k�si input kasutajalt
        String input = null;
        int number = 0;
        try {
        	System.out.println("How many letters in word?");
            BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
            input = user_input.readLine();
            number = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
           System.out.println("Not a number !");
        }
        
        // v�ljasta ainult s�nad, mis on pikemad kui kasutaja antud input
        System.out.println("Found this many words: " + exe.countWords(number));
	}

}
