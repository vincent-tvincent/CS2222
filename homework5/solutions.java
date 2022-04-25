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
        int[] backTrackResult = dijkstraTrack(connection,mapNode(start,nodeMap));
        ArrayList<String> path = new ArrayList();
        int currentNode = mapNode(end,nodeMap);
        do{
            path.add(0,nodeMap[currentNode]);
            currentNode = backTrackResult[currentNode];
        }while(currentNode != -1);
        return path;
    }

    private static int[] dijkstraTrack(Matrix<Integer> connection, int start){
        int size = connection.xLength(); // nodes are 0 to size - 1
        int[] trackDistance = new int[size];// the shortest distance from the nodes to start node
        int[] backTrack = new int[size]; // the adjacency backtrack on the shortest path
        boolean[] exclude = new boolean[size]; // the nodes which already found the shortest path
        ArrayList<Integer> checkQueue = new ArrayList();
        for(int node = 0; node < size; node++){
            trackDistance[node] = Integer.MAX_VALUE; // initialize the distance from each point as infinity
            backTrack[node] = -1;
            checkQueue.add(node); // add every node to the check queue
        }

        trackDistance[start] = 0; // set the start point's self loop as distance of 0
        //backTrack[start] = start; // the start point do not have back track
        exclude[start] = true;
        while(checkQueue.size() > 0){ // if every node checked
            int fromNodeIndex = getMin(trackDistance,checkQueue);
            int fromNode = checkQueue.get(fromNodeIndex);
            checkQueue.remove(fromNodeIndex);
            for(int toNode = 0; toNode < size; toNode++){ // check through adjacency matrix
                if(connection.get(fromNode,toNode) < Integer.MAX_VALUE && !exclude[toNode]){ // if have connection and haven't found the shortest path
                    int newDistance = trackDistance[fromNode] + connection.get(fromNode,toNode); // distance from the start node to the checking node
                    if(newDistance < trackDistance[toNode]) {
                        trackDistance[toNode] = newDistance;
                        backTrack[toNode] = fromNode;
                    }
                }
            }
            exclude[fromNode] = true;
        }
        return backTrack;
    }

    private static int getMin(int[] trackDistance,ArrayList<Integer> checkQueue){
        int min = -1;
        int minValue = Integer.MAX_VALUE;
        for(int nodeIndex = 0; nodeIndex < checkQueue.size(); nodeIndex++){
            int node = checkQueue.get(nodeIndex);
            if(trackDistance[node] < minValue){
                min = nodeIndex;
                minValue = trackDistance[node];
            }
        }
        return min;
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

}
