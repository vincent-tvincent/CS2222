import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class hw5main {
    public static void main(String[] args) throws IOException {
        boolean question1 = true;
        boolean question2 = true;

        if(question1){
            //question1
            FileReader testFile = new FileReader(".\\homework5\\WalrusAndTheCarpenterD2022.txt");
            stringHashTable demo1 = solutions.hashFile(testFile);
            System.out.println(demo1.toString());
            //a. there are 0 non-empty addresses, load factor is 0, the list is full
            //b. since the hash table is full, there is no empty area there
            //c. the longest cluster is the whole list, since the whole list is full
            //d. the hash code have most distinct word releated with is 224, which have 5 words associated with
            //e. the word with farthest distance from its actual hash code is "one.," which have distance 88
            testFile.close();
        }
        if(question2){
            Matrix<Integer> testGraph = new Matrix();
            Integer inf = Integer.MAX_VALUE;
            testGraph.fillWith(new Integer[][]{
                    {0  , 53 , 10 , 12 , inf, inf, inf, inf, inf, inf},
                    {53 , 0  , 33 , inf, 2  , inf, 101, inf, inf, inf},
                    {10 , 33 , 0  , 9  , 30 , 18 , inf, inf, inf, inf},
                    {12 , inf, 9  , 0  , inf, 17 , inf, inf, 6  , inf},
                    {inf, 2  , 30 , inf, 0  , 14 , 123, 122, inf, inf},
                    {inf, inf, 18 , 17 , 14 , 0  , inf, 137, 7  , inf},
                    {inf, 101, inf, inf, 123, inf, 0  , 8  , inf, 71 },
                    {inf, inf, inf, inf, 122, 137, 8  , 0  , 145, 66 },
                    {inf, inf, inf, 6  , inf, 7  , inf, 145, 0  , 212},
                    {inf, inf, inf, inf, inf, inf, 71 , 66 , 212, 0  }

            });
            ArrayList<String> result = solutions.dijkstra(testGraph, new String[] {"A", "J", "M", "R", "K", "S","I", "N","T", "D"},"A","D");
            System.out.println("the path is: ");
            System.out.println(result);
            System.out.println();
        }
    }
}
