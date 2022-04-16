import java.math.BigDecimal;

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
            System.out.println("row: " + row);
            System.out.println(equations.toString());
            System.out.println();
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
}

//question 2
