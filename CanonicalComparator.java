import java.util.Comparator;
import java.util.*;
public class CanonicalComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return retrieveCanonical(s1).compareTo(retrieveCanonical(s2));
    }
    public String retrieveCanonical(String s) {
            s = s.toLowerCase();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
    }
}