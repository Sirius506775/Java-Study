package chatclient;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient_forcatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ips = {
                "192.168.1.32",
                "192.168.1.50",
                "192.168.1.47",
                "192.168.1.41",
                "192.168.1.35"
        };

        while (true) {
            System.out.print("채팅 입력 >> ");
            String msg = scanner.nextLine() + "\n";
            if ("q\n".equals(msg)) break;

            for (String ip : ips) {
                sendMessage(msg, ip);
            }
        }

    }

    private static void sendMessage(String msg, String ip) {
        try (Socket server = new Socket(ip, 5555);
            OutputStream outputStream = server.getOutputStream();
        ) {
            outputStream.write(msg.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.out.println("Failed to connect " + ip);
            e.printStackTrace();
        }
    }
}
