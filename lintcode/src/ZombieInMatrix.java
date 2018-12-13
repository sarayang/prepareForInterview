import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 不能用这个方法来做 原因是写了太多的duplicated的double for loop来check当前的board
 * 而且是因为我把当前的整个board作为一层的状态来做 应该是用每个当前的board的所有zombies的coordinate来做
 * 然后 应该想九章那样 把people/zombie/wall用static variable来表示 而不是用0，1，2来check 这样的话
 * 在proj中 会很难理解 什么是0/1/2: https://www.jiuzhang.com/solution/zombie-in-matrix/
 */
class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class ZombieInMatrix {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public static int zombie(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        return bfs(grid);
    }
    static int[] xDelta = {-1, 1, 0, 0};
    static int[] yDelta = {0, 0, -1, 1};
    private static int bfs(int[][] grid) {
        // Point p = new Point(x, y);
        Deque<int[][]> queue = new LinkedList<>();

        Set<Integer> set = new HashSet<>();
        queue.offer(grid);

        set.add(convertToIdentifier(grid));
        int day = 0;
        while (!queue.isEmpty()) {
            int[][] curBoard = queue.poll();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0 || grid[i][j] == 2 || grid[i][j] == 3) {
                        continue;
                    }
                    convertToZombies(i, j, grid);
                }
            }
            converNewZombiesToZombies(grid);
            int identifier = convertToIdentifier(grid);
            if (!set.contains(identifier)) {
                queue.offer(grid);
                set.add(identifier);
            }
            day++;
        }
        if (checkAllZombies(grid)) {
            return day - 1;
        }
        return -1;
    }
    private static void converNewZombiesToZombies(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 3) {
                    grid[i][j] = 1;
                }
            }
        }
    }
    private static int convertToIdentifier(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }

    private static boolean checkAllZombies(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void convertToZombies(int x, int y, int[][] grid) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + xDelta[i];
            int nextY = y + yDelta[i];
            if (nextX < 0 || nextX > grid.length - 1 || nextY < 0 || nextY > grid[0].length - 1 || grid[nextX][nextY] != 0) {
                continue;
            }
            if (grid[nextX][nextY] == 0) {
                grid[nextX][nextY] = 3;
            }
        }
    }

    private void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

}
