import java.text.DecimalFormat;
import java.util.ArrayList;

public class hw2main {
    public static void main(String args[]){
        //question 1 (also question 2.1)
        System.out.println("question 1");
        System.out.println("all the first 40th Lucas number: ");
        for(int n = 0; n < 40; n++) {
            System.out.print(LucasNumber.getLucasNumber(n) + " ");
            if(n%10 == 0 && n != 0) System.out.println();
        }
        System.out.println();

        //question 2
        System.out.println("question 2");
        System.out.println("the growth of execution time: ");
        Long[] executionTimes = new Long[40];
        //question2.2
        for(int n = 0; n < 40; n++) {
            Long startTime = System.nanoTime();
            LucasNumber.getLucasNumber(n);
            Long endTime = System.nanoTime();
            executionTimes[n] = endTime - startTime;
        }
        for(int i = 1; i < executionTimes.length; i++){
            System.out.print((executionTimes[i] - executionTimes[i - 1]) + " ");
            if(i%10 == 0 && i != 0) System.out.println();
        }
        System.out.println();
//        for(int i = 1; i < executionTimes.length; i++){
//            System.out.print(i  + "," + (executionTimes[i] - executionTimes[i - 1])  + ", \"r*\", ");
//        }
        // from the data collected, i notice it's an exponential growth program

        //question2.3
        System.out.println("mySequence");
        for(int n = 0; n < 40; n++) {
            Long startTime = System.nanoTime();
            LucasNumber.mySequence(n);
            Long endTime = System.nanoTime();
            executionTimes[n] = endTime - startTime;
        }
        for(int i = 1; i < executionTimes.length; i++){
            System.out.print((executionTimes[i] - executionTimes[i - 1]) + " ");
            if(i%10 == 0 && i != 0) System.out.println();
        }
        System.out.println();
//        for(int i = 1; i < executionTimes.length; i++){
//            System.out.print(i  + "," + (executionTimes[i] - executionTimes[i - 1])  + ", \"r*\", ");
//        }
        // this is also an exponiental growth program
        System.out.println();

        //question3.1/3.2
        System.out.println("question3.1 and question 3.2");
        SubirachsSquire testObject2 = new SubirachsSquire();
        Integer[][] testValue = {{1,14,14,4},{11,7,6,9},{8,10,10,5},{13,2,3,15}};
        testObject2.fillWith(testValue);
        ArrayList<int[]> output = testObject2.getAllCombinationsOfNElements(4);

        int count = 0;
        for(int[] value: output){
            System.out.print("{ ");
            for(int number: value) System.out.print(number + ",");
            System.out.print(" } ");
            if(count == 10){
                System.out.println();
                count = 0;
            }else{
                count++;
            }
        }
    }
}
