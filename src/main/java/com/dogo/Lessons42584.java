package com.dogo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("정답:" + solution1(prices));
    }

    /**
     * NOTE
     *  요구사항을 잘못 파악했다.
     */

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
    public static int[] solution1(int[] prices) {
        int[] answer = {};
        return answer;
    }


    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // prices의 길이는 곧 시간(초)이다.

        // 어떤 자료형을 이용해야할까..
        // 각 가격을 초 마다 모두 비교해야하나?
        // map 자료형 사용 <주식 가격이 얼마인지 인덱스, 유지한 초>
        Map<Integer, Integer> priceStableDurationMap =new HashMap<>();

        // 시간이 흐른다.
        for(int i = 0; i < prices.length; i++) {
            // 현재 주식
            int presentPrice = prices[i];

            // step 1. 1초가 흘렀으니, 기존에 존재하는 주식가격이 떨어졌는지 확인한 후 방어했다면 주식가격 방어 시간을 늘린다.
            if(!priceStableDurationMap.isEmpty()) {
                for(Integer priceIndex : priceStableDurationMap.keySet()) {
                    // 주식 가격 방어 시간
                    int stableSec = priceStableDurationMap.get(priceIndex);

                    // 주식 가격
                    int price = prices[priceIndex];

                    // 주식 가격 방어 검증
                    if(presentPrice >= price) {
                        priceStableDurationMap.put(priceIndex, stableSec + 1);
                    } else {
                        priceStableDurationMap.put(priceIndex, stableSec);
                    }
                }
            }

            // step 2. 현재 주식 가격을 map에 저장한다.
            priceStableDurationMap.put(i, 0);
        }

        // step 3. 가격을 방어한 시간은 value에 있다.
        priceStableDurationMap.forEach((k,v) -> answer[k] = v);

        System.out.println( Arrays.toString(answer));

        return answer;
    }
}