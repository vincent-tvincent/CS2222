package gameBoard;

import java.util.Arrays;

public class board {
    private class layer{
        private class block{
            public boolean isPlaced;
            public int iconType;
            public block(int type){
                isPlaced = false;
                iconType = type;
            }
            public int getIconType(){return iconType;}
        }
        private int length;
        private block[] Layer;
        public layer(int l){
            length = l;
            Layer = new block[length];
        }
        public void setIcon(int x,int type){Layer[x] = new block(type);}
        public void place(int x){Layer[x].isPlaced = true;}
        public boolean ifPlaced(int x){return Layer[x].isPlaced;}
        public int getIcon(int x){return Layer[x].iconType;}
    }
    private layer[] Board;
    private int[] iconInfo;
    private int totalNum;
    private boolean playerTurn;

    /**
     * initialize a board
     * @param playerFirst
     * @param iconInfo
     */
    public board(boolean playerFirst,int[] iconInfo){
        Board = new layer[0];
        this.iconInfo = iconInfo;
        playerTurn = playerFirst;
        for(int amount: iconInfo){
            totalNum += amount;
        }
    }
    public boolean getStatus(int x, int y){return Board[y].ifPlaced(x);}
    public int getIcon(int x, int y){return Board[y].getIcon(x);}
    public int getIconInfo(int icon){
        return iconInfo[icon];
    }
    /**
     * @param layoutInfo
     * consume an int array, which represent the length of each layer (layoutInfo[layer1, layer2, ...]) and initialize the board
     */
    public void createBoard(int[] layoutInfo){
        Board = new layer[layoutInfo.length];
        int currentIcon = 0;
        int iconCount = 0;
        int x = 0; //layer
        int y = 0; //block
        Board[y] = new layer(layoutInfo[y]);
        while(y < layoutInfo.length){
            if(x < layoutInfo[y]){// if this layer is finished
                if(iconCount == iconInfo[currentIcon]) {
                    currentIcon++;
                    iconCount = 0;
                }
                Board[y].setIcon(x,currentIcon);
                iconCount++;
                x++;
            }else{//start place next layer
                y++;
                if(y != layoutInfo.length) Board[y] = new layer(layoutInfo[y]);
                x = 0;
            }
        }
    }
    public boolean isPlayerTurn(){return playerTurn;}
    public int getWin(){
        System.out.println("total icon: " + totalNum);
        if(totalNum == 0){//if previous player take the last step
            if(playerTurn){
                return 1;
            }else{
                return 0;
            }
        }else{//the game should go ahead
            return -1;
        }
    }
    public void place(int x, int y){
        Board[y].place(x);
        totalNum --;
    }
    private String boardToString(){
        int x = 0;
        int y = 0;
        String result = "";
        while(y < Board.length){
             if(x < Board[y].length){
                 result += getIcon(x,y) + " ";
             }else{
                 result += "\n";
                 if(y != Board.length) y++;
                 x = 0;
             }
        }
        return result;
    }
    @Override
    public String toString() {
        return "board{" +
                "board=" + boardToString() +
                ", \niconInfo=" + Arrays.toString(iconInfo) +
                ", totalNum=" + totalNum +
                ", playerTurn=" + playerTurn +
                '}';
    }
}
