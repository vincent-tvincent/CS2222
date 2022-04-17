import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

public class solution{
    //question 3
    public static double[] solveEquation(Double[][] expressions){
        Matrix<Double> equations = new Matrix();
        equations.fillWith(expressions);
        int endLocation = expressions[0].length - 1;
        int equationAmount = expressions.length;
        System.out.println(equationAmount);
        double[] solution = new double[expressions.length];

        for(int row = 0; row < equationAmount - 1; row++){
            //move the row with largest xn coefficient up to place
            int maxRow = row;
            for(int nextRow = row + 1; nextRow < equationAmount; nextRow++){
                double maxXn = equations.get(row,maxRow);
                double currentXn = equations.get(row,nextRow);
                if(Math.abs(maxXn) < Math.abs(currentXn)) maxRow = nextRow;
            }
            equations.swapRow(row,maxRow);
            //cancel out xn
            for(int nextRow = row + 1; nextRow < equationAmount; nextRow++){
                double ratio = equations.get(row,nextRow) / equations.get(row,row);
//                System.out.println(equations.get(row,row) + " / " + equations.get(row,nextRow));
//                System.out.println("ratio: " + ratio);
                for(int value = endLocation; value > -1; value--){
                    double currentValue = equations.get(value,nextRow);
                    double cancelValue = equations.get(value,row) * ratio;
                    equations.set(value,nextRow,currentValue - cancelValue);
                }
            }
//            System.out.println("row: " + row);
//            System.out.println(equations.toString());
//            System.out.println();
        }



        //calculate final result
        double previousResult = 0;
        for(int row = equationAmount - 1; row > -1; row--){
            double result = equations.get(endLocation,row);
            for(int coefficient = 0; coefficient < endLocation; coefficient++){
                result -= solution[coefficient] * equations.get(coefficient,row);
            }
            solution[row] = result / equations.get(row,row);
        }
        return solution;
    }

    //question 2
    public static ArrayList<int[]> getRightPath(Matrix<Integer> rooms){
        ArrayList<int[]> output = new ArrayList();
        int maxGain = 0;
        //start from different points on the first Row
        for(int startPoint = 0; startPoint < rooms.xLength(); startPoint++){
            ArrayList<int[]> trackResult = new ArrayList();
            trackResult.add(new int[] {startPoint, 0});
            int gain = pathTracker(startPoint, 0, 0, rooms, output);
            if(gain > maxGain){
                maxGain = gain;
                output = trackResult;
            }
        }
        return output;
    }

    private static int pathTracker(int x, int y, int previousSum, Matrix<Integer> rooms, ArrayList<int[]> output){
        int sum = previousSum;
        sum += rooms.get(x,y);
        int aheadGain = sum;
        int leftGain = sum;
        int rightGain = sum;
        if(y + 1 < rooms.yLength()){
            aheadGain = pathTracker(x,y + 1, sum, rooms, output);
            if(x - 1 > -1) leftGain = pathTracker(x - 1, y + 1, sum, rooms, output);
            if(x + 1 < rooms.xLength())  rightGain = pathTracker(x + 1, y + 1, sum, rooms, output);
            sum = Math.max(aheadGain,Math.max(leftGain,rightGain));
            if(sum == aheadGain){
                output.add(new int[] {x,y + 1});
            }else if(sum == leftGain){
                output.add(new int[] {x - 1, y + 1});
            }else if(sum == rightGain){
                output.add(new int[] {x + 1, y + 1});
            }
        }
        return sum;
    }

}



