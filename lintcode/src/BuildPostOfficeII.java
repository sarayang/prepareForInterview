import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by YANGSONG on 2018-12-08.
 */
public class BuildPostOfficeII {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    continue;
                }
                int ans = bfs(grid, i, j);
                smallest = Math.min(smallest, ans);
                if (smallest == ans) {
                    System.out.println(i + "," + j + ":" + ans);
                }
            }
        }
        return smallest == Integer.MAX_VALUE ? -1 : smallest;
    }
    private static int[] xDelta = {-1, 1, 0, 0};
    private static int[] yDelta = {0, 0, -1, 1};
    private int bfs(int[][] grid, int row, int col) {
        Queue<Integer> qRow = new LinkedList<>();
        Queue<Integer> qCol = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int dist = 0;
        int sum = 0;
        qRow.offer(row);
        qCol.offer(col);
        visited[row][col] = true;
        while (!qRow.isEmpty()) {
            dist++;
            int size = qRow.size();
            for (int j = 0; j < size; j++) {
                int r = qRow.poll();
                int c = qCol.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = r + xDelta[i];
                    int nextY = c + yDelta[i];
                    if (isValid(nextX, nextY, grid) && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        if (grid[nextX][nextY] == 1) {
                            sum += dist;
                        }
                        // only when the coordinate is 0, it has path connecting to the house
                        if (grid[nextX][nextY] == 0) {
                            qRow.offer(nextX);
                            qCol.offer(nextY);
                        }

                    }
                }
            }
        }

        // check if there is a 1 but did not visited from the input (row, col)
        // it means that that point can not reach to a house which means that is an invalid coordination
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return sum;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        if (row < 0 || row > grid.length -1 ||
                col < 0 || col > grid[0].length - 1) {
            return false;
        }
        return true;
    }
}