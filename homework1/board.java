public class board {
    private class layer{
        public int icon;
        public int length;
        private boolean[] placed;
        public layer(int i, int l){
            icon = i;
            length = l;
            placed = new boolean[length];
            for(int j = 0; j < length; j++){
                placed[j] = false;
            }
        }
    }
    private layer[] board;
    private int[] iconInfo;
    private int totalNum;
    private boolean playerTurn;

    public board(boolean playerFirst,int[] iconInfo){
        this.iconInfo = iconInfo;
        playerTurn = playerFirst;
        for(int amount: iconInfo){
            totalNum += amount;
        }
    }

    public void initAsTriangleBoard(){
        int layerLength = 1;
        int icon = 0;
        int iconAmount = iconInfo[icon];
        while(icon < iconInfo.length){
            board[layerLength - 1] = new layer(icon,layerLength);
            layerLength++;
            iconAmount--;
            if(iconAmount == 0){
                icon++;
                iconAmount = iconInfo[icon];
            }
        }
    }

    public void placeStep(int x,int y){
        board[y].placed[x] = true;
        playerTurn = !playerTurn;
        totalNum --;
    }

    public int getWin(){
        if(totalNum == 0){
            if(playerTurn){
                return 0;
            }else{
                return 1;
            }
        }else{
            return -1;
        }
    }
}
