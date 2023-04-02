package a.patterns.absfactory.factory;

import a.patterns.absfactory.product.Bread;
import a.patterns.absfactory.product.Cookie;

/**
 * Конкретная пекарня 'ДоДо'
 */
public class DodoFactory implements BakeryFactory {
    /**
     * Конкретная реализация продукта Хлеб
     * @return хлеб от ДоДо
     */
    @Override
    public Bread createBread() {
        return new Bread() {
            @Override
            public String getName() {
                return super.getName() + " 'ДоДо'";
            }
        };
    }

    /**
     * Конкретная реализация продукта Печенье
     * @return печенье от ДоДо
     */
    @Override
    public Cookie createCookie() {
        return new Cookie() {
            @Override
            public String getName() {
                return super.getName() + " 'ДоДо'";
            }
        };
    }
}
