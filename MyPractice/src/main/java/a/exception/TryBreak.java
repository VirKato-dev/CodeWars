package a.exception;

public class TryBreak {
    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {
            try {
                if (j < 1) {
                    // успешное выполнение
                    break;
                }
                throw new RuntimeException("Что-то пошло не так");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
