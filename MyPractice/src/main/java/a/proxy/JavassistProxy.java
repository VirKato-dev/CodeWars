package a.proxy;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Избавляет от необходимости создания интерфейса доступа к методам проксируемого объекта.
 *
 * Прокрсирование через библиотеку Javassist:
 * <dependency>
 *     <groupId>javassist</groupId>
 *     <artifactId>javassist</artifactId>
 *     <version>3.12.1.GA</version>
 * </dependency>
 *
 * ПРОБЛЕМА:
 * java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @5d6f64b1
 * РЕШЕНИЕ:
 * требуется добавить аргумент для запуска JVM
 * --add-opens java.base/java.lang=ALL-UNNAMED
 */
public class JavassistProxy {

    public static class User {
        private String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        User user = new User("Вася");

        MethodHandler handler = new MethodHandler() {
            @Override
            public Object invoke(Object self, Method overriden, Method forwader, Object[] args) throws Throwable {
                if (overriden.getName().equals("getName")) {
                    return ((String) overriden.invoke(user, args)).toUpperCase();
                }
                return overriden.invoke(user, args);
            }
        };

        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(User.class);
        Object instance = factory.createClass().newInstance();
        ((ProxyObject) instance).setHandler(handler);

        User userProxy = (User) instance;
        System.out.println(userProxy.getName());
    }
}
