package com.dogo;

import java.util.ArrayDeque;
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
public class Lessons42888 {

    // 유저의 uid와 닉네임을 관리하기위해 hash 자료형을 사용한다
    private static final Map<String, String> userMap = new HashMap<>();
    // uid 기반 Record와 nickName 기반 Record를 관리한다.
    private static final ArrayDeque<String> uidRecord = new ArrayDeque<>();
    private static final ArrayDeque<String> nickNameRecord = new ArrayDeque<>();

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        // String[] answer = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        System.out.println("정답:" + solution(record));
    }

    /**
     * 시간 : min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42888
     * 제목 : 오픈채팅방
     * 문제 : 카카오톡 오픈채팅방에서는 친구가 아닌 사람들과 대화를 할 수 있는데, 본래 닉네임이 아닌 가상의 닉네임을 사용하여 채팅방에 들어갈 수 있다.
     * 신입사원인 김크루는 카카오톡 오픈 채팅방을 개설한 사람을 위해, 다양한 사람들이 들어오고, 나가는 것을 지켜볼 수 있는 관리자창을 만들기로 했다. 채팅방에 누군가 들어오면 다음 메시지가 출력된다.
     *
     * 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
     * 제한사항 : record는 다음과 같은 문자열이 담긴 배열이며, 길이는 1 이상 100,000 이하이다.
     * 다음은 record에 담긴 문자열에 대한 설명이다.
     * 모든 유저는 [유저 아이디]로 구분한다.
     * [유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")
     * [유저 아이디] 사용자가 채팅방에서 퇴장 - "Leave [유저 아이디]" (ex. "Leave uid1234")
     * [유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")
     * 첫 단어는 Enter, Leave, Change 중 하나이다.
     * 각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.
     * 유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.
     * 유저 아이디와 닉네임의 길이는 1 이상 10 이하이다.
     * 채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.
     * @param
     * @return
     */
    public static String[] solution(String[] record) {
        String[] answer = {};

        // 카카오톡 reocrd를 기반으로 uid 기록을 관리한다.
        for(String record_ : record) {
            String[] splitRecord = record_.split(" ");
            String cmd = splitRecord[0];
            String uid = splitRecord[1];
            String nickName = "";
            if(splitRecord.length == 3) {
                nickName = splitRecord[2];
            }
            // cmd, uid, nickName 을 기반으로 uid 기록을 생성한다.
            cmd(cmd,uid, nickName);
        }

        // uid 기록을 바탕으로 nickName 기반 기록을 생성한다.
        while(!uidRecord.isEmpty()) {
            String[] splitUidRecord = uidRecord.poll().split(" ");
            String cmd = splitUidRecord[0];
            String uid = splitUidRecord[1];
            String nickName = userMap.get(uid);

            if(cmd.equals("Enter")) {
                String recordText = "\"" + nickName + "님이 들어왔습니다.\"";
                nickNameRecord.offer(recordText);

            }else if(cmd.equals("Leave")) {
                String recordText = "\"" + nickName + "님이 나갔습니다.\"";
                nickNameRecord.offer(recordText);
            }
        }

//        answer = new String[nickNameRecord.size()];
//        int idx= 0;
//        for(String nickNameRecord_ : nickNameRecord) {
//            answer[idx++] = nickNameRecord_;
//        }

        // Java의 Collection 인터페이스에 정의된 메서드 사용
        // 컬렉션 데이터를 주어진 타입의 배열(T[])로 만들어 반환
        answer = nickNameRecord.toArray(new String[0]);

        return answer;
    }

    private static void cmd(String cmd, String uid, String nickName) {
        // Enter, Leave, Change 3가지 케이스
        if(cmd.equals("Enter")) {
            userMap.put(uid, nickName);
            uidRecord.offer(cmd+ " " + uid);
        }else if(cmd.equals("Leave")) {
            uidRecord.offer(cmd+ " " + uid);
        }else if(cmd.equals("Change")) {
            if(userMap.containsKey(uid)) {
                userMap.put(uid, nickName);
            }
        }
    }
}