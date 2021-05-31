package others;

/**
 * @Description:爬楼梯
 * @Author: wenjianli
 * @Date: 2021/5/31 11:46
 */

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }

    // 我的思路是递归，但是超时了，最佳方法是动态规划，考虑将其划分为一个个子问题
    public static int climbStairs(int n) {
      int[] dp=new int[n+1];
      dp[0] = 1;
      dp[1] = 1;
      for (int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
      }
      return dp[n];
    }

}
