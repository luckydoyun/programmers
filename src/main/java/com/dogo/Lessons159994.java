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
public class Lessons159994 {
    public static void main(String[] args) {

        String[] card1 = {"i", "drink", "water"};
        String[] card2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println("정답:" + solution(card1, card2, goal));
    }

    /**
     * 시간 : min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/159994
     * 제목 : 카드 뭉치
     * 문제 : 코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다. 코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.
     * 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
     * 한 번 사용한 카드는 다시 사용할 수 없습니다.
     * 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
     * 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
     * 예를 들어 첫 번째 카드 뭉치에 순서대로 ["i", "drink", "water"], 두 번째 카드 뭉치에 순서대로 ["want", "to"]가 적혀있을 때 ["i", "want", "to", "drink", "water"] 순서의 단어 배열을 만들려고 한다면 첫 번째 카드 뭉치에서 "i"를 사용한 후 두 번째 카드 뭉치에서 "want"와 "to"를 사용하고 첫 번째 카드뭉치에 "drink"와 "water"를 차례대로 사용하면 원하는 순서의 단어 배열을 만들 수 있습니다.
     * 문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때, cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.
     * 제한사항 : 1 ≤ cards1의 길이, cards2의 길이 ≤ 10
     * 1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
     * cards1과 cards2에는 서로 다른 단어만 존재합니다.
     * 2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
     * 1 ≤ goal[i]의 길이 ≤ 10
     * goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
     * cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.
     * @param
     * @return
     */
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        // goal에 도달하기위해 cards1 과 cards2에서 하나씩 꺼내서 goal에 있는 값과 비교하여 goal를 비워낼 수 있는지 체크

        // cards1 과 cards2 초기화 goal 초기화
        ArrayDeque<String> card1Queue = new ArrayDeque<>();
        ArrayDeque<String> card2Queue = new ArrayDeque<>();
        ArrayDeque<String> goalQueue = new ArrayDeque<>();
        for(String card : cards1) {
            card1Queue.offer(card);
        }
        for(String card : cards2) {
            card2Queue.offer(card);
        }
        for(String card : goal) {
            goalQueue.offer(card);
        }

        while(!goalQueue.isEmpty()) {

            // goal, cards1, cards2 맨 앞에 있는 단어
            String goalWord = goalQueue.peekFirst();

            String card1Word = "";
            if(!card1Queue.isEmpty()) {
                card1Word = card1Queue.peekFirst();
            }

            String card2Word = "";
            if(!card2Queue.isEmpty()) {
                card2Word = card2Queue.peekFirst();
            }

            // 2개의 카드가 goalWord를 만족할 수 없다면 종료
            if(!card1Word.equals(goalWord) && !card2Word.equals(goalWord)) {
                break;
            }

            // card1에 있는 단어가 goalWord 를 만족한다면
            if(card1Word.equals(goalWord)) {
                goalQueue.poll();
                card1Queue.poll();
                continue;
            }

            // card2에 있는 단어가 goalWord 를 만족한다면
            if(card2Word.equals(goalWord)) {
                goalQueue.poll();
                card2Queue.poll();
            }
        }

        answer = goalQueue.isEmpty() ? "Yes" : "No";

        return answer;
    }
}