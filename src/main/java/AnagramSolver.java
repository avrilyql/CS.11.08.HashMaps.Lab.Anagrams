import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) throws FileNotFoundException {
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNextLine()){
            String word = scanner.nextLine();
            //seperate word into char array for sorting
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            //if unfamiliar then add to hm
            if (!hm.containsKey(sorted)) {
                hm.put(sorted, new ArrayList<>());
            }
            hm.get(sorted).add(word);
        }
        return hm;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> biggest = new ArrayList<>(); //arraylist for biggest anagram
        ArrayList<ArrayList<String>> values =  new ArrayList<ArrayList<String>>(anagrams.values()); //arraylist of values
        //iterate through values
        for (int i = 0; i < values.size(); i++) {
            ArrayList<String> value = values.get(i);
            if (value.size() > biggest.size()) {
                biggest = value; //change biggest value
            }
        }
        return biggest;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        for (String key: anagrams.keySet()) { //iterate thru keys
            System.out.println(key + ":" + anagrams.get(key));
        }
    }

}