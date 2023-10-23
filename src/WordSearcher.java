import java.util.*;

public class WordSearcher {
    List<Result> results = new ArrayList<>();

    // Main method for the word search
    public List<Result> solve(char[][] board, String[] words) {

        //clear the results for the next query
        results.clear();

        //add words to a set to avoid duplicates
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        List<int[]> result = new ArrayList<>();
        //build a prefix tree from the words
        PrefixTree tree = buildTree(wordSet);


        // apply a depth first search to every element in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < (board[0].length); j++) {
                if (tree.children.containsKey(board[i][j])) {

                    // Create a new array list to store the coordinates of the current search and add the first coordinate
                    result.clear();
                    result.add(new int[]{i, j});
                    depthFirstSearch(board, i, j, tree, result);

                }
            }
        }
        return results;
    }

    //Build a prefix tree from the words in a list of words
    public PrefixTree buildTree(Set<String> words) {

        PrefixTree root = new PrefixTree();

        // For each word, Insert each of its characters into the tree
        for (String word : words) {
            PrefixTree current = root;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);

                // If the character is in the tree, move to the next node
                if (current.children.containsKey(character)) {
                    current = current.children.get(character);
                }

                // If the character is not in the tree, add it to the tree
                else {
                    PrefixTree next = new PrefixTree();
                    current.children.put(character, next);
                    current = next;
                }
            }
            // Set the word at the end of the tree
            current.word = word;
        }

        // Return the tree
        return root;
    }

    // Search the board for words using a prefix tree
    public void depthFirstSearch(char[][] board, int i, int j, PrefixTree tree, List<int[]> result) {
        final int[][] directions = {
                {0, 0},
                {0, 1},
                {-1, 1},
                {-1, 0},
                {-1, -1},
                {0, -1},
                {1, -1},
                {1, 0},
                {1, 1}
        };

        // Get the next node in the tree
        PrefixTree current = tree.children.get(board[i][j]);

        // If the current node is a word, add it to the result
        if (current.word != null) {
           results.add(new Result(current.word, new ArrayList<>(result)));
        }

        // exit the current search if the coordinates are out of bounds or if the current letter is not in the tree
        if (!tree.children.containsKey(board[i][j])) {
            return;
        }

        // recursion for each direction
        for (int[] direction : directions) {

            int[] newCoords = {i + direction[0], j + direction[1]};

            // ignore the new direction if it is out of bounds
            if (newCoords[0] < 0 || newCoords[0] >= board.length || newCoords[1] < 0 || newCoords[1] >= board[0].length) {
                continue;
            }

            if (current.children.containsKey(board[newCoords[0]][newCoords[1]])) {
            result.add(new int[]{newCoords[0], newCoords[1]});
            depthFirstSearch(board, newCoords[0], newCoords[1], current, result);
            result.remove(result.size() - 1);

            }

        }

    }
}

