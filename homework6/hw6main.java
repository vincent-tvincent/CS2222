import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

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
        boolean question4 = false;
        if(question3){
            int[] result = solutions.findNextSolution(8);
            System.out.println("question3 \n the first set of legal positions is: ");
            for(int position : result) System.out.print(position + " ");
            System.out.println("");
        }
        if(question4){

        }

    }
}
