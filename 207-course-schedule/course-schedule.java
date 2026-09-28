class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // b ---> a
        for (int[] p : prerequisites) {

            int a = p[0];
            int b = p[1];

            adj.get(b).add(a);

            // Edge is entering 'a'
            indegree[a]++;
        }

        return topologicalSortCheck(adj, numCourses, indegree);
    }


    private boolean topologicalSortCheck(
            ArrayList<ArrayList<Integer>> adj,
            int n,
            int[] indegree) {

        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        // Find courses having no prerequisite
        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                q.offer(i);
                count++;
            }
        }

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int v : adj.get(u)) {

                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                    count++;
                }
            }
        }

        // All courses processed => no cycle
        return count == n;
    }
}