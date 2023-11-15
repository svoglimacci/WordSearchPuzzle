import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Simon Voglimacci Stéphanopoli (20002825)
 * Julie Yang (20239909)
 * @Date: 2023/10/08
 * @Description: This program is used to find the path of words in a 2D array of characters.
 * It takes an input file as an argument and parses it into a list of queries.
 * For each query, it finds the path of each word from a list of word using
 * depth first search and a prefix tree.
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        // Initializing the classes used in the program
        FileParser fp = new FileParser();
        WordSearcher ws = new WordSearcher();
        StringPrinter sp = new StringPrinter();

        // Parse the InputFile into a list of queries
        ArrayList<Query<char[][], String[]>> parsing = fp.parseFile(args[0]);

        // For each Query, print the query being solved and print the results
        int NbQuery = 0;
        for (Query<char[][], String[]> data : parsing) {
            List<Result> results = ws.solve(data.getBoard(), data.getWords());
            NbQuery++;
            System.out.print(sp.stringify(results, NbQuery));
        }

    }
}