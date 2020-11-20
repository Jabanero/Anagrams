import java.util.*;
import java.io.*;
public class Anagrams {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("input.txt"));
        ArrayList<String> dictionary = new ArrayList<String>();
        while (fileScanner.hasNext()) {
            dictionary.add(fileScanner.next());
        }
        CanonicalComparator canon = new CanonicalComparator();
        Collections.sort(dictionary, canon);
        
    }
    //returns an ArrayList with the indices of the anagrams for the target word
    public static ArrayList<Integer> findAnagrams(ArrayList<String> dictionary, String target, 
    CanonicalComparator canon) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int i = Collections.binarySearch(dictionary, target, canon);
        int j = i - 1;
        while (canon.compare(target, dictionary.get(i)) == 0) {
            if (!target.equals(dictionary.get(i))){
                indices.add(i);
            }
            i++;
        }
        while (canon.compare(target, dictionary.get(j)) == 0){
            if (!target.equals(dictionary.get(j))){
                indices.add(j);
            }
            j--;
        }

        return indices;
    }
}