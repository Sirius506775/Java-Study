package org.zerock;
/*
    -이중 for문을 이용한 구구단 프로그램
    -가로로 나열되는 구구단 표
 */
public class Gugudan {
    public static void main(String[] args) {

        System.out.println("[ 간단한 구구단 표(2단~9단)입니다. ] " +"\n");
        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.print(j +"*"+ i + "=" + (i*j)+"\t"  );
            }
            System.out.println();
        }
    }
}
