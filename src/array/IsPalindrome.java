package array;

/**
 * @Description: 回文数
 * @Author: wenjianli
 * @Date: 2021/5/27 16:40
 */
/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

输入：x = 121
输出：true

输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class IsPalindrome {

    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindromeBetter(x));
    }

    // mine-通过，耗时12ms，转换成字符串用反转的方式
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuffer sb = new StringBuffer(str);
        if (sb.reverse().toString().equals(str)){
            return true;
        }
        return false;
    }

    // mine-通过，较优解，利用整数反转的方法，不断除和取余
    public static boolean isPalindromeBetter(int x) {
        int rev = 0;
        int num = x;
        if (x < 0){
            return false;
        }
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return false;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        if (rev==num){
            return true;
        }
        return false;
    }
}
