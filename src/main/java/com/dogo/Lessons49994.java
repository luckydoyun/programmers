package com.dogo;

import java.util.*;
import java.util.stream.IntStream;

/**
 * author       : jangdoyun
 * date         : 25. 3. 11.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 11.  jangdoyun     최초 생성
 */

public class Lessons49994 {
    public static void main(String[] args) {

        String dirs = "ULURRDLLU";
        System.out.println("정답:" + solution(dirs));
    }

    /**
     * 40 min
     * 캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
     * 단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
     * 명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.
     * U: 위쪽으로 한 칸 가기
     * D: 아래쪽으로 한 칸 가기
     * R: 오른쪽으로 한 칸 가기
     * L: 왼쪽으로 한 칸 가기
     *
     * 제한사항
     * dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
     * dirs의 길이는 500 이하의 자연수입니다.
     * @param dirs
     * @return
     */
    public static int solution(String dirs) {
        int answer = 0;

        // 지나간 길을 기억하기위해 HashSet 자료형 사용
        HashSet<String> visitedRoad = new HashSet<>();

        // U D R L 명령어
        Map<String, int[]> cmdMap = new HashMap<>();
        cmdMap.put("U", new int[]{0, 1});
        cmdMap.put("D", new int[]{0, -1});
        cmdMap.put("R", new int[]{1, 0});
        cmdMap.put("L", new int[]{-1, 0});

        int x = 0;
        int y = 0;

        // dirs 명령어를 수행
        for( String cmd : dirs.split("")) {
            int cmd_x = x + cmdMap.get(cmd)[0];
            int cmd_y = y + cmdMap.get(cmd)[1];

            // 명령어 후 좌표가 유효한지 검토. 유효하지않다면 continue
            if(Math.abs(cmd_x) > 5 || Math.abs(cmd_y) > 5) {
                continue;
            }

            // 명령어 수행 후 지나간 길을 기억
            // 출발지 <-> 도착지
            visitedRoad.add(x + "," + y + "<->" + cmd_x + "," + cmd_y);
            visitedRoad.add(cmd_x + "," + cmd_y  + "<->" +  x + "," + y);

            // 현재 위치 = 명령어 수행 후 위치
            x = cmd_x;
            y = cmd_y;
        }

        // 방문한 길의 길이
        // 출발지, 도착지 양방향을 관리했으므로 2로 나눈다.
        answer = visitedRoad.size()/2;

        return answer;
    }

}

