package a.patterns.absfactory.product;

/**
 * Печенье (продукт)
 */
public class Cookie implements Product {

    @Override
    public String getName() {
        return "Печенье";
    }
}
