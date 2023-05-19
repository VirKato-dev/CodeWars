package tasks;

public class TryCatchReturn {

    public static void main(String[] args) {
        test();
        System.out.println("Всё ОК! Посрать на исключения");
    }

    public static void test() {
        try {
            throw new NullPointerException("NPE1"); // вызовет обработку catch, но...
        } catch (NullPointerException e) {
            throw new Error();
            // предыдущее исключение благополучно забудется
            // (никак не узнать про NPE после Error, если не error.addSuppressed(e))
        } finally {
            return; // благополучно забудутся все исключения
        }
    }
}
