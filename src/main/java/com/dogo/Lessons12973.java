package com.dogo;

import java.util.ArrayDeque;

/**
 * author       : jangdoyun
 * date         : 25. 3. 11.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 11.  jangdoyun     최초 생성
 */
public class Lessons12973 {
    public static void main(String[] args) {

        String dogo = "baabaa";
        System.out.println("정답:" + solution(dogo));
        System.out.println("정답:" + solution1(dogo));
    }
    /**
     * NOTE
     *  문제 해결은 100점이지만, 효율성 테스트는 0점이다.
     *  아마 자료형을 잘 못 써서 최악의 경우일 때 최악인 시간복잡도가 발생하는 것 같다.
     *  자료형 활용을 잘해아한다.
     */

    /**
     * 시간 : 30 min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12973
     * 제목 : 짝지어 제거하기
     * 문제 :
     * 짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다.
     * 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다.
     * 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
     * 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요.
     * 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
     *
     * 예를 들어, 문자열 S = baabaa 라면
     *
     * b aa baa → bb aa → aa →
     *
     * 의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
     * 제한사항 :
     * 문자열의 길이 : 1,000,000이하의 자연수
     * 문자열은 모두 소문자로 이루어져 있습니다.
     * @param s
     * @return
     */
    public static int solution(String s)
    {
        int answer = 0;

        // 문자열의 길이가 홀수라면 짝지어 제거할 수 없다.
        if(s.length() % 2 != 0) return answer;

        // step 1. first, second 변수를 이용해서 문자열을 비교한다.
        // 초기값
        int first = 0;
        int second = 1;

        while(true) {
            if(s.length() <= first || s.length() <= second) break;
            if(first < 0 || second < 0) break;

            // 비교 대상의 문자열이 같다면 제거한다.
            if (s.charAt(first) == s.charAt(second)) {
                s = s.substring(0, first) + s.substring(second + 1);

                if(first != 0) {
                    first -= 1;
                    second -= 1;
                }
            }
            // 비교 대상의 문자열이 같지 않다면
            else {
                first += 1;
                second += 1;
            }
        }

        if(s.isEmpty()) answer = 1;

        return answer;
    }

    public static int solution1(String s)
    {
        int answer = 0;

        // 문자열의 길이가 홀수라면 짝지어 제거할 수 없다.
        if(s.length() % 2 != 0) return answer;

        // 스택자료형을 활용하기 위해 Arraydeque를 활용한다.
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);

            // step 1. 스택에 맨 위에 문자가 word와 동일하다면 제거한다.
            //주의) 스택 자료형이 비어있는지 항상 체크한다.
            if(!stack.isEmpty() && stack.peek() == word) {
                stack.pop();
            }
            // step 2. 스택이 비어있거나, 스택 맨 위에 문자가 word와 동일하지 않다면 word를 넣는다.
            else {
                stack.push(word);
            }
        }

        // step 3. 스택이 비어있다면 짝지어 제거하기 완료 = 1, 미완료 = 0
        answer = stack.isEmpty() ? 1 : 0;

        return answer;
    }
}