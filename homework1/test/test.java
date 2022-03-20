package test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assumptions.*;
import gameBoard.board;
public class test {
    @Test
    public void testCreateBoard(){
        int[] iconInfo = {1,2,3,4,5};
        int[] layoutInfo = {1,2,3,4,5};
        board testObject = new board(true,iconInfo);
        testObject.createBoard(layoutInfo);
        int x = 0;
        int y = 0;
        int icon = 0;
        boolean testResult = false;
        boolean keepCheck = true;
        while(y < layoutInfo.length && keepCheck){
            if(iconInfo[icon] == 0) icon++;
            if(x < layoutInfo[y]){
                System.out.println("x: " + x + "\ny: " + y + "\n");
                System.out.println(testObject.getIcon(x,y));
                testResult = testObject.getIcon(x,y) == icon && !testObject.getStatus(x,y);
                if(!testResult) keepCheck = false;
                iconInfo[icon] --;
                x++;
            }else{
                x = 0;
                y++;
            }
        }
        assumeTrue(testResult);
    }


}
