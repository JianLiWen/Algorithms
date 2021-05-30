package string;

import java.util.Stack;

/**
 * @Description:有效的括号
 * @Author: wenjianli
 * @Date: 2021/5/30 22:04
 */
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。

输入：s = "()"
输出：true

输入：s = "()[]{}"
输出：true
输入：s = "([)]"
输出：false
输入：")"
输出：false
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }

    // mine-通过 耗时2ms
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                Character c = stack.peek();
                if (c == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else if (c == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else if (c == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
