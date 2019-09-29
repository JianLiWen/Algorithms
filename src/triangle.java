/*给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
        例如，给出的三角形如下：
        [↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]
        最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。*/
// 给定一个三角形，找出从顶到底的最小路径和，每一步可以从上一行移动到下一行相邻的数字
//    [
//         [2],                 [2],
//        [3,4],              [3, 4],            [2],
//       [6,5,7],      ==>   [7, 6, 10]     ==>  [9, 10]   ==>     [11]
//      [4,1,8,3]
//    ]

import java.util.ArrayList;

/**思路:
 * 自底向上 dp: 不需要额外的空间
 * dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j]
 * dp[i][j]: 表示到达 (i, j)最小路径的总和
 */
public class triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i+1).size()-1;j++){
                int min = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,triangle.get(i).get(j)+min);
            }
        }
        return  triangle.get(0).get(0);
    }
}
