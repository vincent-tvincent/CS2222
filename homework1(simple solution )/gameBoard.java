import java.util.ArrayList;
import java.util.Arrays;

public class gameBoard {
    private ArrayList<int[]> board;
    private ArrayList<boolean[]> boardStatus;
    private int layerAmount;
    private int totalAmount;
    private int[] iconAmount;
    private int[][] iconStartPoint; //if take next some type icon, take from the start point
    public gameBoard(int[] layerInfo, int[] switchToNextIcon){
        layerAmount = layerInfo.length;
        for(int amount: layerInfo) totalAmount += amount;
        iconStartPoint = new int[switchToNextIcon.length][2];
        for(int icon = 0; icon < iconStartPoint.length; icon++){
            iconStartPoint[icon][0] = 0;
            iconStartPoint[icon][1] = switchToNextIcon[icon];
        }
        iconAmount = new int[iconStartPoint.length];
        board = new ArrayList<>();
        boardStatus = new ArrayList<>();
        int currentIcon = -1;
        int switchPoint = 0;
        for(int layer = 0; layer < layerAmount; layer++){
            if(layer == switchToNextIcon[switchPoint]){
                currentIcon++;
                switchPoint++;
            }
            iconAmount[currentIcon] += layerInfo[layer];
            board.add(new int[layerInfo[layer]]);
            boardStatus.add(new boolean[layerInfo[layer]]);
            Arrays.fill(board.get(layer),currentIcon);
            Arrays.fill(boardStatus.get(layer),false);
        }
        for(int i: iconAmount) System.out.print(i + " ");
        System.out.println();
    }


    public void printBoard(){
        for(int[] layer: board){
            for(int icon: layer){
                System.out.print(icon + " ");
            }
            System.out.println();
        }
    }

    public void printBoardStatus(){
        for(boolean[] layer: boardStatus){
            for(boolean icon: layer){
                System.out.print(icon + " ");
            }
            System.out.println();
        }
    }

    public int getIcon(int x, int y){
        return board.get(y)[x];
    }

    public int getLayerAmount() {return layerAmount;}
    public int getLayerLength(int y) {return board.get(y).length;}
    public int[] getIconInfo(){return iconAmount;}
    public int getIconAmount(int iconType){
        int amount;
        if(iconType < iconAmount.length){
            amount = iconAmount[iconType];
        }else{
            amount = -1;
        }
        return amount;
    }

    public boolean canTake(int iconType,int takeAmount){
        return getIconAmount(iconType) > 0 && getIconAmount(iconType) >= takeAmount;
    }

    public void take(int iconType,int amount){
        if(iconAmount[iconType] >= amount){
            for(int take = 0; take < amount; take++){
                //update the start point of this icon
                int x = iconStartPoint[iconType][0];
                int y = iconStartPoint[iconType][1];
                place(x,y);
                if(x < board.get(y).length - 1){
                    iconStartPoint[iconType][0] ++;
                }else{
                    iconStartPoint[iconType][1] ++;
                    iconStartPoint[iconType][0] = 0;
                }
            }
            iconAmount[iconType] -= amount;
            totalAmount -= amount;
        }

    }

    private void place(int x,int y){
        boardStatus.get(y)[x] = true;
    }
    public int ifWin(boolean playerTurn){
        if(totalAmount == 0){//if previous player take the last step
            if(playerTurn){
                return 1;
            }else{
                return 0;
            }
        }else{//the game should go ahead
            return -1;
        }
    }
    public boolean isPlaced(int x, int y){
        return boardStatus.get(y)[x];
    }
}
