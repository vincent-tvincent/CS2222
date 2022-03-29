import java.util.ArrayList;

public class hw2main {
    public static void main(String args[]){
        LucasNumber lucas = new LucasNumber();
        ArrayList<Integer> production = lucas.getLucasSiquence(1,2,40);

        int count = 1;
        for(int i: production){
            System.out.print(i + " ");
            if( count == 10){
                System.out.println();
                count = 1;
            }else{
                count ++;
            }
        }
    }
}
