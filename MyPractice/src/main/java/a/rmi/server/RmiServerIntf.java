package a.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/***
 * Класс RmiServerIntf — определяет интерфейс, используемый клиентом и реализуемый сервером.
 */
public interface RmiServerIntf extends Remote {
    String getMessage() throws RemoteException;
}