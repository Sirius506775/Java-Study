package chatsever;

import lombok.Cleanup;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class ChatSever2 {
    public static void main(String[] args) throws Exception {


        @Cleanup ServerSocket serverSocket = new ServerSocket(5555);
        System.out.println("Server ready....");

        HashMap<String, String> map = new HashMap<>();
        map.put("/192.168.1.32","수홍");
        map.put("/192.168.1.41","민성");
        map.put("/192.168.1.47","동헌");
        map.put("/192.168.1.35","수홍");
        map.put("/192.168.1.50","현우");

        for (int i = 0; i <100 ; i++) {
            @Cleanup Socket client = serverSocket.accept();


           @Cleanup InputStream inputStream = client.getInputStream();

           @Cleanup Scanner inScanner = new Scanner(inputStream); //클라이언트의 메시지를 인풋스트림으로받아옴

//            System.out.println(client.getInetAddress());
            System.out.print(map.get(client.getInetAddress().toString())+":");
            System.out.println(inScanner.nextLine());


        }

    }
}
