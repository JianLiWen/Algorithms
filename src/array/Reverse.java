package array;


/**
 * @Description: 整数反转
 * @Author: wenjianli
 * @Date: 2020/12/24 22:00
 */

/*
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。

输入：x = 123
输出：321

输入：x = -123
输出：-321

输入：x = 120
输出：21

 */
public class Reverse {
    public static void main(String[] args) {
        int num = -123;
        System.out.println(reverse(num));
    }

    // mine-通过，用时9ms，我的思路是转换成字符串去反转操作
    public static int reverse(int x) {

        if (x ==0)
            return 0;

        String str = String.valueOf(Math.abs(x));
        StringBuffer numStr = new StringBuffer(str);
        String reverseStr = numStr.reverse().toString();
        String str2 = reverseStr;
        if (reverseStr.contains("-")){
           str2 =  reverseStr.substring(0,reverseStr.length()-1);
        }
        Long num = 0L;
        if (x>0){
            num = Long.valueOf(str2);
        }else {
            num = Long.valueOf(str2) * -1;
        }

        if (num<= Integer.MIN_VALUE || num>= Integer.MAX_VALUE){
            return 0;
        }
        return num.intValue();
    }

    // 最优解法
    public int reverseBetter(int x) {

        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;

    }
}
