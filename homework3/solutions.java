import java.util.ArrayList;

public class solutions {
    /**
     * question 1: isPalindrome
     *
     * @param text the string going to be check
     * @return boolean value represent if the string is a palindrome
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

    /**
     * question 2.1
     * @param source the list going to be check
     * @return a ArrayList of int pairs in array type of the inversion pairs
     */
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

    /**
     * question 2.2
     * @param source the list going to be check
     * @return a ArrayList of int pairs in array type of the inversion pairs
     */
    public ArrayList<int[]> quickinvertioncount(ArrayList<Integer> source){
        ArrayList<int[]> output = new ArrayList<>();
        ArrayList<Integer> out = quickinvertionCheck(source,output,0,source.size());
        for(Integer i: out){
            System.out.printf(i + ", ");
        }
        System.out.println();
        return output;
    }
    //the helper function of question2.2, the implement of checking is here
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

    /** question 3.1 and bonus was implemented in grayCode file **/

    /**
     * question 3.2
     * @param members all the members in the Klutzomaniac
     * @param n request for the Join or Leave information till the nth order
     * @return The String array record the changes on the set
     */
    public String[] getJoinOrLeaveSequence(String[] members, int n){
        String[] output = new String[n];
        grayCode graycode = new grayCode(members.length);
        if(n > 0){
            for(int code = 0; code < n; code++){
                int[] previousStatus = graycode.getNthSubSetStatus(code);
                int[] currentStatus = graycode.getNthSubSetStatus(code + 1);
                for(int id = 0; id < members.length; id++){
                    if(previousStatus[id] != currentStatus[id]) output[code] = members[id];
                }
            }
        }else{
            output = new String[] {"N/A"};
        }
        return output;
    }

    /**
     * question3.3
     *
     * @return an arrayList of String array that represent all subSets of this Klutzomaniac
     */

    public ArrayList<String[]> getAllSubSets(String[] member){
       ArrayList<String[]> output = new ArrayList<>();
       grayCode code = new grayCode(member.length);
       boolean KeepSearch = true;
       while(KeepSearch){
           String[] subSet = new String[0];
           int[] status = code.getNextGrayCode();
           boolean notFilled = false;
           for(int id = 0; id < member.length; id++){
               if(status[id] == 1){
                   String[] temp = new String[subSet.length + 1];
                   for(int i = 0; i < subSet.length; i++) temp[i] = subSet[i];
                   temp[temp.length - 1] = member[id];
                   subSet = temp;
               }else{
                   notFilled = true;
               }
           }
           output.add(subSet);
           KeepSearch = notFilled;
       }
       return output;
    }
}