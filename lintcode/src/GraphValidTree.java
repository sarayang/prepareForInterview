import java.util.*;

/**
 * Created by YANGSONG on 2018-12-05.
 */

public class GraphValidTree {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        //坑如下：
        // n may be bigger than the largest number in edges;
        // （edges may have more than one tree. if they do not connect to each other, it is not a tree
        // can only contain one tree there.）
        // if edges contains more than one tree, even if they do not connect, it is an invalid tree. since we want to find tree instead of forest.
        // *** but in this code, it consider that forest is a valid tree.... lol.***
        // it will fail with this input:
        // n = 8
        // edges = [[0,1],[1,2],[4,3],[4,5],[5,6],[6,7]]
        // tree can not contain cycle inside.
        if (n > 1 && edges.length == 0) {
            return false;
        }
        if (n <= 1 && edges.length == 0) {
            return true;
        }
        if (edges == null || edges.length == 0) {
            return false;
        }
        if (edges[0].length == 0 || edges[0].length == 0) {
            return false;
        }
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            for (int node : edge) {
                if (!map.containsKey(node)) {
                    map.put(node, new HashSet<>());
                }
                if (!indegree.containsKey(node)) {
                    indegree.put(node, 0);
                }

            }
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }

        for (Integer indep : map.keySet()) {
            for (Integer dep : map.get(indep)) {
                Integer degree = indegree.getOrDefault(dep, 0);
                indegree.put(dep, degree + 1);
            }
        }
        Deque<Integer> queue = new LinkedList<>();

        for (int i : indegree.keySet()) {
            if (indegree.get(i) == 0) {
                queue.offer(i);
            }
        }
        Set<Integer> nodes = new HashSet<>();
        while (!queue.isEmpty()) {

            int cur = queue.poll();
            Deque<Integer> innerQueue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            innerQueue.offer(cur);
            set.add(cur);
            nodes.add(cur);
            while (!innerQueue.isEmpty()) {
                int innerNode = innerQueue.poll();
                for (Integer dep : map.get(innerNode)) {
                    if (set.contains(dep)) {
                        return false;
                    }

                    if (!set.contains(dep)) {
                        set.add(dep);
                        nodes.add(dep);
                        innerQueue.offer(dep);
                    }
                }
            }
        }
        // System.out.println(nodes);
        if (nodes.size() < n) {
            return false;
        }
        return true;
    }

}
