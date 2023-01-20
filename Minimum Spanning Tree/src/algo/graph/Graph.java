package algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge implements Comparable<Edge>
{
    int src;
    int dest;
    Double weight;

    public Edge() {
    }

    public Edge(int src, int dest, Double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight.compareTo(o.weight);
    }
}
class DisjointSet
{
    int parent;
    int rank;

    public DisjointSet() {
    }
    static int findSet(DisjointSet[] sets, int x)
    {
        if(sets[x].parent != x)
        {
            sets[x].parent = findSet(sets, sets[x].parent);
        }
        return sets[x].parent;
    }
    static void unionByRank(DisjointSet[] sets, int x, int y)
    {
        int rootX = findSet(sets, x);
        int rootY = findSet(sets, y);
        if(sets[rootX].rank > sets[rootY].rank)
            sets[rootY].parent = rootX;
        else
        {
            sets[rootX].parent = rootY;
            if(sets[rootX].rank == sets[rootY].rank)
                sets[rootX].rank++;
        }
    }
    public static void initializeSets(DisjointSet[] sets, int vertices)
    {
        for(int i=0; i<vertices; i++)
        {
            sets[i] = new DisjointSet();
            sets[i].parent = i;
            sets[i].rank = 0;
        }
    }
}

public class Graph {
    int vertex;
    int e;
    Edge[] edges;

    public Graph(int vertex, int e) {
        this.vertex = vertex;
        this.e = e;
        edges = new Edge[e];
        for(int i=0; i<e; i++)
        {
            edges[i] = new Edge();
        }
    }

    Double kruskal(Graph graph)
    {
        Arrays.sort(graph.edges);
        List<Edge> mstEdges = new ArrayList<>(graph.vertex-1);
        DisjointSet[] subsets = new DisjointSet[graph.vertex];
        DisjointSet.initializeSets(subsets, graph.vertex);
        double minSpeed = Double.MAX_VALUE;
        int j=0;
        for(int i=graph.e-1; i>=0 && j< graph.vertex-1; i-- )
        {
            int x = DisjointSet.findSet(subsets, graph.edges[i].src);
            int y = DisjointSet.findSet(subsets, graph.edges[i].dest);
            if(x != y)
            {
                mstEdges.add(graph.edges[i]);
                if(minSpeed > edges[i].weight)
                {
                    minSpeed = edges[i].weight;
                }
                j++;
                DisjointSet.unionByRank(subsets, x, y);
            }
        }
        if(j != graph.vertex-1)
        {
            System.out.println("MST can't be formed!");
        }
        return minSpeed;
    }
}
