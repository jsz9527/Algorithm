package dfs_bfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

class L200_NumIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}
        };

        System.out.println(new L200_NumIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        boolean[][] isV = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(isV[i][j] == false && grid[i][j] == '1'){
                    Node node = new Node(i,j);
                    queue.clear();
                    queue.offer(node);

                    isV[i][j] = true;

                    while ( !queue.isEmpty()){
                        Node nodeTemp = queue.poll();
                        int x = nodeTemp.x;
                        int y = nodeTemp.y;

                        if(x+1<grid.length && isV[x+1][y] == false && grid[x+1][y] == '1'){
                            Node node_d = new Node(x+1,y);
                            queue.offer(node_d);
                            isV[x+1][y] = true;
                        }
                        if(x-1>=0 && isV[x-1][y] == false && grid[x-1][y] == '1'){
                            Node node_u = new Node(x-1,y);
                            queue.offer(node_u);
                            isV[x-1][y] = true;
                        }
                        if(y+1<grid[0].length && isV[x][y+1] == false && grid[x][y+1] == '1'){
                            Node node_r = new Node(x,y+1);
                            queue.offer(node_r);
                            isV[x][y+1] = true;
                        }
                        if(y-1>=0 && isV[x][y-1] == false && grid[x][y-1] == '1'){
                            Node node_l = new Node(x,y-1);
                            queue.offer(node_l);
                            isV[x][y-1] = true;
                        }
                    }

                    result++;
                }
            }

        }

        return result;
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}