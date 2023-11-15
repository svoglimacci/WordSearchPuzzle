import java.util.List;

// Result class used to store the results of the search and facilitate printing
public class Result {

    String word;
    List<int[]> path;

    public Result(String word, List<int[]> path) {
        this.word = word;
        this.path = path;
    }

    public String getWord() {
        return word;
    }

    public List<int[]> getPath() {
        return path;
    }
}