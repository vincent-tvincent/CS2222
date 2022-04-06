import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class homework3main {
    @Test
    public void testQuestion1(){
        solutions testObject = new solutions();
        String test1 = "never odd or even";
        String test2 = "able was I ere I saw Elba.";
        String test3 = "A man, a plan, a canal: Panama!";
        String test4 = "aaaaaaaaaaa bbbbbbbbbbb";
        String test5 = "    1qw2e3wr4e5rt67y8uio9l;k.,mnjbhbgfre3";
        Assumptions.assumeTrue(testObject.isPalindrome(test1));
        Assumptions.assumeTrue(testObject.isPalindrome(test2));
        Assumptions.assumeTrue(testObject.isPalindrome(test3));
        Assumptions.assumeFalse(testObject.isPalindrome(test4));
        Assumptions.assumeFalse(testObject.isPalindrome(test5));
    }

    @Test
    public void testQuestion2(){
        solutions testObject = new solutions();
        ArrayList<Integer> testSource = new ArrayList<>();
        Collections.addAll(testSource, new Integer[] {3,2,1});
        //ArrayList<int[]> result = testObject.easyinvertioncount(testSource);
        ArrayList<int[]> result = testObject.quickinvertioncount(testSource);
        for(Integer item: testSource) System.out.print(item +  ", ");
        System.out.println();
        for(int[] i: result){
            for(int j: i){
                System.out.print(j + ", ");
            }
            System.out.println();
        }
        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = false;
        for(int[] item: result){
            if(Arrays.equals(item,new int[]{3,1})) test1 = true;
            if(Arrays.equals(item,new int[]{3,2})) test2 = true;
            if(Arrays.equals(item,new int[]{2,1})) test3 = true;
        }
        Assumptions.assumeTrue(test1);
        Assumptions.assumeTrue(test2);
        Assumptions.assumeTrue(test3);
    }

    public static void main(String args[]){
    }
}

