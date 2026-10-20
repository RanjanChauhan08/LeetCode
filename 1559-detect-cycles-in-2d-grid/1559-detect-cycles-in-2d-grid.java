
class Solution {
    public boolean dfs(char[][] grid, boolean[][] visited,
                       int r, int c, int pr, int pc) {

        visited[r][c] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= grid.length ||
                nc < 0 || nc >= grid[0].length ||
                grid[nr][nc] != grid[r][c]) {
                continue;
            }

            // Ignore the edge we came from
            if (nr == pr && nc == pc) {
                continue;
            }

            // Visited same-character neighbor means a cycle
            if (visited[nr][nc]) {
                return true;
            }

            if (dfs(grid, visited, nr, nc, r, c)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
