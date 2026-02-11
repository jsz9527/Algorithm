package dfs_bfs.dfs;

//螺旋矩阵
import java.util.ArrayList;
import java.util.List;

public class L54_spiralOrder {
    public List<Integer> spiralOrder_model(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;

        int u = 0, d = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;
        while (true){
            //左
            for(int i=l; i<=r;i++){
                ans.add(matrix[u][i]);
            }
            u++;
            if(u>d){
                break;
            }

            //下
            for(int i=u; i<=d;i++){
                ans.add(matrix[i][r]);
            }
            r--;
            if(r<l){
                break;
            }

            //右
            for(int i=r; i>=l;i--){
                ans.add(matrix[d][i]);
            }
            d--;
            if(d<u){
                break;
            }

            //上
            for(int i=d; i>=u;i--){
                ans.add(matrix[i][l]);
            }
            l++;
            if(l>r){
                break;
            }
        }

        return ans;
    }


    public List<Integer> spiralOrder_dfs(int[][] matrix) {
        return null;
    }
}
