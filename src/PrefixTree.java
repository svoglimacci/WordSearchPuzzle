import java.util.HashMap;

// Prefix tree used to store the words and speed up the search
public class PrefixTree {

    // Using a hashmap to save space instead of initializing an array of the alphabet size.
    HashMap<Character, PrefixTree> children;
    String word;

    public PrefixTree() {
        children = new HashMap<>();
    }
}




