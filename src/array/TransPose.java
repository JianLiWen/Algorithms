package array;

import java.util.Arrays;

/**
 * @Description: 转置矩阵
 * @Author: wenjianli
 * @Date: 2020/12/12 11:32
 */

/*
给定一个矩阵 A， 返回 A 的转置矩阵。

矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
输入：[[1,2,3],[4,5,6],[7,8,9]]
输出：[[1,4,7],[2,5,8],[3,6,9]]

输入：[[1,2,3],[4,5,6]]
输出：[[1,4],[2,5],[3,6]]
 */
public class TransPose {
    public static void main(String[] args) {
        int [][]nums = {{1,2,3},{4,5,6}};
        int [][]B = transpose(nums);
        System.out.println("转置矩阵为：" + Arrays.deepToString(B));
    }

    // mine-一次通过：思路：构建一个二维数组，把原来的行赋值给列，把列赋值给行
    public static int[][] transpose(int [][]A){
        int rows = A.length;
        int columns = A[0].length;
        int [][]B = new int[columns][rows];
        for (int i=0;i<columns;i++){
            for (int j=0;j<rows;j++){
                B[i][j] =  A[j][i];
            }
        }
        return B;
    }
}
