package org.zerock.server.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FoodService {

    private List<String> foodNames;

    public FoodService(){
        foodNames = new ArrayList<>(); //실제 구현 클래스
        foodNames.add("비빔밥");
        foodNames.add("갈비찜");
        foodNames.add("불고기");
        foodNames.add("찜닭");
        foodNames.add("삼계탕");
    }

    public List<String> recommand(){
        Collections.shuffle(foodNames); //add한 문자열들이 섞입니다.
        return foodNames.subList(0,3); //맨 앞에서부터 3개 잘라내서 반환
    }

//    public static void main(String[] args) {
//        FoodService service = new FoodService();
//        System.out.println(service.recommand());
//    }

}
