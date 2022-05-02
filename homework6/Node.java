import java.util.ArrayList;

public class Node {
    int value;
    ArrayList<Node> children;
    public Node(int value){
        children = new ArrayList<>();
        this.value = value;
    }
    public void add(Node child){
        children.add(child);
    }

    public void xcut(int index){
        children.remove(index);
    }
}
