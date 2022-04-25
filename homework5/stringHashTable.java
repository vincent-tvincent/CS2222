import java.util.ArrayList;
import java.util.LinkedList;

public class stringHashTable{
    private String[] hashTable;
    private int C;
    private int size;
    private int occupied;
    private int mostFriquentCode;
    public stringHashTable(int size, int C){
        hashTable = new String[size];
        this.size = size;
        this.C = C;
        occupied = 0;
        mostFriquentCode = 0;
    }

    public void hash(String word){
        int hashAddress = 0;
        hashAddress = getCode(word);
        while(hashTable[hashAddress] != null && !hashTable[hashAddress].equals(word) && hashAddress < hashTable.length - 1){
            hashAddress ++;
        }
        hashTable[hashAddress]  = word;
        if(!hashTable[hashAddress].equals(word)) occupied++;
    }

    public String get(int Code){return hashTable[Code];}

    public int getCode(String word){
        int hashCode = 0;
        for(int character = 0; character < word.length(); character++){
            hashCode = Math.floorMod(hashCode * C + (int) word.charAt(character), size);
        }
        return hashCode;
    }

    public int size(){return size;}

    public int getOccupied(){return occupied;}

    public String toString(){
        String output = "";
        int lonestClusterIndex = 0;
        int longestCluster = 0;
        int currentCluster = 0;
        int longestClusterCount = 1;
        int[] codeCount = new int[size];
        int maxOffSet = 0;
        String maxOffSetWord = hashTable[0];
        for(int i = 0; i < size; i++){
            output += i;
            if(hashTable[i] == null){
                output += " " + null;
                if(currentCluster > longestCluster) {
                    longestCluster = currentCluster;
                    longestClusterCount = 1;
                    lonestClusterIndex = i - longestCluster;
                }else if(currentCluster == longestCluster) longestClusterCount ++;
                currentCluster = 0;
            }else{
                output += hashTable[i];
                if(i - getCode(hashTable[i]) > maxOffSet){
                    maxOffSet = i - getCode(hashTable[i]);
                    maxOffSetWord = hashTable[i];
                }
                codeCount[getCode(hashTable[i])] ++;
                currentCluster ++;
            }
            output += "\n";
        }
        int maxCode = 0;
        int maxCodeCount = 0;
        for(int code = 0; code < size; code++){
            if(codeCount[code] > maxCodeCount){
                maxCodeCount = codeCount[code];
                maxCode = code;
            }
        }
        output += "\nthe code with most distinct word: " + maxCode +  ", appeeared times: " + maxCodeCount;
        output += "\ncurrent cluster: " + currentCluster;
        output += "\nlongest cluster first appearance: start from index " + lonestClusterIndex + ", length: " + longestCluster + " appear times: " + longestClusterCount;
        output += "\namount of non-empty addresses: " + occupied + "\nload factor: " + (double)occupied/(double)size;
        output += "\nword farthest from actual value: " + maxOffSetWord + ", distance is: " + maxOffSet;
        return output;
    }
}


