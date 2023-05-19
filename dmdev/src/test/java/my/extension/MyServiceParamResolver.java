package my.extension;

import my.MyService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;


public class MyServiceParamResolver implements ParameterResolver {
    /**
     * Проверяем запрашиваемый тип запрашиваемого объекта для инжекта зависимости в тест
     */
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == MyService.class;
    }

    /**
     * Возвращаем запрошенный объект для инжекта в тест
     */
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
//        return new my.MyService(); // простейший вариант

        // создаём ключ для хранения объекта инжектируемого позже

//        var store = extensionContext.getStore(ExtensionContext.Namespace.create(my.MyService.class));
//        return store.getOrComputeIfAbsent(my.MyService.class, it -> new my.MyService());

        var testMethod = extensionContext.getTestMethod();
        var store = extensionContext.getStore(ExtensionContext.Namespace.create(testMethod));
        // вытаскиваем по названию тестового метода, либо создаём при отсутствии
        return store.getOrComputeIfAbsent(testMethod, it -> new MyService());
    }
}
