package a.patterns.absfactory.factory;

import a.patterns.absfactory.product.Bread;
import a.patterns.absfactory.product.Cookie;

/**
 * Конкретная пекарня 'Дока'
 */
public class DokaFactory implements BakeryFactory {
    /**
     * Конкретная реализация продукта Хлеб
     * @return хлеб от Дока
     */
    @Override
    public Bread createBread() {
        return new Bread() {
            @Override
            public String getName() {
                return super.getName() + " 'Дока'";
            }
        };
    }

    /**
     * Конкретная реализация продукта Печенье
     * @return печенье от Дока
     */
    @Override
    public Cookie createCookie() {
        return new Cookie() {
            @Override
            public String getName() {
                return super.getName() + " 'Дока'";
            }
        };
    }
}
