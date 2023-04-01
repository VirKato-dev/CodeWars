package http.socket;

public interface ServerProps {
    /**
     * Требуется для клиентской стороны
     */
    String HOST = "localhost";
    /**
     * Номер порта должен быть согласован для обеих сторон
     */
    int PORT = 7777;
    /**
     * Размер буфера обмена должен быть согласован для обеих сторон
     */
    int BUF_SIZE = 512;
}
