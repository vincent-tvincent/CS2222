// i write this class because i may use it in some assignment later,
// which is i don't want to write it once again.
public class Matrix<T>{
    private T[] matrixBody;
    private int nextCount;
    private int xLength;
    private int yLength;

    public Matrix(int xSize, int ySize){
        matrixBody = (T[]) new Object[xSize*ySize];
        xLength = xSize;
        yLength = ySize;
    }

    public Matrix(){
        matrixBody = (T[]) new Object[0];
        xLength = 0;
        yLength = 0;
    }

    public int size(){
        return matrixBody.length;
    }

    public void fillWith(T value){ for(int i = 0; i < matrixBody.length; i++) matrixBody[i] = value; }

    public void fillWith(T[][] value){
        xLength = value[0].length;
        yLength = value.length;
        matrixBody = (T[]) new Object[xLength * yLength];
        for(int col = 0; col < yLength; col++){
            for(int row = 0; row < xLength; row++){
                matrixBody[col* xLength + row] = value[col][row];
            }
        }
    }

    public void set(int row, int col,T value){ matrixBody[col* xLength + row] = value; }

    public void set(int bias,T value){ matrixBody[bias] = value; }

    public void swap(int x1, int y1, int x2, int y2){
        T temp = get(x1,y1);
        set(x1,y1,get(x2,y2));
        set(x2,y2,temp);
    }

    public void swapCol(int x1, int x2){
        for(int y = 0; y < yLength; y ++){
            swap(x1,y,x2,y);
        }
    }

    public void swapRow(int y1, int y2){
        for(int x = 0; x < xLength; x ++){
            swap(x,y1,x,y2);
        }
    }

    public void nextBackToStart(){
        nextCount = 0;
    }

    public T next(boolean goHorizontal){
        T output = matrixBody[nextCount];

        if(goHorizontal) nextCount++;
        else nextCount += xLength;

        if(nextCount > xLength * yLength - 1) nextBackToStart();
        return output;
    }

    public T get(int x, int y){
        return matrixBody[y* xLength + x];
    }
    public T get(int bias) { return matrixBody[bias];}
    public int xLength(){return xLength;}
    public int yLength(){return yLength;}

    public String toString(){
        String output = "";
        int count = 0;
        for(T value: matrixBody){
            if(count == xLength){
                output += "\n";
                count = 0;
            }
            output += value + " ";
            count ++;
        }
        return output;
    }

}
