package graphs_adjacency_list;


public class GraphTester {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.addNode(new Node('A'));
        g.addNode(new Node('B'));
        g.addNode(new Node('C'));
        g.addNode(new Node('D'));
        g.addNode(new Node('E'));

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 0);
        g.addEdge(4, 2);

        g.print();

    }

}
