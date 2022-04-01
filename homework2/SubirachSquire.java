import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SubirachSquire {
    Matrix<Integer> body;
    int sum;
    public SubirachSquire(){
        sum = 33;
        body = new Matrix<>();
        body.fillWith( new Integer[][]{ {1 ,14,14,4 },
                                        {11,7 ,6 ,9 },
                                        {8 ,10,10,5 },
                                        {13,2 ,3 ,15}});
    }
    //question 1
    public int getAllFourCombination(){
        int totalSetAmount = 0;
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for(int pivit1 = 0; pivit1 < body.size(); pivit1++){
            for(int pivit2 = pivit1+1; pivit2 < body.size(); pivit2++){
                for(int pivit3 = pivit2+1; pivit3 < body.size(); pivit3++){
                    for(int pivit4 = pivit3+1; pivit4 < body.size(); pivit4++){
                        int currentSum = 0;
                        currentSum = body.get(pivit1) + body.get(pivit2) + body.get(pivit3) + body.get(pivit4);
                        if(currentSum == sum) output.add(new ArrayList<Integer>(Arrays.asList(body.get(pivit1),body.get(pivit2),body.get(pivit3),body.get(pivit4))));
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> filtRepeat = new ArrayList<>();
        for(ArrayList<Integer> item: output){
            if(!filtRepeat.contains(item)){
                filtRepeat.add(item);
            }
        }
        totalSetAmount = filtRepeat.size();
        return totalSetAmount;
    }

    //question 2
    private void getAllPossibleSubsets(int elements, int size, ArrayList<Integer> output){
        if(size > 0){
            if(elements > 0){
                output.add(1);
                getAllPossibleSubsets(elements - 1, size - 1,output);
            }
            output.add(0);
            getAllPossibleSubsets(elements,size-1,output);
        }
    }

    public int getAllCombinationsBellowFour(){
        int totalSetNum = 0;
        for(int size = 1; size < 5; size++){
            ArrayList<Integer> include = new ArrayList<>();
            getAllPossibleSubsets(size,body.size(),include);
            int bias = 0;
            int currentSum = 0;
            for(int i = 0; i < include.size(); i++){
                if(include.get(i) == 1)currentSum += body.get(i-bias);
                if(i != 0  & i % (body.size() - 1) == 0){
                    bias += body.size() - 1;
                    if(currentSum == sum) totalSetNum ++;
                    currentSum = 0;
                };
            }
        }
        return totalSetNum;
    }

    //question 3 get all combination of the specific sum
    private boolean[] binaryToSet(int setSize,int value){
        boolean[] output = new boolean[setSize];
        int index = 0;
        while(value != 0){
            if(value % 2 == 1){
                output[index] = true;
            }else{
                output[index] = false;
            }
            index++;
            value /= 2;
        }
        return output;
    }
    public int getAllCombinationToSameSumNumber(){
        int totalSetAmount = 0;
        int fullSet = 0;
        for(int power = 0; power < body.size(); power++) fullSet += Math.pow(2,power);
        for(int set = 0; set < fullSet; set++){
            int currentSum = 0;
            boolean[] isInclude = binaryToSet(body.size(),set);
            for(int i = 0; i < body.size(); i++){
                if(isInclude[i]) currentSum += body.get(i);
            }
            if(currentSum == sum) totalSetAmount ++;
        }
        return totalSetAmount;
    }

    //question 4 get all sums
    private int getSumAmount(int sum){
        int totalSetAmount = 0;
        int fullSet = 0;
        for(int power = 0; power < body.size(); power++) fullSet += Math.pow(2,power);
        for(int set = 0; set < fullSet; set++){
            int currentSum = 0;
            boolean[] isInclude = binaryToSet(body.size(),set);
            for(int i = 0; i < body.size(); i++){
                if(isInclude[i]) currentSum += body.get(i);
            }
            if(currentSum == sum) totalSetAmount ++;
        }
        return totalSetAmount;
    }
    public int getAllSumAmount(){
        int totalSetAmount = 0;
        int max = 0;
        int stop = body.size();
        while(stop > 0){
            max += body.next(true);
            stop --;
        }
        body.nextBackToStart();

        for(int sum = 0; sum < max; sum++){
            totalSetAmount += getSumAmount(sum);
        }
        return totalSetAmount;
    }


}

