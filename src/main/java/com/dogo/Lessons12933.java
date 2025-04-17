package com.dogo;

import java.util.ArrayList;

/**
 * author       : jangdoyun
 * date         : 25. 3. 11.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 11.  jangdoyun     최초 생성
 */
public class Lessons12933 {
    public static void main(String[] args) {

        int n = 118372;
        System.out.println("정답:" + solution(n));
    }

    /**
     * 시간 : min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12933
     * 제목 : 정수 내림차순으로 배치하기
     * 문제 : 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
     * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
     * 제한사항 : n은 1이상 8000000000 이하인 자연수입니다.
     * @return
     */
    public static long solution(long n) {
        long answer = 0;

        ArrayList<Integer> result = new ArrayList<>();
        for(char c : String.valueOf(n).toCharArray()) {
            int i = Character.getNumericValue(c);
            result.add(i);
        }

        result.sort((o1, o2) -> o2 - o1);

        StringBuilder sb = new StringBuilder();
        for(int i : result) {
            sb.append(i);
        }

        answer = Long.parseLong(sb.toString());

        return answer;
    }
}