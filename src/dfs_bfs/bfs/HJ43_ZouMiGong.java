package dfs_bfs.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//走迷宫，只有一条路径
// 题目已经提示了 【迷宫只有一条通道】，则直接使用 DFS 找路径就行了，如不有多条路径找最短考虑使用 BFS
public class HJ43_ZouMiGong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = in.nextInt();
			}
		}

		ArrayList<Point> path = new ArrayList<>();

		dfs(map, path,0, 0);

		for (Point p : path) {
			System.out.println("(" + p.x + "," + p.y + ")");
		}
    }
    
    public static boolean dfs(int[][] map, List<Point> path, int x, int y) {
        // 添加路径并标记已走
        path.add(new Point(x, y));
        map[x][y] = 1;

        // 结束标志
        if (x == map.length - 1 && y == map[0].length - 1) {
            return true;
        }

        // 向下能走时
        if (x + 1 < map.length && map[x + 1][y] == 0) {
			if( dfs(map, path, x + 1, y) )
				return true;
        }
        // 向右能走时
        if (y + 1 < map[0].length && map[x][y + 1] == 0) {
			if( dfs(map, path, x, y + 1) )
				return true;
		}
        // 向上能走时
        if (x - 1 > -1 && map[x - 1][y] == 0) {
			if( dfs(map, path, x - 1, y) )
				return true;
		}
        // 向左能走时
        if (y - 1 > -1 && map[x][y - 1] == 0) {
			if( dfs(map, path, x, y - 1) )
				return true;
		}

        // 回溯
        path.remove(path.size() - 1);
        map[x][y] = 0;
        return false;
    }


    // 简单的位置类
    public static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
