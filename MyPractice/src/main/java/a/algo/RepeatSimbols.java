package a.algo;

public class RepeatSimbols {
    public static void main(String[] args) {
        uniq();
    }

    private static void uniq() {

        String str = "abbaaaccdd";
        int maxCount = 0;
        int count = 1;
        String lastSimbol = "";
        String res = "";
        int i = 0;
        while (i < str.length()) {
            if (lastSimbol.equals(Character.toString(str.charAt(i)))) {
                count++;
                if (maxCount < count ) {
                    maxCount = count;
                    res = lastSimbol;
                }
            } else {
                count = 1;
            }
            lastSimbol = String.valueOf(str.charAt(i));
            i++;
        }
        System.out.print(maxCount);
        System.out.println(res);
    }


    private static void unique() {
        String str = "abbaaacc";
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                if (count != 1) {
                    System.out.println(str.charAt(i - 1) + ":" + count);
                    count = 1;
                }
            }
        }
        System.out.println(str.charAt(str.length() - 1) + ":" + count);
    }
}
