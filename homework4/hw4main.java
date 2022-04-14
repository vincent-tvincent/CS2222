public class hw4main {
    public static void main(String[] args){
        double[] testResult = solution.solveEquation(new Double[][]
                        {{1.0,1.0,1.0,6.0},
                         {1.0,1.0,2.0,9.0},
                         {1.0,2.0,3.0,14.0}});
        for(double value: testResult) System.out.printf(value + " ");
        System.out.println();
    }

}
