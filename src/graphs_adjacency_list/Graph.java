package graphs_adjacency_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    ArrayList<LinkedList<Node>> entireList;

    public Graph() {
        entireList = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> subList = new LinkedList<>();
        subList.add(node);
        entireList.add(subList);
    }

    public void addEdge(int src, int dst) {
        LinkedList<Node> subList = entireList.get(src);
        Node dstNode = entireList.get(dst).get(0);
        subList.add(dstNode);
    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<Node> subList = entireList.get(src);
        Node dstNode = entireList.get(dst).get(0);

        for(Node node : subList) {
            if(node == dstNode) return true;
        }
        return false;
    }

    public void print() {

        for(LinkedList<Node> subList : entireList) {
            for(Node node : subList) {
                System.out.print(node.getData() + " --> ");
            }
            System.out.println();
        }
    }
}
