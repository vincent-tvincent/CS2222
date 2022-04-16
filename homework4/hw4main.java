public class hw4main {
    public static void main(String[] args){
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
        for(double value: testResult) System.out.printf(value + " ");
        System.out.println();
        for(double value: testResult) System.out.printf(Math.round(value) + " ");
        System.out.println();
    }

}
