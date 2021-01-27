package NQueen;

/**
 * @author: Clara Mao <chiehyu.mao@gmail.com>
 * @date: 01/27/2021
 */
public class Service {
    public static void nQueens(int noOfQueens) {
        //one row only have one Queen
        int [] chessBoard = new int[noOfQueens];
        //start from board[0]
        placeQueen(chessBoard, 0, noOfQueens);
    }

    private static boolean notConflict(int[] chessBoard, int currentColumnOfQueen) {
        for (int i = 0; i < currentColumnOfQueen; i++) {
            //same row then false
            if (chessBoard[i] == chessBoard[currentColumnOfQueen])
                return false;

            //same diagonal then false
            if ((currentColumnOfQueen - i) == Math.abs(chessBoard[currentColumnOfQueen] - chessBoard[i])) {
                return false;
            }
        }
        return true;
    }

    private static void placeQueen(int[] chessBoard, int current, int noOfQueens) {
        if (current == noOfQueens) {
            //if all queens are already be placed
            displayQueens(chessBoard);
            return;
        }

        for (int i = 0; i < noOfQueens; i++) {
            chessBoard[current] = i;
            if (notConflict(chessBoard, current)) {
                //if no conflict to others, place Queen in next row(current row+1)
                placeQueen(chessBoard, current + 1, noOfQueens);
            }
        }
    }

    private static void displayQueens(int[] board) {
        //print board[i] value of Queen
        for (int value : board) {
            System.out.print(value + "\t");
        }

        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int value : board) {
                if (value == i)
                    System.out.print("Q\t");
                else
                    System.out.print("*\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //set private constructor for java rule
    private Service(){
    }
}
