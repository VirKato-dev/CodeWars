package decode;

public class Decode {
    public static void main(String[] args) {
        String input;
        input = "s\u007f}>zw>rx>Bu`\u007fbdcDy}u";
//        input = "BuwycdubQsdyfydiSq||Rqs{c";
//        input = "}Xyttu~Q`yGqb~y~wCx\\u007fg~";
//        input = "sebbu~dQsdyfydiDxbuqt";
//        input = "q~tb\\u007fyt>q``>QsdyfydiDxbuqt";
//        input = "q~tb\\u007fyt>s\\u007f~du~d>`}>@qs{qwu@qbcub4@qs{qwu";
//        input = "wud@b\\u007fsucc^q}u";
//        input = "sebbu~dQsdyfydiDxbuqt";
//        input = "q~tb\\u007fyt>q``>QsdyfydiDxbuqt";
        byte[] bytes = input.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)((bytes[i] ^ 0x10) + 1);
        }
        System.out.println(new String(bytes));
    }
}
