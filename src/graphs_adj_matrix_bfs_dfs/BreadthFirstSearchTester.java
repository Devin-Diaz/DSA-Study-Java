package graphs_adj_matrix_bfs_dfs;


/*
    Devin Diaz,    3 / 20 / 2024

    This program tests the time of graphs via BFS.
    The nodes are manually set but the edges are populated at random given how many edges
    are chosen.
*/
public class BreadthFirstSearchTester {
    public static void main(String[] args) {

        Graph graph1 = new Graph(5);
        Graph graph2 = new Graph(10);
        Graph graph3 = new Graph(20);

        graph1.addNode(new Node('A'));
        graph1.addNode(new Node('B'));
        graph1.addNode(new Node('C'));
        graph1.addNode(new Node('D'));
        graph1.addNode(new Node('E'));

        graph2.addNode(new Node('A'));
        graph2.addNode(new Node('B'));
        graph2.addNode(new Node('C'));
        graph2.addNode(new Node('D'));
        graph2.addNode(new Node('E'));
        graph2.addNode(new Node('F'));
        graph2.addNode(new Node('G'));
        graph2.addNode(new Node('H'));
        graph2.addNode(new Node('I'));
        graph2.addNode(new Node('J'));

        graph3.addNode(new Node('A'));
        graph3.addNode(new Node('B'));
        graph3.addNode(new Node('C'));
        graph3.addNode(new Node('D'));
        graph3.addNode(new Node('E'));
        graph3.addNode(new Node('F'));
        graph3.addNode(new Node('G'));
        graph3.addNode(new Node('H'));
        graph3.addNode(new Node('I'));
        graph3.addNode(new Node('J'));
        graph3.addNode(new Node('K'));
        graph3.addNode(new Node('L'));
        graph3.addNode(new Node('M'));
        graph3.addNode(new Node('N'));
        graph3.addNode(new Node('O'));
        graph3.addNode(new Node('P'));
        graph3.addNode(new Node('Q'));
        graph3.addNode(new Node('R'));
        graph3.addNode(new Node('S'));
        graph3.addNode(new Node('T'));

        testCase(graph1);
        testCase(graph2);
        testCase(graph3);


    }

    private static void testCase(Graph graph) {
        graph.randomlyPopulateGraph(10);
        graph.randomlyPopulateGraph(20);
        graph.randomlyPopulateGraph(30);


        long startTime = System.nanoTime();

        graph.breadthFirstSearch(0);


        long endTime = System.nanoTime();

        long duration = (endTime - startTime); // Duration in nanoseconds
        System.out.println("Execution time for BFS is " +  nanoToMilli(duration) + " milliseconds");
    }

    private static double nanoToMilli(double nano) {
        return nano / 1000000;
    }
}
