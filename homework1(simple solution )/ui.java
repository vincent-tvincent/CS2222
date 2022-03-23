import java.util.ArrayList;
import java.util.Scanner;

public class ui {
    gameBoard board;
    boolean playerTurn;
    computerPlayer enemy;
    public ui(boolean playerFirst, gameBoard theGameBoard){
        playerTurn = playerFirst;
        board = theGameBoard;
        enemy = new computerPlayer(board);
    }

    public void run(){
        System.out.println("game is ready to start :)");
        displayBoard();
        boolean keepRunning = true;
        while(keepRunning){
            if(board.ifWin(playerTurn) == -1){
                System.out.println("next round");
                doTake();
            }else if(board.ifWin(playerTurn) == 0){
                System.out.println("\ngame over\nplayer win");
                keepRunning = false;
            }else if(board.ifWin(playerTurn) == 1){
                System.out.println("\ngame over\ncomputer win");
                keepRunning = false;
            }
        }
    }

    private void displayBoard(){
        String output = "";
        for(int y = 0; y < board.getLayerAmount(); y++){
            for(int x = 0; x < board.getLayerLength(y); x++){
                if(board.isPlaced(x,y)){
                    output += "x ";
                }else{
                    output += board.getIcon(x,y) + " ";
                }
            }
            output += "\n";
        }
        System.out.println(output);
    }

    private void doTake(){
        if(playerTurn){
            HumanTake();
        }else{
            computerTake();
        }
    }

    private void HumanTake(){
        System.out.println("your turn");
        Scanner input = new Scanner(System.in);
        boolean keepAsking = true;
        while(keepAsking){
            displayBoard();
            System.out.print("which icon do you want to take?: ");
            int iconType = input.nextInt();
            System.out.print("\n how many do you want to take?: ");
            int takeAmount = input.nextInt();
            System.out.println();
            if(board.canTake(iconType,takeAmount)){
                board.take(iconType,takeAmount);
                keepAsking = false;
                displayBoard();
                System.out.println("computer's turn");
            }else{
                System.out.println("this icon does not exist or do not have enough amount");
            }
        };
        playerTurn = !playerTurn;
    }

    private void computerTake(){
        enemy.take();
        playerTurn = !playerTurn;
    }
}
