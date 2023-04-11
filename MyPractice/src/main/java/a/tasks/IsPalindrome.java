package a.tasks;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("kazak"));
        System.out.println(isPalindrome("A roza upala <|n|>a lapu Azora"));
        System.out.println(isPalindrome("A - roza"));
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int rite = str.length() - 1;
        while (left < rite) {
            while (!Character.isLetterOrDigit(str.charAt(left)) && left < rite) {
                left++;
            }
            while (!Character.isLetterOrDigit(str.charAt(rite)) && left < rite) {
                rite--;
            }
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(rite))) {
                return false;
            }
            left++;
            rite--;
        }
        return true;
    }
}
