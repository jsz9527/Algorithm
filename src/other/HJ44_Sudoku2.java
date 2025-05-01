package other;

import java.util.Scanner;

//数独
public class HJ44_Sudoku2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = in.nextInt();
            }
        }

        solveSudoku(board, 0, 0);

        //输出二维矩阵
        for(int i=0;i<9;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println(board[i][8]);//换行，每一行的最后一个数字
        }
    }

    public static boolean solveSudoku(int[][] board, int i, int j){
		// 跳过原始数字
		if (board[i][j] != 0){
			if(i == 8 && j == 8) {
				return true;
			}

			if (j == 8) {
				return solveSudoku(board, i + 1, 0);
			} else {
				return solveSudoku(board, i, j + 1);
			}
		}else {
			for (int k = 1; k <= 9; k++) {
				// (i, j) 这个位置放k是否合适
				if (isValidSudoku(i, j, k, board)) {
					//将k放在（i，j）
					board[i][j] = k;

					//递归
					if(i == 8 && j == 8){
						return true;
					}
					if( j == 8){
						if( solveSudoku(board, i + 1, 0) ){
							return true;
						}
						board[i][j] = 0;//回溯
					}else {
						if( solveSudoku(board, i, j + 1) ){
							return true;
						}
						board[i][j] = 0;//回溯
					}
				}
			}
			return false;
		}

    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     *     同行是否重复
     *     同列是否重复
     *     9宫格里是否重复
     */
    public static boolean isValidSudoku(int row, int col, int val, int[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }


}
