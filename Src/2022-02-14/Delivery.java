package org.zerock;

import java.util.Scanner;  // java.util 내에 있는 Scanner 클래스 호출
/*
    - 택배의 무게와 권종을 입력받고 사용자가 지불해야할 청구비용 계산하는 프로그램
    - 입력받아야 할 데이터 : 택배의 무게, 수신받을 지역권
 */
public class Delivery {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Scanner 클래스 객체 생성
        System.out.println("** 반갑습니다. Static 택배입니다. **");
        System.out.println("** 택배의 무게를 입력하시오(kg) ** : "); //무게 입력 안내문

        int kiro = input.nextInt(); //입력받은 정수를 변수 kiro 에 저장
        int kiro_money =0; //변수 초기화, 조건문을 이용하여 숫자를 대입하기 위함이다.

        if (kiro <= 10) { //택배 무게에 따라 연산자를 사용한 조건문, 무게가 10kg 이하인 경우
                kiro_money = 1;
                System.out.println("[구분: 소형(10kg 이하)]");
        } else if (10 < kiro & kiro <= 20) { //무게가 10kg보다 크고, 20kg 이하인 경우
                kiro_money = 2;
                System.out.println("[구분: 중형(20kg 이하)]");
        } else if (20 < kiro & kiro <= 30) { //무게가 20kg보다 크고, 30kg 이하인 경우
                kiro_money = 3;
                System.out.println("[구분: 대형(30kg 이하)]"); 
        } else { 
                System.out.println("** 해당 무게는 운송 불가합니다. **"); //무게가 30kg보다 큰 경우 운송 불가
                System.exit(0); //프로그램 종료
        }

        System.out.println("** 권종을 선택하십시오. 동일권[1] | 타권역[2] | 제주권[3] **: "); //권종번호 입력 안내문
        int where = input.nextInt(); //입력받은 정수(권종번호)를 변수 where 에 저장

        switch (where) { //where에 대한 switch문
            case 1:
                System.out.println("** 동일권을 선택하셨습니다. **");
                break;
            case 2:
                System.out.println("** 타권역을 선택하셨습니다. **");
                break;
            case 3:
                System.out.println("** 제주권을 선택하셨습니다. **");
                break;
            default:
                System.out.println("** 잘못된 선택입니다. **"); //1,2,3을 제외한 나머지 입력은 잘못된 입력으로 간주
                break;
        }

        int[] won = { 6000, 7000, 8000, 9000, 10000, 11000 };
        if(kiro_money == 1 && where == 1){
            System.out.println("지불해야할 택배 요금은 " + won[0] + "원입니다." );
        }else if(kiro_money == 1 && where ==2){
            System.out.println("지불해야할 택배 요금은 " + won[1] + "원입니다." );
        }else if(kiro_money == 1 && where ==3){
            System.out.println("지불해야할 택배 요금은 " + won[3] + "원입니다." );
        }else if(kiro_money == 2 && where ==1){
            System.out.println("지불해야할 택배 요금은 " + won[1] + "원입니다." );
        }else if(kiro_money == 2 && where ==2){
            System.out.println("지불해야할 택배 요금은 " + won[2] + "원입니다.");
        }else if(kiro_money == 2 && where ==3){
            System.out.println("지불해야할 택배 요금은 " + won[4] + "원입니다." );
        }else if(kiro_money == 3 && where ==1){
            System.out.println("지불해야할 택배 요금은 " + won[2] + "원입니다.");
        }else if(kiro_money == 3 && where ==2){
            System.out.println("지불해야할 택배 요금은 " + won[3] + "원입니다.");
        }else if(kiro_money == 3 && where ==3){
            System.out.println("지불해야할 택배 요금은 " + won[5] + "원입니다." );
        }

    }

}

