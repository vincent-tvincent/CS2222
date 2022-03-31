import java.util.ArrayList;
import java.util.ArrayDeque;

public class SubirachsSquire extends Matrix<Integer> {
    private class coordinate{
        public int x;
        public int y;
        public coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public SubirachsSquire(){
        super();
    }

    public ArrayList<int[]> getAllCombinationsOfNElements(int combinationSize){
         ArrayList<int[]> output = new ArrayList<>();
         ArrayDeque<coordinate> currentPivit = new ArrayDeque<>();
         return output;
    }
}
