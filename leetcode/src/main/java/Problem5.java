import java.util.Arrays;

/**
 * Longest Substring Without Repeating Characters
 */
public class Problem5 {
    public static void main(String[] args) {
        String res;
        assert (res = longestPalindrome("babad")).equals("bab") : "babad = " + res;
        assert (res = longestPalindrome("cbbd")).equals("bb") : "cbbd = " + res;
        assert (res = longestPalindrome("a")).equals("a") : "a = " + res;
        assert (res = longestPalindrome("bb")).equals("bb") : "bb = " + res;
        assert (res = longestPalindrome("caba")).equals("aba") : "caba = " + res;
        assert (res = longestPalindrome("jsfpmgkuxqnmtruslzgyvexhqjoamvyuyedhybqqcjhhhgmwqudgldvspgugibdsqfhucpfcqzriqqusvspgbqhgkswlzdkytyqphexemwxpduxplkquvgvhefsxubjluopighxbpscekijrqjhcgmqcuoczwbvueuviyfokdoqqsckjdorsettkkpiyyxxdsfczyhkyxlvrmhvflqbvlrukqcplbxnyokdxvhubsisxrodolmpmkdczavqlsnrggffagoddaldlcexwvozjxxdjtfjrfciwpacpbajcpmgfpefngqfbzehaaqyfvthtrbhkzrzqmzdcgrkezpqgbqjembeqaziuubbvdfpfyqanilcjggkudsyigiqgrcmauyugyhepvduudvpehyguyuamcrgqigiysdukggjclinaqyfpfdvbbuuizaqebmejqbgqpzekrgcdzmqzrzkhbrthtvfyqaahezbfqgnfepfgmpcjabpcapwicfrjftjdxxjzovwxecldladdogaffggrnslqvazcdkmpmlodorxsisbuhvxdkoynxblpcqkurlvbqlfvhmrvlxykhyzcfsdxxyyipkkttesrodjkcsqqodkofyivueuvbwzcoucqmgchjqrjikecspbxhgipouljbuxsfehvgvuqklpxudpxwmexehpqytykdzlwskghqbgpsvsuqqirzqcfpcuhfqsdbigugpsvdlgduqwmghhhjcqqbyhdeyuyvmaojqhxevygzlsurtmnqxukgmpfsj")).equals("a") : "??? = " + res;
    }

    public static String longestPalindrome(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        int w;
        for (int i = 0; i < chars.length; i++) {
            w = 0;
            while (i - w >= 0 && i + w < chars.length && chars[i - w] == chars[i + w]) {
                // нечётная симметрия
                if (answer.length() < w * 2 + 1) {
                    answer = new String(Arrays.copyOfRange(chars, i - w, i + w + 1));
                }
                w++;
            }

            w= 0;
            while (i - w >= 0 && i + w + 1 < chars.length && chars[i - w] == chars[i + w + 1]) {
                // чётная симметрия
                if (answer.length() < w * 2 + 2) {
                    answer = new String(Arrays.copyOfRange(chars, i - w, i + w + 2));
                }
                w++;
            }
        }
        return answer;
    }
}
