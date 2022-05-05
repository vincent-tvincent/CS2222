import java.util.ArrayList;
import java.util.Arrays;

public class solutions {
    private static void setRelatedPosition(int[][] board2d, int x, int y, boolean isAdd){
        int value = -1;
        if(isAdd) value = 1;
        int loopTimes = Math.max(y,board2d.length - y); // the maximum movement on y axis from this point as the center
        board2d[y][x] += value;
        for(int iterate = 1; iterate < loopTimes; iterate++){

            int upRow = y - iterate; // straight up
            int downRow = y + iterate; // straight down
            int RDownLUp = x + iterate; // right side go down, left side go up \/
            int RUpLDown = x - iterate; // right side go up, left side go down /\
            boolean RDownLUpInRange = RDownLUp < board2d[0].length;
            boolean RUpLDownInRange = RUpLDown > -1;
            if(y + iterate < board2d.length){ // have space up
                board2d[downRow][x] += value;
                if(RDownLUpInRange) board2d[downRow][RDownLUp] += value;
                if(RUpLDownInRange) board2d[downRow][RUpLDown] += value;
            }
            if(y - iterate > -1){ // have space down
                board2d[upRow][x] += value;
                if(RDownLUpInRange) board2d[upRow][RDownLUp] += value;
                if(RUpLDownInRange) board2d[upRow][RUpLDown] += value;
            }
        }
    }
    private static int firstZero(int[] board){
        for(int i = 0; i < board.length; i++){
            if(board[i] == 0) return i;
        }
        return board.length;
    }
    private static boolean isEmptyArray(int[] array){
        boolean result = true;
        for(int i = 0; i < array.length && !result; i++){
            result = array[i] == 0;
        }
        return result;
    }
    private static boolean ifNotInclude(ArrayList<int[]> set, int[] array){
        boolean result = true;
        for(int subSet = 0; subSet < set.size() && result; subSet++) {
            boolean isSame = true;
            for (int i = 0; i < array.length && isSame; i++) {
                isSame = set.get(subSet)[i] == array[i];
            }
            result = !isSame;
        }
        return result;
    }
    private static boolean stillHaveSpace(int[][] board){
        boolean result = true;
        for(int i = 0; i < board.length && result; i++){
            boolean haveZero = false;
            for(int j = 0; j < board[i].length && !haveZero; j++) haveZero = board[i][j] == 0;
            result = haveZero;
        }
        return result;
    }

    // question 1
    public static boolean isLegalPosition(int[] board, int n){
        boolean result = true;
        int[][] board2d = new int[n][n];
        for(int row = 0; row < n && result && board[row] > 0; row++){
            if(row > 0){
                int col = board[row] - 1;
                result = board2d[row][col] < 1;
            }
            if(result) setRelatedPosition(board2d,board[row] - 1,row,true);
        }
        return result;
    }

    // question 2
    public static int[] nextLegalPosition(int[] board, int n){
        int nextRow = firstZero(board);// go to a new line
        if(isLegalPosition(board,n)){ // the position is already legal
            if(nextRow < n) board[nextRow] = 1; // new line start from 1
        }
        board = fixIllegalPosition(board,n,nextRow); // make it legal
        return board;
    }

    private static int[] fixIllegalPosition(int[] board, int n,int targetRow){
        while(!isLegalPosition(board,n)){ // illegal position
            if(board[targetRow] == n){
                board[targetRow] = 0; //should change previous line
                board[targetRow - 1] ++;
            }else{
                board[targetRow]++; //try nest position
            }
            board = fixIllegalPosition(board,n,targetRow - 1);
        }
        return board;
    }

    public static int[] findFirstSolution(int n){
        int[] board = new int[n];
        for(int iterate = 0; iterate < n; iterate++){
            board = nextLegalPosition(board,n);
        }
        return board;
    }
}
