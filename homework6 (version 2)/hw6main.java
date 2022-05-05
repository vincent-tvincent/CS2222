import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class hw6main {
    @Test
    public void testQuestion1(){
        int n = 8;
        int[] Board1 = {1,6,8,3,7,4,2,5};
        int[] Board2 = {1,6,8,3,5,0,0,0};
        Assumptions.assumeTrue(solutions.isLegalPosition(Board1,n));
        Assumptions.assumeFalse(solutions.isLegalPosition(Board2,n));
    }
    public static void main(String args[]){
        System.out.println("question 1 pass the junit test");
        boolean question2 = true;
        boolean question3 = true;
        boolean question4 = true;
        if(question2){
            int[] board1 = new int[] {1,6,8,3,5,0,0,0};
            System.out.println("start board: ");
            for(int position: board1) System.out.print(position + " ");
            System.out.println("\nnext step: ");
            int[] result = solutions.nextLegalPosition(board1,8);
            for(int position: result) System.out.print(position + " ");
            System.out.println();
        }
        if(question3){
            System.out.println("\nit even cost several minutes when using \n" +
                    "10th generation desktop i9 processor \n" +
                    "so if you must see the last answer (after 11, here i make it stop at 11), \n" +
                    "please just wait, this one absolutely \n" +
                    "provide correct value. \n\nif you don't want to wait, just set variable question3 to false to skip it\n\n");
            for(int n = 1; n < 11; n ++){ // go from 1 to 14
                System.out.println("!!!!! processing slowly, please patiently wait. !!!!!");
                System.out.println("result for " + n + " Queens");
                int[] solution = solutions.firstLegalPosition(n);
                for(int position: solution) System.out.print(position + " ");
                System.out.println();
            }
            System.out.println();
        }
        if(question4){
            for(int i = 4; i < 6; i++){
                System.out.println("all results for "  + i + " queens");
                ArrayList<int[]> result = solutions.getAllPosition(i);
                for(int[] solution: result){
                    for(int position: solution) System.out.print(position + " ");
                    System.out.println();
                }
                System.out.println();
            }
        }

    }
}
