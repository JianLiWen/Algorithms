package array;

import java.util.ArrayList;
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
        int []A = new int[]{1,2,0,0};
        int k = 34;
        System.out.println(addToArrayFrom(A,k));
    }
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

}
