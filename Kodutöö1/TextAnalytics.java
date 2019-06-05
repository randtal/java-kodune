// 1) Loete failid sisse. (vt Github)
// 2) Eraldate kõik sõnad (Kasuks String.split() )
// 3) Muudad kõik tähed väikesteks
// 4) Loend sellest, mitu korda mingi sõna esineb. (kasuks HashMap)

// split("\\s+");

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class TextAnalytics {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Rando\\Desktop\\java\\kodutoo java\\artiklikogumik.txt";
		readWholeFileAsString(path);
	}
	
    public static void readWholeFileAsString(String path) throws IOException{
    	// muutujad
    	List<String> list = new ArrayList<String>();
    	String line = null;
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
    	// BufferedReader loeb faili sisse järjest rea haaval, kuid, kuna ma tahan täpitähti normaalselt ,siis annan selle läbi FileInputStreami
    	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
    	
    	// loetakse rida haaval, iga rida splititakse non-whitespace characterite vahel (ehk splititakse space,tab jne kohal)
        while ((line = br.readLine()) != null) {
        	// Splitime ja salvestame iga sõna stringina arraysse
        	String[] sonad = line.split("\\s+");
        	
        	// splittides saime array of strings, käime array läbi ja lisame kõik listi,
        	// niimoodi saame kõik failis olevad sõnad listi
        	for (int i = 0; i < sonad.length; i++) {
        		// Kuna me töötleme praegu sõnu, siis siin tuleks terve sõna muuta lowercase
        		String word = sonad[i].toLowerCase();
        		//System.out.println(word);
        		
        		// Tegeleme hashmapiga
        		if(map.containsKey(word) == false) {
        			// kui sõna pole mapis, lisame selle ja paneme counteriks 1
            		map.putIfAbsent(word, 1);        			
        		}
        		else {
        			// kui sõna on mapis, paneme counterile +1
        			Integer counter = map.get(word);
        			map.put(word, counter+1);
        		}
        		// lõpuks lisame sõna suurde listi
        		list.add(word);
        	}
        }
        // väljastamised
        System.out.println("Sõnu kokku: " + list.size());
        
        // lambda expression
        // ütleme et for each (key, value) ehk key:value pair puhul mapis, prindi mulle see välja
        map.forEach((key, value) -> System.out.println(key + ":" + value));
        
        // sulgeme readeri, et memory leaki ei tekiks
        br.close();
    }
}
