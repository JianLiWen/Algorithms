package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 三角形最小路径和
 * @Author: wenjianli
 * @Date: 2021/1/19 20:35
 */
/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 */
public class minimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(-1);
        list3.add(-3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        System.out.println(minimumTotal(triangle));

    }

    // 1、状态定义：dp[i][j]dp[i][j]dp[i][j] 表示从点 (i,j)(i, j)(i,j) 到底边的最小路径和。
    //2、状态转移：dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n+1][n+1];
        for (int i=n-1;i>=0;i--){
            for (int j=0;j<=i;j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

}
