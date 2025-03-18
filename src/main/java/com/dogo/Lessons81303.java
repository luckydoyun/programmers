package com.dogo;

import java.util.ArrayDeque;
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
public class Lessons81303 {
    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println("정답:" + solution(n, k, cmd));
    }

    /**
     * 시간 : 80 min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/81303
     * 제목 : 표 편집
     * 문제 : 업무용 소프트웨어를 개발하는 니니즈웍스의 인턴인 앙몬드는 명령어 기반으로 표의 행을 선택, 삭제, 복구하는 프로그램을 작성하는 과제를 맡았습니다. 세부 요구 사항은 다음과 같습니다.
     * 위 그림에서 파란색으로 칠해진 칸은 현재 선택된 행을 나타냅니다. 단, 한 번에 한 행만 선택할 수 있으며, 표의 범위(0행 ~ 마지막 행)를 벗어날 수 없습니다. 이때, 다음과 같은 명령어를 이용하여 표를 편집합니다.
     *
     * "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
     * "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
     * "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
     * "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
     * 예를 들어 위 표에서 "D 2"를 수행할 경우 아래 그림의 왼쪽처럼 4행이 선택되며, "C"를 수행하면 선택된 행을 삭제하고,
     * 바로 아래 행이었던 "네오"가 적힌 행을 선택합니다(4행이 삭제되면서 아래 있던 행들이 하나씩 밀려 올라오고, 수정된 표에서 다시 4행을 선택하는 것과 동일합니다).
     *
     * 처음 표의 행 개수를 나타내는 정수 n, 처음에 선택된 행의 위치를 나타내는 정수 k, 수행한 명령어들이 담긴 문자열 배열 cmd가 매개변수로 주어질 때,
     * 모든 명령어를 수행한 후 표의 상태와 처음 주어진 표의 상태를 비교하여 삭제되지 않은 행은 O, 삭제된 행은 X로 표시하여 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
     * 제한사항 :
     * @param
     * @return
     */
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";

        // n : 표의 행 개수
        // k : 처음에 선택된 행의 위치
        // cmd : 수행한 명령어들이 담긴 문자열

        Map<Integer, Boolean> grid = new HashMap<>();

        // grid 를 0 부터 n까지 초기화 시킨다. 모두 ture
        for(int i = 0; i < n; i++) {
            grid.put(i, true);
        }

        // 가장 최근에 삭제된 행의 위치
        ArrayDeque<Integer> deletedRow = new ArrayDeque<>();

        // 현재 행의 위치
        int presentIndex = k;

        // step 1. 명령어를 수행한다.
        for(String cmd_ : cmd) {

            // 어떤 명령어인지 파악한다.
            String cmd_type = cmd_.substring(0, 1);
            int cmd_num = -1;
            if(cmd_type.equals("U") || cmd_type.equals("D")) {
                cmd_num = Integer.parseInt(cmd_.substring(2));
            }

            // 명령어 수행
            if(cmd_type.equals("U")) {
                // 이동 명령어 만큼
                while(cmd_num > 0) {
                    // 이동할 수 있는지 체크

                    // 맨 위로는 이동할 수 없으므로
                    if(presentIndex == 0) {
                        break;
                    }

                    // 위로 1칸 이동
                    if(presentIndex != 0 && grid.get(presentIndex - 1)) {
                        presentIndex -= 1;
                        cmd_num -= 1;
                    } else {
                        presentIndex += 1;
                    }
                }

            }else if(cmd_type.equals("D")) {
                // 이동 명령어 만큼
                while(cmd_num > 0) {
                    // 이동할 수 있는지 체크

                    // 맨 아래로는 이동할 수 없으므로
                    if(presentIndex == n-1) {
                        break;
                    }

                    // 위로 1칸 이동
                    if(presentIndex != 0 && grid.get(presentIndex + 1)) {
                        presentIndex += 1;
                        cmd_num -= 1;
                    } else {
                        presentIndex += 1;
                    }
                }

            }else if(cmd_type.equals("C")) {
                // 현재 위치 삭제 후 삭제 스택에 저장
                grid.put(presentIndex, false);
                deletedRow.push(presentIndex);

                // 현재 위치 조정
                presentIndex += 1;
                while(true) {

                }

            }else if (cmd_type.equals("Z")) {

            }

        }


        return answer;
    }

}