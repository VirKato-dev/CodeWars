package http.socket.udp;

import http.socket.ServerProps;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class DatagramServerRunner {
    public static void main(String[] args) throws IOException {
        String text;
        try (var datagramSocket = new DatagramSocket(ServerProps.PORT)) {
            var buffer = new byte[ServerProps.BUF_SIZE]; // не важно, сколько нам отправили
            var packet = new DatagramPacket(buffer, buffer.length);
            do {
                Arrays.fill(packet.getData(), (byte) 0); // чистим буфер перед приёмом
                datagramSocket.receive(packet);
                text = new String(buffer).trim();
                System.out.println(text);
            } while (!text.equals("exit"));
        }
    }
}
