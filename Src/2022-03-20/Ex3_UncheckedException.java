/*
     - Unchecked exception
     - try ~ catch
     - 예외가 발생할 수 있는 위치가 어디일지 파악해보자
 */

package org.zerock;

import java.util.Scanner;

public class Ex3_UncheckedException {

    public void doA(){
        Scanner scanner = new Scanner(System.in); //입력받을 준비

        System.out.println(" 숫자 1개 입력하세요"); //출력문

        try {
            int value = 100;
            int x = Integer.parseInt(scanner.nextLine());
            System.out.println(value/x);
            //여기 안에서 잘못된다면 Exception 객체가 만들어진다고 보면 되어요.
        }catch (Exception e){
            System.out.println("잘못되었습니다.");
            e.printStackTrace(); //어디 코드에서 잘못되었는지 추적해줍니다.
        }
        //System.out.println(value/x); //여기서 에러가 나면 밑에 코드는 실행되지 않는다.

        System.out.println("AAaaaaaaaaaaaaa");
        System.out.println("AAaaaaaaaaaaaaa");
        System.out.println("AAaaaaaaaaaaaaa");
        System.out.println("AAaaaaaaaaaaaaa");
    }

    public static void main(String[] args) {

        Ex3_UncheckedException ex1 = new Ex3_UncheckedException(); //객체 생성
        ex1.doA(); //doA() 메소드 호출
    }


}

