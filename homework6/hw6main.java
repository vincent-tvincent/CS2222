import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class hw6main {
    @Test
    public void testQuestion1Part1(){
        int n = 8;
        int[] Board1 = {1,6,8,3,7,4,2,5};
        int[] Board2 = {1,6,8,3,5,0,0,0};
        Assumptions.assumeTrue(solutions.isLegalPosition(Board1,n));
        Assumptions.assumeFalse(solutions.isLegalPosition(Board2,n));
    }
    public static void main(String args[]){
    }
}
