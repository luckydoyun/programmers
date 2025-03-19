package com.dogo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * author       : jangdoyun
 * date         : 25. 3. 11.
 * description  :
 * ===============================
 * DATE     AUTHOR      NOTE
 * -------------------------------
 * 25. 3. 11.  jangdoyun     최초 생성
 */
public class Lessons42586 {
    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println("정답:" + solution(progresses, speeds));
    }

    /**
     * 시간 : min
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=java
     * 제목 : 기능개발
     * 문제 : 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
     * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
     * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
     * 제한사항 : 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
     * 작업 진도는 100 미만의 자연수입니다.
     * 작업 속도는 100 이하의 자연수입니다.
     * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
     * @param
     * @return [2, 1]
     */
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> deploy = new ArrayDeque<>();

        // 작업의 개수와 작업 속도를 계산해서 몇 일에 배포가 가능한지 큐 자료형으로 저장
        for(int i = 0; i < progresses.length; i++) {
            int remainProg = 100 - progresses[i];
            int deployDay = remainProg / speeds[i];

            if(remainProg % speeds[i] != 0) {
                deployDay++;
            }

            deploy.offer(deployDay);
        }

        // 첫날 기준으로 배포날짜
        int deployDate = deploy.poll();
        int count = 1;

        // 첫날 배포로 끝나는 경우
        if(deploy.isEmpty()) {
            result.add(count);
        }

        // 프로그램 기준 배포 날짜가 모두 정리될 때 까지
        while(!deploy.isEmpty()) {
            // 그 다음 배포가 가능한 작업
            int addDeployProgramDate = deploy.peekFirst();

            // 이전 배포와 함께 가능한지 체크
            if(addDeployProgramDate <= deployDate) {
                count += 1;
                deploy.poll();
            }
            // 이전 배포와 함께 가능하지 못하다면 배포 날짜를 픽스하고 다음 배포 날짜를 가져온다.
            else {
                result.add(count);
                deployDate = deploy.poll();
                count = 1;
            }

            // 그 다음 배포가 존재하지 않는다면
            if(deploy.isEmpty()) {
                result.add(count);
            }
        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}