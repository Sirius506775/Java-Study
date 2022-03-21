/*
    - 파일 복사 프로그램 예제
    - 주제 : 03.20일자 분데스리가 27라운드 바이에른 뮌헨과 우니온베를린과의 경기에서 노이어가 창조선방을 만들어낸 영상을 웹에서 다운로드 해보자!!
 */
package org.zerock;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Ex1_FileInputFromWeb {

    public static void main(String[] args) throws Exception {//예외 처리 생략

        //인터넷 연결
        String link = "https://cafeptthumb-phinf.pstatic.net/MjAyMjAzMjBfMjI1/MDAxNjQ3NzQ0NTE1NzY0.9S30nY7i5FOB9dVZ-Dg_egA5ZTb-sGJhusq3qONtK0Ug.Bj5PfPuoJa1NDfhWEmXPLXKRMGC6FuEo4gKlSWhj0d0g.GIF/20220320%EF%BC%BF091625711.gif?type=w1600";

        //읽는 빨대
        InputStream in = new URL(link).openStream();

        //쓰는 빨대
        OutputStream out = new FileOutputStream("C:\\zzz\\test2.gif");

        //읽고 쓰기
        byte[] buffer = new byte[1024]; //1kb씩 읽고 싶다.
        //더 편하게 읽고 쓰기 위한 buffer 생성

       while (true){ //파일 크기가 얼만지 모르기 때문에 while로 계속 읽게 할거에요

           int count = in.read(buffer); //몇 개의 새로운 데이터가 들어 왔어요.
           System.out.println(count); //데이터 읽는 것 보기 위함
           if(count == -1){ // 더이상 읽어들일 데이터가 없다면
               break; //빠져나오고
           }
           out.write(buffer,0,count); //읽어들일 데이터를 맨 앞에서 새로 읽어낸 만큼만 써라
        }
       //close
       in.close();
       out.close();
    }
}
