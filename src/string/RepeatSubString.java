package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:重复的字符串
 * @Author: wenjianli
 * @Date: 2020/12/27 21:28
 */
/*
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
输入: "abab"
输出: True
解释: 可由子字符串 "ab" 重复两次构成。

输入: "aba"
输出: False
输入: "abcabcabcabc"
输出: True
解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class RepeatSubString {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(repeatedSubstringPatternBetter(s));
    }

    // 理解错题意思，先保留着吧
    public static boolean repeatedSubstringPattern(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        List<Integer> valueList = new ArrayList<>(map.values());
        List<Character> keyList = new ArrayList<>(map.keySet());
        int value = valueList.get(0);
        if (keyList.size() == 1) {
            return true;
        }
        for (int i = 1; i < valueList.size(); i++) {
            if (valueList.get(i) != value) {
                return false;
            }
        }
        return true;
    }

    public static boolean repeatedSubstringPatternBetter(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
