package test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void testPlace(){
        int[] iconInfo = {1};
        int[] iconTypeInfo = {1};
        board testObject = new board(true,iconInfo);
        testObject.createBoard(iconTypeInfo);
        testObject.place(0,0);
        assumeTrue(testObject.getStatus(0,0));
    }

    @Test
    public void testGetWin(){
        int[] iconInfo1 = {1};
        int[] iconTypeInfo1 = {1};
        int[] iconInfo2 = {1,1};
        int[] iconTypeInfo2 = {2};
        board testObject1 = new board(true,iconInfo1);
        board testObject2 = new board(false,iconInfo1);
        board testObject3 = new board(true,iconInfo2);
        testObject1.createBoard(iconTypeInfo1);
        testObject2.createBoard(iconTypeInfo1);
        testObject3.createBoard(iconTypeInfo2);
        testObject1.place(0,0);
        testObject2.place(0,0);
        testObject3.place(0,0);
        System.out.println(testObject1.getWin());
        System.out.println(testObject2.getWin());
        System.out.println(testObject3.getWin());
        assertEquals(testObject1.getWin(),1);
        assertEquals(testObject2.getWin(), 0);
        assertEquals(testObject3.getWin(),-1);
    }

}
