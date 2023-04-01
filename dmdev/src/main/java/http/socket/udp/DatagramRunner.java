package http.socket.udp;

import http.socket.ServerProps;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        var inetAddress = InetAddress.getByName(ServerProps.HOST);
        try (var datagramSocket = new DatagramSocket()) {
//            var bytes = new byte[ServerProps.BUF_SIZE];
            var bytes = "Hello from UDP client".getBytes(); // можно передавать любой объём
            var packet = new DatagramPacket(bytes, bytes.length, inetAddress, ServerProps.PORT);
            datagramSocket.send(packet);
            Scanner in = new Scanner(System.in);
            String text = "";
            while (!text.equals("exit") && in.hasNextLine()) {
                text = in.nextLine();
                packet.setData(text.getBytes());
                datagramSocket.send(packet);
            }
        }
    }
}
