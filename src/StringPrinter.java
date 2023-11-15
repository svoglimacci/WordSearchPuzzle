import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Method used to print the results in the required format "word (x1,y1)->...->(xi,yi)"
public class StringPrinter {

    public String stringify(List<Result> array, int queryNb) {

        // append each word and its path to a string, format it and add it to an array
        String[] stringArray = new String[array.size()];
        int i = 0;
        for (Result result : array) {
            StringBuilder sb = new StringBuilder();
            sb.append(result.getWord());
            sb.append(" ");
            for (int[] coord : result.getPath()) {
                sb.append("(").append(coord[0]).append(",").append(coord[1]).append(")");
                if (coord != result.getPath().get(result.getPath().size() - 1)) {
                    sb.append("->");
                }
            }

            stringArray[i] = sb.toString();
            i++;
        }

        // sort the array alphabetically
        Arrays.sort(stringArray, Comparator.comparing(String::toString));

        //add the queries to a single string
        StringBuilder sb = new StringBuilder();
        sb.append("Query ").append(queryNb).append(":\n");
        for (String s : stringArray) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
}