import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Board input
        int row = sc.nextInt();
        int col = sc.nextInt();
        String[][] board = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = sc.next();
            }
        }

        // Words input
        int wordAmount = sc.nextInt();
        String[] words = new String[wordAmount];
        for (int i = 0; i < wordAmount; i++) {
            words[i] = sc.next();
        }

        boolean isFound = false;
        String word;
        for (int i = 0; i < wordAmount; i++) {
            isFound = false;
            word = words[i];

            if (findNorth(word, row, col, board)
                    || findEast(word, row, col, board)
                    || findSouth(word, row, col, board)
                    || findWest(word, row, col, board)
                    || findNorthEast(word, row, col, board)
                    || findNorthWest(word, row, col, board)
                    || findSouthEast(word, row, col, board)
                    || findSouthWest(word, row, col, board)) {
                isFound = true;
            }

            if(isFound) {
                System.out.println(word + " is found!");
            }
            else {
                System.out.println(word + " is not found!");
            }
        }
    }

    public static boolean findNorth(String word, int row, int col, String[][] board) {
        int check = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (i - k < 0 || !board[i - k][j].equals(word.substring(k, k + 1))) {
                        check = 0;
                        break;
                    }
                    check++;

                    if(check == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findSouth(String word, int row, int col, String[][] board) {
        int check = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (i + k >= row || !board[i + k][j].equals(word.substring(k, k + 1))) {
                        check = 0;
                        break;
                    }
                    check++;

                    if(check == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findWest(String word, int row, int col, String[][] board) {
        int check = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (j - k < 0 || !board[i][j - k].equals(word.substring(k, k + 1))) {
                        check = 0;
                        break;
                    }
                    check++;

                    if(check == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findEast(String word, int row, int col, String[][] board) {
        int check = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (j + k >= col || !board[i][j + k].equals(word.substring(k, k + 1))) {
                        check = 0;
                        break;
                    }
                    check++;

                    if(check == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findNorthEast(String word, int row, int col, String[][] board) {
        int check = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (i - k < 0 || j + k >= col || !board[i - k][j + k].equals(word.substring(k, k + 1))) {
                        check = 0;
                        break;
                    }
                    check++;

                    if(check == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findNorthWest(String word, int row, int col, String[][] board) {
        int check = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (i - k < 0 || j - k < 0 || !board[i - k][j - k].equals(word.substring(k, k + 1))) {
                        check = 0;
                        break;
                    }
                    check++;

                    if(check == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findSouthEast(String word, int row, int col, String[][] board) {
        int check = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (i + k >= row || j + k >= col || !board[i + k][j + k].equals(word.substring(k, k + 1))) {
                        check = 0;
                        break;
                    }
                    check++;

                    if(check == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findSouthWest(String word, int row, int col, String[][] board) {
        int check = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < word.length(); k++) {
                    if (i + k >= row || j - k < 0 || !board[i + k][j - k].equals(word.substring(k, k + 1))) {
                        check = 0;
                        break;
                    }
                    check++;

                    if(check == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
