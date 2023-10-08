import java.util.List;

// Method used to print the results in the required format "word (x1,y1)->...->(xi,yi)"
public class StringPrinter {

    public void stringify(List<Result> array, int queryNb) {
        //sort the array alphabetically
        array.sort((a, b) -> {
            int comparator = a.getWord().compareTo(b.getWord());
            return Integer.compare(comparator, 0);
        });

        StringBuilder sb = new StringBuilder();
        sb.append("Query ").append(queryNb).append(":\n");
        // Create a string for each result and format it for printing
        for (Result item : array) {
            sb.append(item.getWord()).append(" ");
            for (int[] coordinates : item.getPath()) {
                sb.append("(").append(coordinates[0]).append(",").append(coordinates[1]).append(")");
                if (coordinates != item.getPath().get(item.getPath().size() - 1)) {
                    sb.append("->");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
