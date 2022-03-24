public class computerPlayer {
    gameBoard board;
    public computerPlayer(gameBoard theBoard){
        board = theBoard;
    }



    public void take(){
        int[] iconAmount = board.getIconInfo();
        int maxIcon = 0;
        int maxIconNum = 0;
        for(int i = 0; i < iconAmount.length; i++){
            if(iconAmount[i] > maxIconNum){
                maxIconNum = iconAmount[i];
                maxIcon = i;
            }
        }
        int xorSum = -1;
        for(int currentIcon = 0; currentIcon < iconAmount.length; currentIcon++){
            if(currentIcon != maxIcon){
                if(xorSum < 0){
                    xorSum = iconAmount[currentIcon];
                }else{
                    xorSum = xorSum^iconAmount[currentIcon];
                }
            }
        }
        int xorResult = xorSum^maxIconNum;
        if(xorResult == 0){
            int takeAmount = (int) Math.random() * maxIconNum + 1;
            System.out.println("computer take " + maxIcon + "he take " + takeAmount + " of it");
            board.take(maxIcon,takeAmount);
        }else{
            int takeAmount = maxIconNum - xorSum;
            System.out.println("computer take " + maxIcon + "he take " + takeAmount + " of it");
            board.take(maxIcon,takeAmount);
        }
    }
}
