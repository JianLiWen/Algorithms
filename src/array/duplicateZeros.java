package array;

import java.util.Arrays;

/**
 * @Description: 复写零
 * @Author: wenjianli
 * @Date: 2020/12/30 18:40
 */
/*
给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
注意：请不要在超过该数组长度的位置写入元素。
要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 */
public class duplicateZeros {
    public static void main(String[] args) {
        int []arr = new int[]{1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(duplicateZeros(arr)));

    }

    // 暴力解法
    public static int[] duplicateZeros(int []arr){
        int i;
        int j;
        for(i=0;i<arr.length;i++){
            if (arr[i]==0){
                for (j=arr.length-1;j>i;j--){
                    arr[j] = arr[j-1];
                }
                i++;
            }

        }
        return arr;
    }
}
