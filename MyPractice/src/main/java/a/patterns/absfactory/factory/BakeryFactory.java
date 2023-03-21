package a.patterns.absfactory.factory;

import a.patterns.absfactory.product.Bread;
import a.patterns.absfactory.product.Cookie;

/**
 * Абстрактная фабрика<br>
 * Пекарня (интерфейс для всех пекарен)
 */
public interface BakeryFactory {
    /**
     * Произвести продукт Хлеб
     * @return Хлеб
     */
    Bread createBread();

    /**
     * Произвести продукт Печенье
     * @return
     */
    Cookie createCookie();
}
