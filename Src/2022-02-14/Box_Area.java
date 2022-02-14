package org.zerock;

import java.util.Scanner;

/*  나무상자의 가격 계산 프로그램
*   가로 10, 세로 20, 높이 7, 단위는 cm
*   m2당 가격은 1000원
*/
public class Box_Area {

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("**나무상자를 만드는데 필요한 금액을 계산하는 프로그램입니다.**");
        System.out.println("****나무판자 1제곱미터 당 청구되는 금액은 1000원입니다.****");
        System.out.println("----------------------------------------------------");
        System.out.println(" 나무상자의 가로 길이를 입력하시오. : ");
        int width = src.nextInt(); //가로

        System.out.println(" 나무상자의 세로 길이를 입력하시오. : ");
        int length = src.nextInt(); //세로

        System.out.println(" 나무상자의 높이를 입력하시오. : ");
        int height = src.nextInt(); //높이

        double box_price = 1000; //제곱미터 당 가격 | m2 = 1000이므로 단위변환 하면 cm2 = 10000

        double area = (width*length)+(width*height)+(length*height); //세 면의 넓이의 합, 단위는 제곱센티미터
        double area2 = (area*2)/10000; //표면적의 넚이 연산값 , 단위는 제곱미터

        System.out.println("- 세 면의 넓이의 합 : " + area + "cm²");
        System.out.println("- 상자의 표면적 : " + area2 + "m²");
        System.out.println("- 상자의 가격은 " + (area2 * box_price) + "원입니다."); // 직육면체 표면적 공식 * 평방미터 당 가격




    }
}
