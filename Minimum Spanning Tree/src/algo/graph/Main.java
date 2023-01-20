package algo.graph;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        Graph graph = new Graph(v,e);
        for(int i=0; i<e; i++)
        {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            double speed = scanner.nextDouble();
            graph.edges[i] = new Edge(src, dest, speed);
        }
        System.out.println(graph.kruskal(graph));
    }
}
