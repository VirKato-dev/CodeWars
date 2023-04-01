package http.socket.tcp;

import http.socket.ServerProps;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(ServerProps.PORT);
             var socket = serverSocket.accept();
             var scanner = new Scanner(System.in)) {
            var os = new DataOutputStream(socket.getOutputStream());
            var is = new DataInputStream(socket.getInputStream());
            String req;
            while (!(req = is.readUTF()).startsWith("stop")) {
                System.out.println("client: " + req);
                os.writeUTF(">> " + scanner.nextLine());
            }
        }
    }
}
