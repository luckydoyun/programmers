package com.dogo;

import java.util.Stack;

/**
 * author       : jangdoyun
 * date         : 25. 3. 12.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 12.  jangdoyun     최초 생성
 */
public class Lessons12909 {
    public static void main(String[] args) {

        String dogo = "()))";
        System.out.println("정답:" + solution(dogo));
    }
    /**
     * NOTE
     *  String 으로 문자열을 문자 배열처럼 나눴더니 시간초과가 발생하였다.
     *  Character로 변경했더니 시간초과가 해결되었다.
     *  문자를 얻기위해 String을 split("") 한다면 추가적인 메모리와 연산이 필요하다.
     *  문자열을 .toCharArray()를 한다면 기본적으로 순회하기 떄문에 메모리 오버헤드와 불필요한 객체 생성이 줄어든다.
     */

    /**
     * 시간 : 30 min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12909
     * 제목 : 올바른 괄호
     * 문제 :
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
     * "()()" 또는 "(())()" 는 올바른 괄호입니다.
     * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
     * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
     * 제한사항 :
     * 문자열 s의 길이 : 100,000 이하의 자연수
     * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
     *
     * @param s
     * @return
     */
    static boolean solution(String s) {

        // 올바른 괄호가 되기 위해서는 반드시 짝수여야한다.
        if(s.length() % 2 != 0) return false;

        // 닫힌 괄호로 시작한다면 올바른 괄호가 아니다.
        if(s.charAt(0) == ')') return false;

        // 올바른 괄호를 검증하기위해 스택 자료형을 사용한다.
        Stack<Character> stack = new Stack<>();

        // Step 1. 올바른 괄호인지 검증한다.
        for(Character parentheses : s.toCharArray()) {
            // 열린 괄호는 넣는다.
            if(parentheses.equals('(')) {
                stack.push(parentheses);
            }
            // 닫힌 괄호라면 스택에 있는 괄호를 꺼낸다.
            else if(parentheses.equals(')')) {
                // 닫힌 괄호여서 스택에 있는 괄호를 꺼내야하지만 비어있다면 올바른 괄호를 완성 시킬 수 없다.
                if(stack.isEmpty()) return false;
                Character parentheses_pop = stack.pop();

                // 닫힌 괄호를 꺼냈을 때 스택에 남아있는 맨 위는 열린 괄호여야 올바른 괄호이다.
                if(parentheses_pop == null || !parentheses_pop.equals('(')) {
                    // 올바른 괄호가 아니다.
                    return false;
                }
            }
        }

        // Step 2. 올바른 괄호인지 검증이 끝난 후 스택이 비어있지 않으면 문자열 s는 올바른 괄호가 아니다.
        if(!stack.isEmpty()) return false;

        // Step 3. 모든 검증이 완료되었다면 문자열 s는 올바른 괄호이다.

        return true;
    }

}
