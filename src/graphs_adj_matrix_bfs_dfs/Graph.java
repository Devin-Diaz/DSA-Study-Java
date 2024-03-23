package graphs_adj_matrix_bfs_dfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
    Devin Diaz,     3 / 20 / 2024

    Graph Class with BFS method
*/


public class Graph {

    private int[][] matrix;
    private ArrayList<Node> nodes;

    public Graph(int size) {
        matrix = new int[size][size];
        nodes = new ArrayList<>();
    }

    public void breadthFirstSearch(int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(src);
        visited[src] = true;

        while(!queue.isEmpty()) {

            src = queue.poll();
            System.out.println(nodes.get(src).getData() + " --> VISITED");

            for(int i = 0; i < matrix[src].length; i++) {
                if(matrix[src][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }


    public void depthFirstSearch(int src) {
        boolean[] visited = new boolean[matrix.length];
        dFSHelper(src, visited);
    }

    private void dFSHelper(int src, boolean[] visited) {

        if(visited[src]) {
            return;
        }
        else {
            visited[src] = true;
            System.out.println("--> " + nodes.get(src).getData() + " VISITED");
        }

        for(int i = 0; i < matrix[src].length; i++) {
            if(matrix[src][i] == 1) {
                dFSHelper(i, visited);
            }
        }
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dst) {
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst) {
        return matrix[src][dst] == 1;
    }

    public void randomlyPopulateGraph(int numberOfEdges) {
        Random random = new Random();
        int size = nodes.size();

        for (int i = 0; i < numberOfEdges; i++) {
            int src = random.nextInt(size);
            int dst = random.nextInt(size);

            // To avoid self-loops, check if src is not equal to dst.
            // If you don't mind self-loops, you can remove this condition.
            if (src != dst) {
                addEdge(src, dst);
            } else {
                // Decrement i to ensure the desired number of edges is added.
                // This is because this iteration did not add any edge.
                i--;
            }
        }
    }

    public void print() {

        System.out.print("  ");

        for(Node node : nodes) {
            System.out.print(node.getData() + " ");
        }

        System.out.println();

        for(int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).getData() + " ");
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
