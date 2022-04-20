import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

    public static ArrayList<int[]> getRightPath(Matrix<Integer> rooms) {
        ArrayList<int[]> output = new ArrayList<>();
        Matrix<Integer> tracker = new Matrix<Integer>(rooms.xLength(),rooms.yLength());
        int rowLength = rooms.xLength();
        int rowAmount = rooms.yLength();

        //track through paths
        for(int row = 0; row < rowAmount; row++){
            for(int vault = 0; vault < rowLength; vault++){
                int currentValue = rooms.get(vault,row);
                int fromBack = -1;
                int fromLeft = -1;
                int fromRight = -1;
                if(row != 0){
                    fromBack = currentValue + rooms.get(vault,row - 1);
                    if(vault > 0) fromLeft = currentValue + rooms.get(vault - 1, row - 1);
                    if(vault < rowLength) fromRight = currentValue + rooms.get(vault + 1, row - 1);
                    currentValue = Math.max(fromBack,Math.max(fromLeft,fromRight));
                }
                tracker.set(vault,row,currentValue);
            }
        }

        //trace back
        Stack<int[]> backTrack = new Stack<int[]>();
        int topRow = rooms.yLength() - 1;
        int max = -1;
        int correctEndVault = 0;
        for(int vault = 0; vault < rowLength; vault++){
            int finalValue = tracker.get(vault,topRow);
            if(finalValue > max){
                max = finalValue;
                correctEndVault = vault;
            }
        }
        backTrack.push(new int[] {correctEndVault,topRow});
        for(int row = topRow - 1; row > -1; row--){
            int backTrackValue = tracker.get(correctEndVault,row+1) - rooms.get(correctEndVault,row+1);

            int leftBack = rooms.get(correctEndVault - 1, row);
            int rightBack = rooms.get(correctEndVault + 1, row);
            if(backTrackValue == leftBack && correctEndVault - 1 > 0){// if it's from left
                backTrack.push(new int[] {correctEndVault - 1, row});
                correctEndVault --;//go left one step
            }else if(backTrackValue == rightBack && correctEndVault + 1 < rowLength){// if it's from right
                backTrack.push(new int[] {correctEndVault + 1, row});
                correctEndVault ++;//go right one step
            }else{// if both not from left and right, it must be the back
                backTrack.push(new int[] {correctEndVault, row});
            }
        }

        //pop backTrack
        while(backTrack.size() > 0){
            output.add(backTrack.pop());
        }
        return output;
    }
}




