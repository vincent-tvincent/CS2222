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

    private static boolean isEmptyArray(int[] array){
        boolean result = true;
        for(int i = 0; i < array.length && !result; i++){
            result = array[i] == 0;
        }
        return result;
    }
    //question1
    public static boolean isLegalPosition(int[] board, int n){
        boolean result = true;
        int[][] board2d = new int[n][n];
        setRelatedPosition(board2d,board[0] - 1,0,true);
        for(int row = 1; row < n && result; row++){
            int col = board[row] - 1;
            if(col > -1){
                result = board2d[row][col] < 1;
                if(result) setRelatedPosition(board2d,board[row] - 1,row,true);
            }
        }
        return result;
    }
    //question2
    public static int[] nextLegalPosition(int[] board, int n){
        int nextRow = 0;
        while(board[nextRow] > 0) nextRow ++;
        int[][] board2d = new int[n][n];
        Boolean keepAdd = true;
        for(int row = 0; row < board.length && keepAdd; row ++ ){
            if(board[row] > 0){
                setRelatedPosition(board2d,board[row] - 1,row,true);
            }else{
                keepAdd = false;
            }
        };
        return nextPosition(nextRow,n,board,board2d);
   }

   private static int[] nextLegalPosition(int[] board, int n, int nextRow){
       int[][] board2d = new int[n][n];
       Boolean keepAdd = true;
       for(int row = 0; row < board.length && keepAdd; row ++ ){
           if(board[row] > 0){
               setRelatedPosition(board2d,board[row] - 1,row,true);
           }else{
               keepAdd = false;
           }
       };
       return nextPosition(nextRow,n,board,board2d);
   }
   private static int[] nextPosition(int targetRow, int n, int[] board, int[][] board2d){
//       System.out.printf("position: ");
//       for(int position: board) System.out.print(position);
//       System.out.println(" target row: " + targetRow);
//       System.out.println();
       boolean keepCheck = true;
       while(keepCheck && targetRow > -1){
           int startCol = board[targetRow];
           if(board[targetRow] > 0){// if not 0, the function is back tracking
               // erase previous record
               setRelatedPosition(board2d,board[targetRow] - 1,targetRow,false);
               board[targetRow] = 0;
           }
           for(int col = startCol; col < n && keepCheck; col++){
               boolean valid = board2d[targetRow][col] < 1;
               if(valid){
                   board[targetRow] = col + 1; // store this result
                   //update the board
                   setRelatedPosition(board2d,col,targetRow,true);
               }
               keepCheck = !valid;
           }
           if(keepCheck){
               board = nextPosition(targetRow - 1,n,board,board2d);
               startCol = board[targetRow];
           }
       }
       return board;
   }
    //question3

   public static int[] findNextSolution(int n, int[] CompleteBoard){
        return nextLegalPosition(CompleteBoard,n,0);
   }

   public static int[] findFirstSolution(int n){
       int[] board = new int[n];
       int[][] board2d = new int[n][n];
       for(int targetRow = 0; targetRow < n; targetRow ++){
           board = nextPosition(targetRow,n,board,board2d);
       }
       return board;
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
   public static ArrayList<int[]> findAllSolution(int n){
        ArrayList<int[]> results = new ArrayList<>();
        results.add(findFirstSolution(n));
        for(int checkRow = n - 1; checkRow > -1; checkRow--){
            for(int iterate = 0; iterate < n; iterate++){
                int[] nextResult = results.get(results.size() - 1).clone();// keep going from previous result
                for(int currentRow = checkRow; currentRow < n; currentRow++) nextResult  = nextLegalPosition(nextResult,n,checkRow);
                if(ifNotInclude(results,nextResult)) results.add(nextResult); // if vaild
            }
        }
        return results;
   }

}
