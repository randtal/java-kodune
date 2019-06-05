package rando_kodu;

import java.io.IOException;
import java.lang.*;

interface executingFile{

    public String readFile();

    public String[] cutTextIntoWords();

    public String changeToLowercase() throws IOException;

    public Integer countWords(int wordLen);

}

