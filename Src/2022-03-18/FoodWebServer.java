package org.zerock.server.ui;

import org.zerock.server.service.FoodService;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FoodWebServer {

    private FoodService foodService; //조력자가 필요해요

    public FoodWebServer(FoodService service) { //의존성 주입
        this.foodService = service;
    }

    //bad code
    public void doRun() throws Exception { //소켓 연결하기
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("server ready............");
        for (int i = 0; i < 100; i++) {
            Socket client = serverSocket.accept();
            System.out.println(client); //손님이 누군지 알아보자
            OutputStream out = client.getOutputStream();
            List<String> foodlist = foodService.recommand();

            String msg = String.join(",", foodlist) ; //받은 리스트를 문자열로 만든다.

            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length: " + msg.getBytes("UTF-8").length + "\r\n").getBytes());
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

            out.write(msg.getBytes(StandardCharsets.UTF_8));


        }//end for


    }
}

