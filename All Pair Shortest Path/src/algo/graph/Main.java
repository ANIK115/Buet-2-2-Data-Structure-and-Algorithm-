package algo.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static final int INF = 100002;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input2.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] distMat = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(i==j)
                    distMat[i][j] = 0;
                else distMat[i][j] = INF;
            }
        }
        for(int i=0; i<m; i++)
        {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            distMat[u][v] = w;
        }
        //if there is self loop, then also the shortest path distance from i to i is 0
        for(int i=1; i<=n; i++)
        {
            distMat[i][i] = 0;
        }
        for(int k=1; k<=n; k++)
        {
            for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=n; j++)
                {
                    if (distMat[i][j] > distMat[i][k] + distMat[k][j])
                        distMat[i][j] = distMat[i][k] + distMat[k][j];
                }
            }
        }
        System.out.println("Shortest distance matrix");
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(distMat[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(distMat[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
