package com.hr.top100;

import java.util.Stack;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 */
public class IsValid_20 {

    public boolean isValid(String s) {
        
        if (s.length() <= 1 || s.length() % 2 != 0) return false;
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : cs) {
            if (!stack.isEmpty() && this.isMath(c, stack.peek()))
                stack.pop();
            else
                stack.push(c);
        }
        return stack.isEmpty();
    }
    
    private boolean isMath(char c2, char c1) {
        if (c1 == '(') return c2 == ')';
        if (c1 == '[') return c2 == ']';
        if (c1 == '{') return c2 == '}';
        return false;
    }

    public static void main(String[] args) {

        IsValid_20 instance = ReflectUtils.getInstance(IsValid_20.class);
        System.out.println(instance.isValid("{{[]}}"));
        System.out.println(instance.isValid("[{()]}"));
        System.out.println(instance.isValid("[{(}}]"));
    }

}
