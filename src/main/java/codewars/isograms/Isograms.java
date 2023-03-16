package codewars.isograms;

public class Isograms {

    public static void main(String[] args) {
        if (isIsogram("Dermatoglyphics")) System.out.println(true);
        if (!isIsogram("moose")) System.out.println(false);
        if (!isIsogram("aba")) System.out.println(false);
        if (!isIsogram("isIsogram")) System.out.println(false);
        if (!isIsogram("aba")) System.out.println(false);
        if (!isIsogram("moOse")) System.out.println(false);
        if (isIsogram("thumbscrewjapingly")) System.out.println(true);
        if (isIsogram("")) System.out.println(true);
    }

    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        if (str.isEmpty()) return true;
        for (int j = 0; j < str.length(); j++) {
            if (str.lastIndexOf(str.charAt(j)) != j) return false;
        }
        return true;
    }

    public static boolean  isIsogramBest(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
