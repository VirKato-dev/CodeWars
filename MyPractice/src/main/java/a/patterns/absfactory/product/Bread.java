package a.patterns.absfactory.product;

/**
 * Хлеб (продукт)
 */
public class Bread implements Product {

    @Override
    public String getName() {
        return "Хлеб";
    }
}
