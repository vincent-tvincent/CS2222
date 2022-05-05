import java.util.ArrayList;

public class solutions {
    private static int firstZero(int[] board,int n){
        for(int row = 0; row < n; row++){
            if(board[row] == 0) return row;
        }
        return n;
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

    private static boolean isThisRowLegal(int[] board, int n, int targetRow){
        boolean result = true;
        for(int row = 0; row < targetRow && result; row++){
            int diagonalBias = targetRow - row;
            if(board[targetRow] == board[row] || Math.abs(board[targetRow] - board[row]) == diagonalBias){
                result = false;
            }
        }
        return result;
    }
    /**
     * question1
     * */
    public static boolean isLegalPosition(int[] board, int n){
        boolean result = true;
        int endRow = firstZero(board,n);
        for(int row = 0; row < endRow; row++){
            result = result && isThisRowLegal(board,n,row);
        }
        return result;
    }

    public static ArrayList<int[]> getAllPosition(int n){
        ArrayList<int[]> solutionSet = new ArrayList();
        addAllPosition(new int[n],n,solutionSet,0);
        return solutionSet;
    }
    /**
     * function for get all the possible placing include queens amount from 1 to n
     * */
    private static void addAllPosition(int[] board, int n,ArrayList<int[]>solutionSet, int targetRow){
        if(targetRow < n){
            for(int position = 0; position < n; position++){
                board[targetRow] = position + 1;
                if(isLegalPosition(board,n)){
                    addAllPosition(board,n,solutionSet,targetRow+1);
                }
                board[targetRow] = 0;
            }
        }else{
            if(ifNotInclude(solutionSet,board)) solutionSet.add(board.clone());
        }
    }

    /**
     * question 2 get next legal position from partal filled board
     * */

    public static int[] nextLegalPosition(int[] board, int n){
        int endRow = firstZero(board,n);
        board = getNextPosition(board,n,endRow);
        return board;
    }
    private static int[] getNextPosition(int[] board, int n, int targetRow){
        boolean keepCheck = true;
        while(targetRow > -1 && keepCheck){
            for(int position = board[targetRow]; position < n && keepCheck; position++){
                board[targetRow] = position + 1;
                if(isLegalPosition(board,n)){
                    keepCheck = false;
                }
            }
            if(keepCheck) {
                board[targetRow] = 0;
                getNextPosition(board,n,targetRow - 1);
            }
        }
        return board;
    }
    /**
     * question 3 get first legal position for n queens
     * */
    public static int[] firstLegalPosition(int n){
        ArrayList<int[]> result = getAllPosition(n);
        for(int[] solution: result){
            if(solution[n - 1] > 0) return solution;
        }
        return new int[n];
    }



}
