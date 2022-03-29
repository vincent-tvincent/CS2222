import java.util.ArrayList;
public class LucasNumber {
    private void runLucas(ArrayList<Integer> result, int firstNumber, int secondNumber, int restIteration){
        if(restIteration > 0){ // need add this value
            result.add(firstNumber + secondNumber); // add this value
            runLucas(result,secondNumber,firstNumber + secondNumber, restIteration - 1); // add next value
        }
    }

    public ArrayList<Integer> getLucasSiquence(int firstNumber, int secondNumber, int size){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(firstNumber);
        result.add(secondNumber);
        runLucas(result,firstNumber,secondNumber,size - 2);
        return result;
    }
}
