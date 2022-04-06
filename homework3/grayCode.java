import java.util.ArrayList;
import java.util.Collections;
/**
 * question 3.1 and bonus implementation
 */
public class grayCode{
    ArrayList<Integer> grayCodeTable;
    private int iterate;
    private int order;
    private int nextPointer;
    public grayCode(int order) {
        grayCodeTable = new ArrayList<>();
        Collections.addAll(grayCodeTable, new Integer[]{0, 1});
        nextPointer = 0;
        this.order = order;
        iterate = 1;
    }
        /**
         * BRGC algorithm
         * @param n request for nth  gray code of preset orders
         * @return an int array represent the status of every element in the set
         */
    public int[] getNthSubSetStatus(int n){
        int[] subSet = new int[order];
        int grayCode = -1;
        while(grayCodeTable.size() - 1 < n){
            int startPoint = grayCodeTable.size();
            for(int i = 0; i < startPoint; i++){
                int nextNumber = grayCodeTable.get(i);
                grayCodeTable.add(startPoint,nextNumber + (1 << iterate)); //flip and add one
            }
            iterate ++;
        }
        grayCode = grayCodeTable.get(n); // to array
        for(int id = 0; id < order; id++){
            int status = grayCode % 2;
            subSet[id] = status;
            grayCode /= 2;
        }
        return subSet;
    }

    public int[] getNextGrayCode(){
        int[] result = getNthSubSetStatus(nextPointer);
        nextPointer ++;
        return result;
    }

    public void nextReset(){ nextPointer = 0; }
}

