package Mandatory_three;

import java.io.IOException;
import java.lang.*;

interface executingFile{

    public String readFile();

    public String[] cutTextIntoWords();

    public String returnInLowercase() throws IOException;

    public String countWords(int wordLen);

}

