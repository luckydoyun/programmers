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
public class Lessons72411 {
    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println("정답:" + solution(orders, course));
    }

    /**
     * 시간 : min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/72411
     * 제목 : 메뉴 리뉴얼
     * 문제 : 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
     * 기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다.
     * 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
     * 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.
     * 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때,
     * 스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
     * 제한사항 : orders 배열의 크기는 2 이상 20 이하입니다.
     * orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
     * 각 문자열은 알파벳 대문자로만 이루어져 있습니다.
     * 각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
     * course 배열의 크기는 1 이상 10 이하입니다.
     * course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
     * course 배열에는 같은 값이 중복해서 들어있지 않습니다.
     * 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
     * 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
     * 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
     * orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.
     *
     * @param
     * @return
     */
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        // 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
        // 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함

        // 코스요리 후보
        ArrayList<String> result = new ArrayList<>();

        // 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수
        for (int i = 0; i < course.length; i++) {
            // 단품메뉴들의 갯수
            int course_menu_count = course[i];

            // 단품메뉴들의 갯수에 맞는 코스요리 후보 뽑기
            for (String order : orders) {
                int index = 0;
                int init = 0;

                while (true) {
                    if(index + course_menu_count > order.length()) {
                        init += 1;
                        index = init;
                        continue;
                    }
                    String t = order.substring(index, index + course_menu_count);
                    System.out.printf("t:%s\n", t);

                    // 위치 변경
                    index += 1;
                }
            }
        }


        return answer;
    }
}