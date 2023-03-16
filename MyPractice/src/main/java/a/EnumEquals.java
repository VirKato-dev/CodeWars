package a;

public class EnumEquals {

    enum Nums { ZERO, ONE, TWO}


    public static void main(String[] args) {
        Nums num = Nums.ONE;
        test(num);
    }


    private static void test(Nums num) {
        System.out.println(Nums.TWO.ordinal() > num.ordinal());
        String text;
        switch (num) {
            case ONE:
                text = Nums.ONE.name();
                break;
            case TWO:
                text = Nums.TWO.name();
                break;
            default:
                text = Nums.ZERO.name();
        }
        System.out.println(text);
    }
}
