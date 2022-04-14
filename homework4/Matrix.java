// i write this class because i may use it in some assignment later,
// which is i don't want to write it once again.
public class Matrix<T>{
    private T[] matrixBody;
    private int nextCount;
    private int rowLength;
    private int colLength;

    public Matrix(int row,int col){
        matrixBody = (T[]) new Object[row*col];
        rowLength = row;
        colLength = col;
    }

    public Matrix(){
        matrixBody = (T[]) new Object[0];
        rowLength = 0;
        colLength = 0;
    }

    public int size(){
        return matrixBody.length;
    }

    public void fillWith(T value){
        for(int i = 0; i < matrixBody.length; i++) matrixBody[i] = value;
    }

    public void fillWith(T[][] value){
        rowLength = value[0].length;
        colLength = value.length;
        matrixBody = (T[]) new Object[rowLength*colLength];
        for(int col = 0; col < colLength; col++){
            for(int row = 0; row < rowLength; row++){
                matrixBody[col*rowLength + row] = value[col][row];
            }
        }
    }

    public void set(int row, int col,T value){
        matrixBody[col*rowLength + row] = value;
    }

    public void swap(int row1, int col1, int row2, int col2){
        T temp = get(row1,col1);
        set(row1,col1,get(row2,col2));
        set(row2,col2,temp);
    }

    public void swapCol(int row1, int row2){
        for(int col = 0; col < colLength; col ++){
            swap(row1,col,row2,col);
        }
    }
    public void swapRow(int col1, int col2){
        for(int row = 0; row < rowLength; row ++){
            swap(row,col1,row,col2);
        }
    }

    public void nextBackToStart(){
        nextCount = 0;
    }

    public T next(boolean goHorizontal){
        T output = matrixBody[nextCount];

        if(goHorizontal) nextCount++;
        else nextCount += rowLength;

        if(nextCount > rowLength*colLength - 1) nextBackToStart();
        return output;
    }

    public T get(int row, int col){
        return matrixBody[col*rowLength + row];
    }
    public T get(int bias) { return matrixBody[bias];}

    public String toString(){
        String output = "";
        int count = 0;
        for(T value: matrixBody){
            if(count == rowLength){
                output += "\n";
                count = 0;
            }
            output += value + " ";
            count ++;
        }
        return output;
    }

}
