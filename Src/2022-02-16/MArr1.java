package org.zerock;
 /*
    부여받은 데이터 : {1, 1}, {5, 5}, {10, 10}, {1, 10} = 4개
    필요한 데이터 :  입력받을 위치정보 (x,y)
            1. 사용자에게 위치좌표를 입력 받는다.
            2. 입력받은 좌표 위치에서 기존에 할당된 좌표들과의 거리를 계산한다.
            3. 계산된 결과값을 이용하여 현재 나의 위치 기준 최단거리 및 최대거리 좌표, 그리고 거리를 계산한다.
 */

import java.util.Arrays;   // java.util 내에 있는 Arrays 클래스 호출
import java.util.Scanner; // java.util 내에 있는 Scanner 클래스 호출

public class MArr1 {
    public static void main(String[] args) {
        //출력 안내문 시작
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("<== 현재 우리가 파악하고 있는 적군의 위치정보는 다음과 같습니다. ==>");
        System.out.println("<== [적군의 위치 정보(좌표): {1,1} , {5,5} , {10,10} , {1,10}] ==>");
        System.out.println("<== 현 위치에서 가장 가까운 적군의 위치 및 가장 먼 곳, 그리고 적진과의 거리를 파악해보자. ==>");
        System.out.println("----------------------------------------------------------------------------------");
        //출력안내문 끝

        System.out.println("*** 임의의 좌표값(x,y)의 x값을 입력하세요.(0 ~ 10) ***:  "); //x값 입력 안내문
        Scanner srx = new Scanner(System.in); //Scanner 생성
        int num_x = srx.nextInt(); //입력받은 x값을 변수 num_x에 저장

        System.out.println("*** 임의의 좌표값(x,y)의 y값을 입력하세요.(0 ~ 10) ***:  "); //y값 입력 안내문
        Scanner sry = new Scanner(System.in);
        int num_y = sry.nextInt(); //입력받은 y값을 변수 num_y에 저장

        int[][] arr = {{1, 1}, {5, 5}, {10, 10}, {1, 10}}; //이중배열로 좌표 4개 확보
        int[] target = {num_x, num_y}; //target 배열은 입력받은 값을 저장하고 있음
        double min_dis = 100; //최단 거리
        double max_dis = 0; //최대 거리
        int[] min_target = {0,0}; //최단거리 위치 좌표
        int[] max_target = {0,0}; //최대거리 위치 좌표


        System.out.println("######## 적군의 위치 정보입니다. ########");
        for (int[] tempArr : arr) { //for start
            System.out.println(Arrays.toString(tempArr)); //정수타입 tempArr을 선언, arr 배열 데이터들을 꺼내온다.
            double distance = Math.sqrt(Math.pow(tempArr[0] - target[0], 2)
                            + Math.pow(tempArr[1] - target[1], 2));
            //이차원에서 점과 점 사이의 대각선 길이 구하는 공식
            System.out.println(" -> 현재 위치에서 " + String.format("%.2f", distance) + "Km 떨어진 곳 입니다." );
            // 위치 안내 출력문(소수점 둘쨰자리 까지 출력, String.format 함수 사용)
            if(min_dis > distance){ //if start
                min_dis = distance;
                min_target = tempArr;
            }//if exit
             else if(max_dis<distance){ // else if start
                max_dis = distance;
                max_target = tempArr;
            }// else if exit
        }// for exit

        System.out.println("################################");
        System.out.println("___________________________________________________________");
        System.out.println("<========= 현재 위치  ===========>  " + "{" + target[0] + "," + target[1] + "}");
        System.out.println("<========= 가장 가까운 적군 ======> " + Arrays.toString(min_target) + "\n" + "** 적군과의 현재 거리 : " + String.format("%.2f",min_dis) + "km");
        System.out.println("<========= 가장 멀리 있는 적군 ===> " + Arrays.toString(max_target) + "\n" + "** 적군과의 현재 거리 : " + String.format("%.2f",max_dis) + "km");
    }
}








