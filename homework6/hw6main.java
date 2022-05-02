import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class hw6main {
    //question1 test
    @Test
    public void testQuestion1(){
        int n = 8;
        int[] Board1 = {1,6,8,3,7,4,2,5};
        int[] Board2 = {1,6,8,3,5,0,0,0};
        Assumptions.assumeTrue(solutions.isLegalPosition(Board1,n));
        Assumptions.assumeFalse(solutions.isLegalPosition(Board2,n));
    }
    @Test
    public void testQuestion2(){
        int[] board = {1,6,8,3,0,0,0,0};
        int[] result = solutions.nextLegalPosition(board,8);
        for(int i: result) System.out.print(i + " ");
        Assumptions.assumeTrue(solutions.isLegalPosition(result,8));
    }
    public static void main(String args[]){
        boolean question3 = false;
        boolean question4 = true;
        if(question3){
            System.out.println("question3");
            for(int n = 4; n < 14; n++){
                System.out.println("now the n value is: " + n);
                int[] result = solutions.findFirstSolution(n);
                System.out.println("the first set of legal positions is: ");
                for(int position : result) System.out.print(position + " ");
                System.out.println();
            }
        }
        if(question4){
            ArrayList<int[]> result = solutions.findAllSolution(4);
            for(int[] positions: result){
                for(int position: positions) System.out.print(position + " ");
                System.out.println();
            }
        }
    }
}
