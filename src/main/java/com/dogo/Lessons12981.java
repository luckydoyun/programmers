package com.dogo;

import java.util.ArrayDeque;
import java.util.Deque;
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
public class Lessons12981 {
    public static void main(String[] args) {

        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println("정답:" + solution(n, words));
    }

    /**
     * 시간 : min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/12981
     * 제목 : 영어 끝말잇기
     * 문제 : 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때,
     * 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.
     * 제한사항 : 끝말잇기에 참여하는 사람의 수 n은 2 이상 10 이하의 자연수입니다.
     * words는 끝말잇기에 사용한 단어들이 순서대로 들어있는 배열이며, 길이는 n 이상 100 이하입니다.
     * 단어의 길이는 2 이상 50 이하입니다.
     * 모든 단어는 알파벳 소문자로만 이루어져 있습니다.
     * 끝말잇기에 사용되는 단어의 뜻(의미)은 신경 쓰지 않으셔도 됩니다.
     * 정답은 [ 번호, 차례 ] 형태로 return 해주세요.
     * 만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.
     * @return
     */
    public static int[] solution(int n, String[] words) {
        int[] answer = {};

        // 가장 먼저 탈락한 사람의 번호, 그 사람이 자신의 몇번 째 탈락하는지
        // <참가자번호, 참가자차례>
        Map<Integer, Integer> participants = new HashMap<>();

        // 탈락한 참가자
        int failParticipant = 0;
        // 탈락한 참가자가 본인의 몇번 째였는지
        int participantRound = 0;

        // 끝말잇기
        Deque<String> endWordPlay = new ArrayDeque<>();

        for (int i = 0; i < words.length; i++) {
            // 참가자
            int participant = -1;

            // 몇 번째 라운드인지
            int round = i+1;

            // 몇 번 참가자 인지
            if (round%n == 0) {
                participant = n;
            } else {
                participant = round%n;
            }

            // 어떤 단어를 말했는지
            String word = words[i];

            // 올바른 끝말잇기였는지 확인
            // 끝말있기판이 비어있는지 확인
            if(!endWordPlay.isEmpty()) {
                String endWord = endWordPlay.peek();
                // 마지막 끝말잇기의 마지막 알파벳과, 현재 단어의 첫 번째 알파벳
                if(endWord.charAt(endWord.length()-1) != word.charAt(0)) {
                    failParticipant = participant;
                    participantRound = participants.getOrDefault(participant, 0) + 1;
                    break;
                }
            }

            // 이미 말한 단어 인지 확인
            if(endWordPlay.contains(word)) {
                failParticipant = participant;
                participantRound = participants.getOrDefault(participant, 0) + 1;
                break;
            }

            // 올바른 끝말잇기였다면 다음 참가자로
            endWordPlay.push(word);
            participants.put(participant, participants.getOrDefault(participant, 0) + 1);
        }

        answer = new int[] {failParticipant, participantRound};

        return answer;
    }
}