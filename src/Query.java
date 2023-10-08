// Query class to group the board and words together for each query sent to the solver
public record Query<T, T1>(char[][] board, String[] words) {

    public char[][] getBoard() {
        return board;
    }

    public String[] getWords() {
        return words;
    }
}
