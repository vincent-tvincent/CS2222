import java.util.ArrayList;

public class main {
    public static void main(String args[]){
        int[] boardInfo = {1,2,3,4,5};
        int[] switchPoints = {0,2,4};
        gameBoard board = new gameBoard(boardInfo,switchPoints);
        ui game = new ui(true,board);
        game.run();
    }
}
