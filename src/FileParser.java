import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


// Method used to go through the Input file line by line and parse it into a list of queries
public class FileParser {

    public ArrayList<Query<char[][], String[]>> parseFile(String arg) throws IOException {

        ArrayList<Query<char[][], String[]>> queries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arg))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] dimensions = line.split(" ");
                int rows = Integer.parseInt(dimensions[0]);
                int cols = Integer.parseInt(dimensions[1]);

                char[][] board = new char[rows][cols];

                for (int i = 0; i < rows; i++) {
                    line = br.readLine();
                    for (int j = 0; j < (cols * 2) - 1; j += 2) {
                        board[i][j / 2] = line.charAt(j);
                    }
                }
                String[] words = br.readLine().split(" ");
                queries.add(new Query<>(board, words));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        return queries;
    }
}