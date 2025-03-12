package com.dogo;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * author       : jangdoyun
 * date         : 25. 3. 11.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 11.  jangdoyun     최초 생성
 */
public class Lessons76502 {
    public static void main(String[] args) {

        String dogo = "[)(]";
        System.out.println("정답:" + solution(dogo));
    }
    /**
     * NOTE
     *  Stack vs ArrayDeque
     *  Stack은 오래 된 클래스라 거의 사용하지 않으며, 대부분의 경우 ArrayDeque를 사용한다.
     */

    /**
     * 시간 : 30 min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/76502
     * 제목 : 괄호 회전하기
     * 문제 :
     * 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
     * (), [], {} 는 모두 올바른 괄호 문자열입니다.
     * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
     * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
     * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
     * 제한사항 :
     * s의 길이는 1 이상 1,000 이하입니다.
     *
     * @param s
     * @return
     */
    public static int solution(String s) {
        int answer = 0;

        // step 0. s의 길이가 홀수라면 어떤 회전이 발생하여도 올바른 괄호 문자열이 만들어질 수 없다.
        if (s.length() % 2 != 0) return 0;

        // 열린괄호는 넣고, 닫힌 괄호는 넣지않고 자료형에 있는 걸 꺼내야한다.
        // 즉, 닫힌 괄호와 올바른 열린괄호를 쌍으로 하는 자료형이 필요하다
        // 키 : 닫힌괄호
        // 값 : 열린괄호
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        // step 1. s의 길이만큼 회전시킨다.
        A:for (int i = 0; i < s.length(); i++) {
            // i만큼 왼쪽으로 회전했다면 텍스트의 시작은 i번쨰 이며, 회전된 텍스트는 뒤에 붙는다.(원형이므로)
            String bracketsText = s.substring(i, s.length()) + s.substring(0, i);

            // step 2. bracketsText가 올바른 괄호 문자열인지 검증한다.
            // 우선, 스택자료형을 생성한다.
            ArrayDeque<Character> validBrackets = new ArrayDeque<>();
            for (Character bracket : bracketsText.toCharArray()) {
                // 열린 괄호라면 스택에 넣는다.
                if (!brackets.containsKey(bracket)) {
                    validBrackets.push(bracket);
                }
                // 닫힌 괄호라면 스택에 넣지않고 스택에 있는 값을 하나 꺼낸다.
                else {
                    // 닫힌 괄호가 있지만 꺼낼 괄호가 없다면 올바른 괄호 문자열이 아니다.
                    if (validBrackets.isEmpty()) continue;
                    char brackets_pop = validBrackets.pop();

                    // 꺼낸 괄호가 닫힌 괄호에 맞는 열린 괄호가 아니라면 올바른 괄호 문자열이 아니다.
                    if (!brackets.get(bracket).equals(brackets_pop)) {
                        continue A;
                    }
                }
            }

            // 비어 있다면 올바른 괄호 문자열이었다.
            if (validBrackets.isEmpty()) {
                answer += 1;
            }
        }

        return answer;
    }
}