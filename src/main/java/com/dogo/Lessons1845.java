package com.dogo;

import java.util.HashMap;
import java.util.HashSet;
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
public class Lessons1845 {
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 3};
        System.out.println("정답:" + solution(nums));
    }

    /**
     * 시간 : min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/1845
     * 제목 : 폰켓몬
     * 문제 : 당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
     * N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
     * 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
     * 제한사항 : nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
     * nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
     * 폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
     * 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
     *
     * @return
     */
    public static int solution(int[] nums) {
        int answer = 0;

        // 선택할 수 있는 최대 마릿 수, nums는 항상 짝수 갯수이다.
        int choice = nums.length / 2;

        Map<String, Integer> choiceMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            choiceMap.put(String.valueOf(nums[i]), choiceMap.getOrDefault(String.valueOf(nums[i]), 0) + 1);

            // 여러 종류의 폰켓몬을 고를 때 최대 마릿 수에 도달한 다면 멈추는 것이 성능에 좋다. (왜냐하면 종류 개수의 최댓값 하나만 return 하면 되므로)
            if (choiceMap.size() == choice) {
                break;
            }
        }

        answer = choiceMap.size();

        return answer;
    }
}