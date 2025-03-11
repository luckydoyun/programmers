package com.dogo;

import java.util.ArrayList;
import java.util.Arrays;
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
     *
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
        return answer;
    }

}

