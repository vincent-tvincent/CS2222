import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class solutions {
    //question1
    public static stringHashTable hashFile(FileReader file) throws IOException {
        stringHashTable hashTable = new stringHashTable(350,123);
        BufferedReader reader = new BufferedReader(file);
        String gain = "";
        while((gain = reader.readLine()) != null){
            String[] words = gain.split("\s+");
            for(String word: words) hashTable.hash(word);
        }
        return hashTable;
    }

    //question2
    public static ArrayList<String> dijkstra(Matrix<Integer> connection,String[] nodeMap, String start, String end){
        Hashtable<Integer,Integer> result = dijkstraTrack(connection,mapNode(start,nodeMap));
        ArrayList<String> path = new ArrayList();
        int currentNode = mapNode(end,nodeMap);
        do{
            path.add(0,nodeMap[currentNode]);
            currentNode = result.get(currentNode);
        }while(currentNode != -1);

        return path;
    }

    private static Hashtable<Integer,Integer> dijkstraTrack(Matrix<Integer> connection, int start){
        Hashtable<Integer,Integer> track = new Hashtable();// the shortest distance from the nodes to start node
        Hashtable<Integer,Integer> backTrack = new Hashtable(); // the adjacency backtrack on the shortest path
        ArrayList<Integer> checkQueue = new ArrayList();
        int size = connection.xLength(); // nodes are 0 to size - 1
        for(int node = 0; node < size; node++){
            track.put(node,Integer.MAX_VALUE);
            checkQueue.add(node);
        }
        track.replace(start,0);
        backTrack.put(start, -1);
        while(checkQueue.size() > 0){ // if every node checked
            int fromNode = getMin(checkQueue);
            checkQueue.remove(fromNode);
            for(int toNode = 0; toNode < size; toNode++){ // check through adjacency matrix
                if(connection.get(fromNode,toNode) < Integer.MAX_VALUE){ // if have connection
                    int newDistance = track.get(fromNode) + connection.get(fromNode,toNode); // distance from the start node to the checking node
                    if(newDistance < track.get(toNode)) {
                        track.replace(toNode,newDistance);

                        //update the back track information
                        if(backTrack.contains(toNode)){
                            backTrack.replace(toNode,fromNode);
                        }else{
                            backTrack.put(toNode,fromNode);
                        }
                    }
                }
            }
        }
        return backTrack;
    }

    private static int mapNode(String node,String[] map){
        boolean keepSearch = true;
        int result = -1;
        for(int i = 0; i < map.length && keepSearch; i++){
            if(map[i] == node){
                result = i;
                keepSearch = false;
            }
        }
        return result;
    }

    private static int getMin(ArrayList<Integer> input){
        int min = -1;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < input.size(); i++){
            if(input.get(i) < minValue){
                min = i;
                minValue = input.get(i);
            }
        }
        return min;
    }

}
