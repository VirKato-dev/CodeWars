package guru;

public class GotoMark {
    public static void main(String[] args) {
        outer:
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                System.out.println("Hello");
                continue outer;
            }
            System.out.println("outer");
        }
        System.out.println("Good-Bye");
    }
}
