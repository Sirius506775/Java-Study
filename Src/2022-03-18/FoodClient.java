package org.zerock.client;

import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodClient {

    private Map<String, String> serverMap;

    public FoodClient(){
        serverMap = new HashMap<>();
        serverMap.put("동남아","192.168.0.76");
        serverMap.put("양식","192.168.0.88");
        serverMap.put("한식","192.168.1.47");
        serverMap.put("분식","192.168.0.99");
        serverMap.put("일식","192.168.0.106");
    }

    //bad code
    public void findFood() throws Exception{

        Scanner keyScanner = new Scanner(System.in);
        System.out.println("어떤 종류의 음식이 먹고 싶나요?");
        String kind = keyScanner.nextLine();

        String ip = serverMap.get(kind);

        if(ip == null){
            System.out.println("잘못했어.. 다시 시작할께요..");
            findFood();
            return;
        }

        Socket socket = new Socket(ip,5555);//소켓 생성
        InputStream inputStream = socket.getInputStream();//읽을 준비

        Scanner inScanner = new Scanner(inputStream);

        System.out.println(inScanner.nextLine());


    }

}
