class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        ArrayList<Integer> list = new ArrayList<>();

        // Terminal nodes
        for (int i = 0; i < V; i++) {
            if (graph[i].length == 0) {
                list.add(i);
            }
        }

        boolean[] vis = new boolean[V];
        boolean[] safe = new boolean[V];

        for (int i = 0; i < V; i++) {
            DfsMila(i, graph, vis, safe, list);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean DfsMila(int curr, int[][] graph,
                            boolean[] vis,
                            boolean[] safe,
                            ArrayList<Integer> list) {

        if (list.contains(curr)) {
            safe[curr] = true;
            return true;
        }

        if (safe[curr]) {
            return true;
        }

        if (vis[curr]) {
            return false;
        }

        vis[curr] = true;

        for (int ngh : graph[curr]) {

            if (!DfsMila(ngh, graph, vis, safe, list)) {
                return false;
            }
        }

        safe[curr] = true;

        // Backtracking: current node path se remove
        vis[curr] = false;

        return true;
    }
}