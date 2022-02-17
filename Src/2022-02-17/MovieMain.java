package org.zerock;

import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Movie[] arr = new Movie[6]; //Movie type의 6자리 배열 선언
        //순서대로 6개의 Movie 타입의 객체 선언
        Movie mv0 = new Movie("로맨스", 1,6);
        Movie mv1 = new Movie("로맨스", 2,10);
        Movie mv2 = new Movie("로맨스", 3,5);
        Movie mv3 = new Movie("전투/액션", 9,2);
        Movie mv4 = new Movie("전투/액션", 13,7);
        Movie mv5 = new Movie("전투/액션", 11,1);

        //arr index 순서대로 Movie 타입의 객체들을 대입
        arr[0] = mv0;
        arr[1] = mv1;
        arr[2] = mv2;
        arr[3] = mv3;
        arr[4] = mv4;
        arr[5] = mv5;

        //입력문 안내 시작
        System.out.println("############# [영화 장르 검색 안내문] ##############");
        System.out.println("#### 현재 선택한 영화 속 키스씬의 횟수을 입력하시오 #### : ");
        double movie_x = Integer.parseInt(scanner.nextLine());
        System.out.println("#### 현재 선택한 영화 속 액션씬의 횟수을 입력하시오 #### : ");
        double movie_y = Integer.parseInt(scanner.nextLine());
        //입력문 안내 끝

        Movie target = new Movie(null, movie_x, movie_y); //Movie type의 target 객체 선언

        double minDistance = 1000000000; //최단거리
        Movie minMovie = null; //객체자료형 기본값 null 부여

        for(Movie temp:arr){// foreach문 시작
            double distance = Math.sqrt(Math.pow(temp.movie_x-target.movie_x,2)
                    +Math.pow(temp.movie_y-target.movie_y ,2));// distance = 대각선 거리 구하는 공식

            if(distance < minDistance){ //ir문 시작
                minDistance = distance;
                minMovie = temp;
            } //if문 끝
        }//foreach문 끝

        //출력 안내문
        System.out.println("#### 가장 가까운 영화정보를 찾았습니다! #### : " + minMovie + "\n");
        System.out.println("#### 이 영화의 장르는 " + minMovie.movie_genre+" 영화 입니다. ####");

    }
}
