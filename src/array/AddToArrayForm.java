package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Description:数组形式的整数加法
 * @Author: wenjianli
 * @Date: 2020/12/13 22:04
 */
/*
对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。

输入：A = [1,2,0,0], K = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234

输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
输出：[1,0,0,0,0,0,0,0,0,0,0]
解释：9999999999 + 1 = 10000000000
 */
public class AddToArrayForm {
    public static void main(String[] args) {
        int []A = new int[]{9,9,9,9,9,9,9,9,9,9};
        int k = 1;
        System.out.println(addToArrayFromBetter(A,k));
    }
    // 自己写 报错溢出
    public static List<Integer> addToArrayFrom(int []A, int k){
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<A.length;i++){
            sum+=A[i]*Math.pow(10,A.length-1-i);
        }
        sum += k;
        String array = String.valueOf(sum);
        System.out.println(array);
        for (int i=0;i<array.length();i++){
            Integer num = Integer.parseInt(String.valueOf(array.charAt(i)));
            list.add(num);
        }
        return list;
    }

    // 逐位相加： 123+912123+912123+912，我们把它表示成 [1,2,3+912][1, 2, 3+912][1,2,3+912]。然后，我们计算 3+912=9153+912 = 9153+912=915。555 留在当前这一位，将 910/10=91910/10=91910/10=91 以进位的形式加入下一位。
    //然后，我们再重复这个过程，计算 [1,2+91,5][1, 2+91, 5][1,2+91,5]。我们得到 939393，333 留在当前位，将 90/10=990/10=990/10=9 以进位的形式加入下一位。继而又得到 [1+9,3,5][1+9, 3, 5][1+9,3,5]，重复这个过程之后，最终得到结果 [1,0,3,5][1, 0, 3, 5][1,0,3,5]。

    public static List<Integer> addToArrayFromBetter(int []A, int K){
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

}
