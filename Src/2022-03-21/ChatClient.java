package chatclient;

import lombok.Cleanup;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("보낼말을 입력해주세요");
            String chat = scanner.nextLine() + "\n";

        @Cleanup Socket socket1 = new Socket("192.168.1.47",5555);
            @Cleanup Socket socket2 = new Socket("192.168.1.50", 5555);
            @Cleanup Socket socket3 = new Socket("192.168.1.32", 5555);
            @Cleanup Socket socket4 = new Socket("192.168.1.41", 5555);
            @Cleanup Socket socket5 = new Socket("192.168.1.35", 5555);

        @Cleanup OutputStream outputStream1 = socket1.getOutputStream();
            @Cleanup OutputStream outputStream2 = socket2.getOutputStream();
            @Cleanup OutputStream outputStream3 = socket3.getOutputStream();
            @Cleanup OutputStream outputStream4 = socket4.getOutputStream();
            @Cleanup OutputStream outputStream5 = socket5.getOutputStream();

        outputStream1.write(chat.getBytes(StandardCharsets.UTF_8));
            outputStream2.write(chat.getBytes(StandardCharsets.UTF_8));
            outputStream3.write(chat.getBytes(StandardCharsets.UTF_8));
            outputStream4.write(chat.getBytes(StandardCharsets.UTF_8));
            outputStream5.write(chat.getBytes(StandardCharsets.UTF_8));
        }

    }
}
