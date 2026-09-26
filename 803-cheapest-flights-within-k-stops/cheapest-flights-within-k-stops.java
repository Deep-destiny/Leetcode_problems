import java.util.*;

class Pair {
    int node;
    int cost;

    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Tuple {
    int stops;
    int node;
    int cost;

    Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fix 1: Properly close adj.get(flights[i][0]) before calling .add(...)
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple it = q.poll();

            // Fix 2: Access fields directly instead of using parenthesis
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;

            if (stops > k) continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.node;
                int edW = iter.cost;

                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }

        if (dist[dst] == (int) 1e9) return -1;
        return dist[dst];
    }
}