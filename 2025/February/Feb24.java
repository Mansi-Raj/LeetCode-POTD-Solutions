import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Feb24 {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] BobPath = new int[n];
        Arrays.fill(BobPath, -1);
        List<Integer> path = new ArrayList<>();
        
        if (!BobFill(bob, -1, graph, path))
            return 0;
        for (int i = 0; i < path.size(); i++){
            BobPath[path.get(i)] = i;
        }
        return Alice(0, -1, 0, 0, graph, amount, BobPath);
    }
    private boolean BobFill(int node, int parent, List<Integer>[] graph, List<Integer> path){
        if (node == 0)
            return true;
        for (int nei : graph[node]){
            if (nei != parent){
                path.add(node);
                if (BobFill(nei, node, graph, path))
                    return true;
                path.remove(path.size() -1);
            }
        }
        return false;
    }
    private int Alice(int node, int parent, int cur, int time, List<Integer>[] graph, int [] amount, int[] BobPath){
        if (BobPath[node] == -1 || BobPath[node] > time){
            cur += amount[node];
        } else if (BobPath[node] == time){
            cur += amount[node] / 2;
        }
        if (graph[node].size() == 1 && node != 0)
            return cur;
        int maxScore = Integer.MIN_VALUE;
        for (int nei : graph[node]){
            if (nei != parent){
                maxScore = Math.max(maxScore, Alice(nei, node, cur, time + 1, graph, amount, BobPath));
            }
        }
        return maxScore;
    }
}
