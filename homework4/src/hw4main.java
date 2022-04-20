import java.util.ArrayList;

public class hw4main {
    public static void main(String[] args){
        boolean question1 = false;
        boolean question2 = true;
        if(question1){
            double[] testResult = solution.solveEquation(new Double[][]
                    {
                            { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 122.0},
                            { 1.0, 1.0, 1.0, 1.0, 1.0,-1.0,-1.0,-1.0,-1.0,-88.0},
                            { 1.0,-1.0, 1.0,-1.0, 1.0,-1.0, 1.0,-1.0, 1.0, 32.0},
                            { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0},
                            { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 7.0},
                            { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 18.0},
                            { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 76.0},
                            { 1.0, 1.0,-1.0, 1.0, 1.0,-1.0, 1.0, 1.0,-1.0, 0.0},
                            { 9.0,-8.0, 7.0,-6.0, 5.0,-4.0, 3.0,-2.0,-1.0, 41.0}

                    });
//        double[] testResult = solution.solveEquation(new Double[][]
//                {       {1.0,1.0,1.0,6.0},
//                        {1.0,1.0,2.0,9.0},
//                        {1.0,2.0,3.0,14.0}
//                });
            System.out.println("the solutions in decimals: ");
            for(double value: testResult) System.out.printf(value + " ");
            System.out.println("round the solutions to integers: ");
            for(double value: testResult) System.out.printf(Math.round(value) + " ");
            System.out.println();
        }if (question2) {
            Matrix<Integer> testRoom = new Matrix();
            testRoom.fillWith(new Integer[][] {
                    {66, 82, 97, 20, 21, 35, 52, 95},
                    {73, 78, 37, 23, 50, 14, 5 , 40},
                    {16, 31, 4 , 63, 25, 32, 42, 17},
                    {93, 13, 71, 48, 15, 81, 11, 89},
                    {67, 22, 92, 68, 12, 56, 65, 47},
                    {30, 64, 51, 27, 7 , 91, 94, 83},
                    {54, 46, 24, 90, 77, 10, 41, 1 },
                    {99, 98, 70, 74, 84, 96, 33, 44}

            });

//            testRoom.fillWith(new Integer[][]{
//                    {10, 9 , 8 , 0 , 0 , 0 , 6 , 11},
//                    {10, 9 , 8 , 0 , 0 , 0 , 6 , 11},
//                    {10, 9 , 8 , 0 , 0 , 0 , 6 , 11},
//                    {10, 9 , 8 , 0 , 0 , 0 , 6 , 11},
//                    {10, 9 , 8 , 0 , 0 , 0 , 6 , 11},
//                    {10, 9 , 8 , 0 , 0 , 0 , 6 , 11},
//                    {10, 9 , 8 , 0 , 0 , 0 , 6 , 11},
//                    {10, 9 , 8 , 0 , 10000 , 0 , 6 , 11},
//            });
            ArrayList<int[]> testResult = solution.getRightPath(testRoom);
            int count = 0;
            System.out.println("the path is: ");
            for(int[] coordinate: testResult){
                if(count == 8){
                    System.out.println();
                    count = 0;
                };
                System.out.printf(coordinate[0] + "," + coordinate[1] + " → ");
            }

        }


    }
}
