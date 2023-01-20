package algo.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Graph graph = new Graph(n);
        Graph graph2 = new Graph(n);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++)
        {
            int f1 = scanner.nextInt();
            int f2 = scanner.nextInt();
            graph.addShares(f1,f2);
            graph2.addShares(f2,f1);
        }
        graph.calcFinishTime(1);
        graph2.setFinishTime(graph.getFinishTime());
        for(int i=0; i<n; i++)
        {
            int a = graph2.maxFinishTime();
            if(a == -1)
                break;
            ArrayList<Integer> sets = new ArrayList<>();
            sets = graph2.dfs(a);
            System.out.println(sets);
        }
    }
}
