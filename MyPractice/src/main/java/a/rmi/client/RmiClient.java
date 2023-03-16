package a.rmi.client;

import java.rmi.Naming;
//import java.rmi.RMISecurityManager;
import a.rmi.server.RmiServerIntf;

/***
 * Класс RmiClient — клиент, использующий заместителя(proxy) удалённого объекта размещённого на стороне сервера
 * и вызывающий его методы для получения данных. Если объект сервера реализует интерфейс java.io.Serializable
 * вместо java.rmi.Remote, то он будет сериализован и клиенту будет передано его значение.
 */
public class RmiClient {
    // "obj" is the reference of the remote object
    RmiServerIntf obj = null;

    public String getMessage() {
        try {
            obj = (RmiServerIntf)Naming.lookup("RmiServer");
            return obj.getMessage();
        } catch (Exception e) {
            System.err.println("RmiClient exception: " + e);
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Create and install a security manager
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new RMISecurityManager());
//        }

        RmiClient cli = new RmiClient();

        System.out.println(cli.getMessage());
    }
}