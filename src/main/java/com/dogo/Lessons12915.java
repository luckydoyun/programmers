package com.dogo;

import java.util.*;

/**
 * author       : jangdoyun
 * date         : 25. 3. 11.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 11.  jangdoyun     최초 생성
 */
public class Lessons12915 {
    public static void main(String[] args) {

        String[] strings = {"cdx", "abce", "abcd"};
        int n = 2;
        System.out.println("정답:" + solution(strings, n));
    }

    /**
     * 시간 : min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12915
     * 제목 : 문자열 내 마음대로 정렬하기
     * 문제 : 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
     * 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
     * 제한사항 : strings는 길이 1 이상, 50이하인 배열입니다.
     * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
     * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
     * 모든 strings의 원소의 길이는 n보다 큽니다.
     * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
     * @return
     */
    public static String[] solution(String[] strings, int n) {
        String[] answer = {};

        // n번째 인덱스를 키값으로 String 배열을 가지고 있는 map
        Map<Character, String[]> result = new TreeMap<>();

        for(String string : strings) {
            Character c = string.charAt(n);
            // 이미 n번쨰 인덱스가 존재한다면
            if(result.containsKey(c)) {
                String[] temp = result.get(c);

                // 새 배열 생성 및 값 추가
                String[] newArray = Arrays.copyOf(temp, temp.length + 1);
                newArray[temp.length] = string;

                // 사전순 정렬
                Arrays.sort(newArray);
                result.put(c, newArray);
            } else {
                result.put(c, new String[]{string});
            }
        }

        // 배열 리스트 생성 후 String[]로 변경
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<Character, String[]> entry : result.entrySet()) {
            for (String s : entry.getValue()) {
                list.add(s);
            }
        }

        answer = list.toArray(answer);
        return answer;
    }
}