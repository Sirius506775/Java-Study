package org.zerock;
import java.util.*; // java.util 내에 있는 Scanner 클래스 호출
public class Time {

    public static void main(String[] args) { //Main 메소드
        Scanner sc = new Scanner(System.in); //Scanner 클래스 객체 생성
        //System.in => 화면에서 입력을 받겠다는 의미
        System.out.println("현재 시침은 어디에 있나요? (hour) : "); //시침 입력 안내문
        int hour = sc.nextInt(); //입력받은 정수를 변수 hour 에 저장

        System.out.println("분침은 어디에 있나요? (minute) : "); //분침 입력 안내문
        int minute = sc.nextInt(); //입력받은 정수를 변수 minute 에 저장

        int hour_degree = hour * 30; //객체 생성 = 시침 각도 계산값
        int minute_degree = minute * 6; //객체 생성 = 분침 각도 계산값

        double hour_plus = minute * 0.5; //hour_plus 객체 생성 = 시침 이동 각도 계산값
        //1시간 동안의 시침의 이동각도는 30/60분 => 1분당 0.5도

        double result = hour_degree + hour_plus - minute_degree;
        //현재 시각의 각도는 시침 각도 + 시침 이동 각도 - 분침 각도

        if (result < 0) { //result 값이 0보다 작은 음수일 경우
            result = -1 * result; //변수 result에 result * -1의 연산값을 대입한다.
        }

        //각도 출력 안내문 4줄
        System.out.println("시침의 각도 : " + hour_degree + "도");
        System.out.println("분침의 각도 : " + minute_degree + "도");
        System.out.println("시침 초과값 : " + hour_plus + "도");
        System.out.println("** 시침과 분침 간의 각도는 " + result + "도입니다. **");
        }
    }
