import java.util.ArrayList;
import java.util.ArrayDeque;

public class SubirachsSquire extends Matrix<Integer> {
    private class coordinate{
        public int x;
        public int y;
        public coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public SubirachsSquire(){
        super();
    }

//    public ArrayList<int[]> getAllCombinationsOfNElements(int combinationSize){
//        ArrayList<int[]> output = new ArrayList<>();
//        int[] pivits = new int[combinationSize];
//        int targetSum = 0;
//
//        int activatePoint = combinationSize - 1;
//        for(int i = 0; i < combinationSize; i++){
//            pivits[i] = i;
//            targetSum += get(i);
//        }
//        int maxSteps = size() - combinationSize;
//        int lastPivitIndex = combinationSize - 2;
//        while(lastPivitIndex > -1){
//            //check through every pivit
//            for(int pivit = combinationSize - 1; pivit > 0; pivit--){
//                //check if should move this pivit
//                if(pivits[pivit] >= activatePoint){
//                    //go from its start point to end
//                    for(int step = 0; step < maxSteps; step++){
//                        //check value
//                        int currentSum = 0;
//                        int[] currentCombination = new int[combinationSize];
//                        int outputIndex = 0;
//                        for(int index: pivits){
//                            currentSum += get(index);
//                            currentCombination[outputIndex] = get(index);
//                            outputIndex++;
//                        }
//                        System.out.print("sum: " + currentSum + " ");
//                        System.out.print("pivits: ");
//                        for(int i: pivits) System.out.print(i + ", ");
//                        System.out.print("value: ");
//                        for(int i: currentCombination) System.out.print(i + ", ");
//                        System.out.println();
//                        if(currentSum == targetSum) output.add(currentCombination);
//                        pivits[pivit] ++;
//                    }
//                }
//            }
//            //move the last one
//            pivits[lastPivitIndex] ++;
//            //check if start checking next pivit
//            if(pivits[lastPivitIndex] == activatePoint){
//                lastPivitIndex--;
//                maxSteps --;
//            }
//
//            //reset
//            for(int pivit = combinationSize - 1; pivit > 0; pivit--){
//                if(pivits[pivit] > activatePoint){
//                    pivits[pivit] -= maxSteps;
//                }
//            }
//        }
//        //last special case
////        pivits[lastPivitIndex]++;
////        for(int pivit = 2; pivit < combinationSize; pivit++){
////            pivits[pivit] = pivits[pivit-1] + 1;
////        }
////        //check for it
////        int currentSum = 0;
////        for(int index: pivits) currentSum += get(index);
////        if(currentSum == targetSum) output.add(pivits);
//        return output;
//    }

    public ArrayList<int[]> getAllCombinationsOfNElements(int combinationSize){
    }

}
