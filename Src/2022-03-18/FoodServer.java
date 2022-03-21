package org.zerock.server.ui;

import org.zerock.server.service.FoodService;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

/*
    - 필요한거 : 서버 소켓, 서버 소켓을 미리 준비하기, 손님 맞이하기 accept, 프로토콜이 필요(누가 먼저 주고, 누가 먼저 받지?)
 */
public class FoodServer {
    
    private FoodService foodService; //조력자가 필요해요
    
    public FoodServer(FoodService service){ //의존성 주입
        this.foodService = service;
    }
    
    //bad code
    public void doRun() throws Exception{ //소켓 연결하기
        ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("server ready............");
        for (int i = 0; i < 100; i++) {
            Socket client = serverSocket.accept();
            System.out.println(client); //손님이 누군지 알아보자
            OutputStream out = client.getOutputStream();
            List<String> foodlist = foodService.recommand();

            String msg = String.join(",",foodlist) + "\n"; //받은 리스트를 문자열로 만든다.

            out.write(msg.getBytes(StandardCharsets.UTF_8));


        }//end for





        
    }
    
}
