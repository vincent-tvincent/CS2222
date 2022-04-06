import java.util.ArrayList;

public class solutions {
    /**
     * question 1: isPalindrome
     *
     * @param text the string going to be check
     **/
    public boolean isPalindrome(String text) {
        boolean result = false;
        int leftPointer = 0;
        int rightPointer = text.length() - 1;
        boolean keepCheck = true;
        while (leftPointer < rightPointer && keepCheck) {
            char Left = text.charAt(leftPointer);
            char Right = text.charAt(rightPointer);
            //skip non-character and cast them all to upper case
            while(!(Left > 96 && Left < 123)){
                if(Left > 64 && Left < 91){
                    Left += 32;
                }else{
                    leftPointer ++;
                    Left = text.charAt(leftPointer);
                }
            }

            while(!(Right > 96 && Right < 123)){
                if(Right > 64 && Right < 91){
                    Right += 32;
                }else{
                    rightPointer --;
                    Right = text.charAt(rightPointer);
                }
            }
            //check
            keepCheck = Left == Right;
            result = keepCheck;
            leftPointer++;
            rightPointer--;
        }
        return result;
    }

    //question2.1
    public ArrayList<int[]> easyinvertioncount(ArrayList<Integer> source){
        ArrayList<int[]> output = new ArrayList<>();
        for(int i = 0; i < source.size();i++){
            for(int j = i + 1; j < source.size(); j++){
                int iValue = source.get(i);
                int jValue = source.get(j);
                if(iValue > jValue){
                    output.add(new int[] {iValue, jValue});
                }
            }
        }
        return output;
    }

    //question2.2
//    public ArrayList<int[]> quickinvertioncount(ArrayList<Integer> source){
//        ArrayList<int[]> output = new ArrayList<>();
//        quickinvertionCheck(output,source,0,source.size() - 1);
//        return output;
//    }

//    private void quickinvertionCheck(ArrayList<int[]> result,ArrayList<Integer> source, int start, int end){
//        if(start < end){
//            int Left = start;
//            int Right = start;
//            int midPointValue = source.get(end);
//            while(Right < end){
//                int RightValue = source.get(Right);
//                if(RightValue > midPointValue){
//                    Left++;
//                    result.add(new int[] {RightValue,midPointValue});
//                    int tempLeft = source.get(Left);
//                    source.set(Left,RightValue);
//                    source.set(Right,tempLeft);
//                }
//                Right++;
//            }
//            source.add(Left + 1,midPointValue);
//            source.remove(end + 1);
//            quickinvertionCheck(result, source, Left + 1, end);
//            quickinvertionCheck(result, source, start, Left - 1);
//        }
//    }

    public ArrayList<int[]> quickinvertioncount(ArrayList<Integer> source){
        ArrayList<int[]> output = new ArrayList<>();
        ArrayList<Integer> out = quickinvertionCheck(source,output,0,source.size());
        for(Integer i: out){
            System.out.printf(i + ", ");
        }
        System.out.println();
        return output;
    }
    private ArrayList<Integer> quickinvertionCheck(ArrayList<Integer> source, ArrayList<int[]> output,int start, int end){
        ArrayList<Integer> sorted = new ArrayList<>();
        int split = (end - start)/2 + start;
        if(end - start > 1){
            ArrayList<Integer> leftHalf = quickinvertionCheck(source,output,start,split);
            ArrayList<Integer> rightHalf = quickinvertionCheck(source,output,split,end);
            int leftPivit = leftHalf.size() - 1;
            int rightPivit = rightHalf.size() - 1;
            boolean ignore = true;
            while(leftPivit > -1 || rightPivit > -1){
                if(leftPivit < 0){
                    if(ignore){
                        ignore = false;
                    }else{
                        for(int leftNumber: leftHalf) output.add(new int[] {leftNumber, rightHalf.get(rightPivit)});
                    }
                    sorted.add(0,rightHalf.get(rightPivit));
                    rightPivit --;
                }else if(rightPivit < 0){
                    sorted.add(0,leftHalf.get(leftPivit));
                    leftPivit --;
                }else{
                    if(leftHalf.get(leftPivit) > rightHalf.get(rightPivit)){
                        output.add(new int[] {leftHalf.get(leftPivit),rightHalf.get(rightPivit)});
                        sorted.add(0,leftHalf.get(leftPivit));
                        leftPivit --;
                    }else{
                        sorted.add(0,rightHalf.get(rightPivit));
                        rightPivit --;
                    }
                }
            }
        }else{
            sorted.add(0,source.get(start));
        }
        return sorted;
    }

}