import java.util.ArrayList;
import java.util.Arrays;

public class solutions {
    //question1
    public static boolean isLegalPosition(int[] board, int n){
        boolean result = true;
        ArrayList<Integer> occupied = new ArrayList();
        occupied.add(board[0]);
        for(int col = 1; col < n && result; col++){
            int occupiedSize = occupied.size();
            for(int backCheckPoint = 0; backCheckPoint < occupiedSize && result; backCheckPoint++){
                int occupiedPoint = occupied.get(backCheckPoint) + 1;
                if(occupiedPoint == board[col]) result = false;
                occupied.set(backCheckPoint,occupiedPoint);
                occupied.add(board[col]);
            }
        }
        return result;
    }
    //question2
    public static int[] nextLegalPosition(int[] board,int n){
        ArrayList<Integer> occupied = new ArrayList();
        occupied.add(board[0]);
        int nextCol = 0;
        for(int col = 1; board[col] > 0; col++){
            int occupiedSize = occupied.size();
            for(int backCheckPoint = 0; backCheckPoint < occupiedSize; backCheckPoint++){
                int occupiedPoint = occupied.get(backCheckPoint) + 1;
                occupied.set(backCheckPoint,occupiedPoint);
                occupied.add(board[col]);
            }
            nextCol++;
        }
        int nextPosition = 0;
        boolean keepSearch = true;
        for(int point = 1; point < n + 1 && keepSearch; point++){
            boolean vaild = true;
            for(int occupiedPoint: occupied){
                if(occupiedPoint == point) vaild = false;
            }
            nextPosition++;
            keepSearch = !vaild;
        }
            board[nextCol] = nextPosition;
            return board;
    }

}
