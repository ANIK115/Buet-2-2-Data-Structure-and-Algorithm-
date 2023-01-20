package algo.graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Integer>> firms;
    private int n;
    private int[] finishTime;
    private boolean[] visited;
    int time= 1;

    public Graph (int size) {
        this.firms = new ArrayList<ArrayList<Integer>>(n+1);
        this.n = size+1;
        finishTime = new int[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++)
            visited[i] = false;

        for(int i=0; i<n; i++)
        {
            this.firms.add(new ArrayList<Integer>());
        }
    }
    public void addShares(int f1, int f2)
    {
        this.firms.get(f1).add(f2);
    }

    public void calcFinishTime(int s)
    {
        visited[s] = true;
        time++;
        for(int i : firms.get(s))
        {
            if(visited[i] == false)
            {
                calcFinishTime(i);
            }
        }
        finishTime[s] = time;
        time++;
    }

    public int[] getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int[] finishTime) {
        this.finishTime = finishTime;
    }
    public ArrayList<Integer> dfs(int start)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        ArrayList<Integer> comp = new ArrayList<>();
        while(!stack.isEmpty())
        {
            int current = stack.top();
            stack.pop();
            if(visited[current] == false)
            {
                visited[current] = true;
                comp.add(current);
            }
            for(int i=0; i<firms.get(current).size(); i++)
            {
                int x = firms.get(current).get(i);
                if(visited[x] == false)
                    stack.push(x);
            }
        }
        return comp;
    }
    public int maxFinishTime()
    {
        int max = Integer.MIN_VALUE;
        int ind = -1;
        for(int i=1; i<n; i++)
        {
            if(visited[i] == false && finishTime[i] > max)
            {
                max = finishTime[i];
                ind = i;
            }
        }
        return ind;
    }
}
