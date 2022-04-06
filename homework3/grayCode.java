import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class grayCode{
    ArrayList<Integer> grayCodeTable;
    private int iterate;
    private int order;
    private int nextPointer;
    private boolean addOne;
    public grayCode(int order){
        grayCodeTable = new ArrayList<>();
        Collections.addAll(grayCodeTable,new Integer[]{0,1});
        nextPointer = 0;
        this.order = order;
    }

    public int[] getNthSubSetStatus(int n){
        int[] subSet = new int[order];
        int grayCode = -1;

        if(grayCodeTable.size() - 1 < n){
            int startPoint = grayCodeTable.size();
            for(Integer i: grayCodeTable){
                grayCodeTable.add(startPoint,i);
                if(addOne){
                    int code = grayCodeTable.get(startPoint);
                    grayCodeTable.set(startPoint,code + (int)Math.pow(2,iterate));
                    addOne = !addOne;
                    iterate *= 2;
                }
            }
        }
        grayCode = grayCodeTable.get(n);

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
}

