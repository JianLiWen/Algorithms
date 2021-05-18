package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:无重复字符的最长子串
 * @Author: wenjianli
 * @Date: 2021/5/18 10:46
 */

/*
题目：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1


 */
public class LongestSubString {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    // mine-通过，但是太耗时，74ms
    private static int lengthOfLongestSubstring(String s){
        if (s.length()==1){
            return 1;
        }
        Map<Character,Integer> map = new HashMap<>();
        int maxLength =0 ;
        for (int i=0;i<=s.length()-1;i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }else if (map.get(s.charAt(i))== i-1) {
                maxLength = maxLength > map.size() ? maxLength : map.size();
                map.clear();
                map.put(s.charAt(i), i);
            }else {
                Integer index = map.get(s.charAt(i));
                maxLength = maxLength > map.size() ? maxLength : map.size();
                map.clear();
                while (index<=i){
                    map.put(s.charAt(index), index);
                    index ++;
                }
            }
            if (i==s.length()-1){
                maxLength = maxLength >map.size() ? maxLength : map.size();
            }
        }
        return maxLength;
    }
}
