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
     * @param n request for the Join or Leave information of the nth order
     * @return The String array record the changes on the set
     */
    public String getCharacterChange(String[] members, int n){
        grayCode code = new grayCode(members.length);
        String output = "";
        if(n > 0){
            int[] previousStatus = code.getNthSubSetStatus(n - 1);
            int[] recentStatus = code.getNthSubSetStatus(n);
            for(int id = 0; id < members.length; id ++){
                switch(recentStatus[id] - previousStatus[id]){
                    case 1:
                        output = " " + members[id] + " join";
                        break;
                    case -1:
                        output = " " + members[id] + " leave";
                        break;
                }
            }
        }else{
            output = " Spotlight";
        }
        return output;
    }

    /**
     * question3.3
     * @param member all the members in the Klutzomaniac
     * @return an arrayList of String array that represent each row of the routine table
     */

    public ArrayList<String> getTable(String[] member){
       ArrayList<String> output = new ArrayList<>();
       grayCode code = new grayCode(member.length);
       boolean KeepSearch = true;
       for(int rotaine = 0; rotaine < 32; rotaine++){
           String row = "" + rotaine + " ";
           if(rotaine/10 == 0) row += " ";
           int[] status = code.getNthSubSetStatus(rotaine);
           for(int id = 0; id < member.length; id++){
               if(status[id] > 0) row += " " + member[id];
           }
           while(row.length() < 40) row += " ";
           if(rotaine == 1) {
               row += " Axel Pedals";
           }else if(rotaine == 31) {
               row += " Enzo Crashes";
           }else{
               row += getCharacterChange(member,rotaine);
           }
           output.add(row);
       }
       return output;
    }
}