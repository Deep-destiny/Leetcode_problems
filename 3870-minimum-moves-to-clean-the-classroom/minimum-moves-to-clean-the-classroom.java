class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] litterMap = new int[m][n];
        int startX = 0, startY = 0, litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterMap[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) return 0;
        int targetMask = (1 << litterCount) - 1;

        // Tracking the max energy we've had at a specific state to prune redundant BFS branches
        int[][][] maxEnergyAt = new int[m][n][1 << litterCount];
        for (int[][] arr2D : maxEnergyAt) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        // {row, col, current_energy, mask, moves}
        queue.add(new int[]{startX, startY, energy, 0, 0});
        maxEnergyAt[startX][startY][0] = energy;

        int[] dirs = {-1, 0, 1, 0, -1}; // up, right, down, left

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], e = curr[2], mask = curr[3], moves = curr[4];

            if (mask == targetMask) return moves;
            if (e == 0) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i];
                int nc = c + dirs[i + 1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char cell = classroom[nr].charAt(nc);
                if (cell == 'X') continue;

                int nextEnergy = (cell == 'R') ? energy : e - 1;
                int nextMask = mask;
                if (cell == 'L') {
                    nextMask |= (1 << litterMap[nr][nc]);
                }

                if (nextEnergy > maxEnergyAt[nr][nc][nextMask]) {
                    maxEnergyAt[nr][nc][nextMask] = nextEnergy;
                    queue.add(new int[]{nr, nc, nextEnergy, nextMask, moves + 1});
                }
            }
        }
        return -1;
    }
}