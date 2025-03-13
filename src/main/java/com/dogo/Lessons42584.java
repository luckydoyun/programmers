package com.dogo;

/**
 * author       : jangdoyun
 * date         : 25. 3. 11.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 11.  jangdoyun     최초 생성
 */
public class Lessons42584 {
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};
        System.out.println("정답:" + solution(prices));
    }

    /**
     * 시간 : 40 min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42584
     * 제목 : 주식가격
     * 문제 :
     * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
     *
     * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
     * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
     * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
     * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
     * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
     * 제한사항 :
     * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
     * prices의 길이는 2 이상 100,000 이하입니다.
     * @param prices => [1, 2, 3, 2, 3]
     * @return [4, 3, 1, 1, 0]
     */
    public static int[] solution(int[] prices) {
        int[] answer = {};

        // prices의 길이는 곧 시간(초)이다.

        // 어떤 자료형을 이용해야할까..
        // 각 가격을 초 마다 모두 비교해야하나?

        return answer;
    }
}