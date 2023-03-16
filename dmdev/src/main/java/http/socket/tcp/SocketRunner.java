package http.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        // http - 80
        // https - 443
//        var inetAddress = Inet4Address.getByName("goo.gl");
//        var port = 80;
//        var message = "Hello world!";
        var inetAddress = Inet4Address.getByName("localhost");
        var port = 7777;
        var message = "Hello world!";
        try (var socket = new Socket(inetAddress, port);
             var os = new DataOutputStream(socket.getOutputStream());
             var is = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()) {
                var req = scanner.nextLine();
                os.writeUTF(req);
                System.out.println("server: " + is.readUTF());
            }

//            os.writeUTF(message);
////            var response = is.readAllBytes();
////            System.out.println(new String(response));
//            var response = is.readUTF();
//            System.out.println("Response from server: " + response);
        } catch (EOFException e) {
            System.out.println("Связь разорвана: " + e.getLocalizedMessage());
        } catch (ConnectException e) {
            System.out.println("Сервер недоступен: " + e.getLocalizedMessage());
        }
    }
}
