package com.dogo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * author       : jangdoyun
 * date         : 25. 3. 11.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 11.  jangdoyun     최초 생성
 */
public class Problem1158 {
    public static void main(String[] args) {

        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 값 입력받기
        int n = scanner.nextInt();

        // 두 번째 값 입력받기
        int k = scanner.nextInt();

        // arrayDeque 자료형 사용
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 결과
        ArrayList<Integer> result = new ArrayList<>();

        // n개 만큼 원형 테이블 생성
        for(int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        // k번째 인덱스 제거
        while(!deque.isEmpty()) {
            for(int i = 0; i < k-1; i++) {
                int notDelete = deque.poll();
                deque.offer(notDelete);
            }

            // k번째 인덱스가 맨 앞으로 왔다.
            result.add(deque.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if(i != result.size()-1) sb.append(", ");
        }
        sb.append(">");

        System.out.printf(sb.toString());

        // Scanner 닫기
        scanner.close();
    }

    /**
     * 시간 : ?? min
     * URL : https://www.acmicpc.net/problem/1158
     * 제목 : 요세푸스
     * 문제 : 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
     * 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
     * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
     * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
     * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
     * 제한사항 :
     */
}