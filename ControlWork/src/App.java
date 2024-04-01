import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Domains.Repository;

public class App {
    public static void main(String[] args) throws Exception {
        String file = "input.txt";

        Repository db = new Repository(file);
        Integer size = db.length();
        Integer maxLengthWord = db.maxLengthEntries();
        List<String> listMaxWords = db.maxEntries();
        HashMap<String, Integer> frequency = db.getFrequency();

        System.out.println("--------------------------------------");
        System.out.println("Number of entries: " + size);
        System.out.println("Maximum record length: " + maxLengthWord);
        System.out.println("--------------------------------------");
        System.out.println("Frequency of recordings:");
        for (String str : frequency.keySet()) {
            System.out.println(str + " : " + frequency.get(str));
        }
        System.out.println("--------------------------------------");
        System.out.println("The longest words:");
        for (int i=0; i<listMaxWords.size(); i++) {
            System.out.println(listMaxWords.get(i));
        }
    }
}
