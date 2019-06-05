package Mandatory_three;

import java.io.IOException;

public class Program_main{

    public static void main(String args[]) throws IOException{

        String path = "C:\\Users\\Rando\\Desktop\\java\\kodutoo java\\artiklikogumik.txt";
        interface_classFile exe = new interface_classFile(path);
        System.out.print(exe.readFile());
        System.out.println(exe.returnInLowercase());
        System.out.println(exe.countWords(5));

    }
}