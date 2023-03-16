package a.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Избавляет от необходимости создания интерфейса доступа к методам проксируемого объекта.
 *
 * Прокрсирование через библиотеку Cglib:
 * <dependency>
 *     <groupId>cglib</groupId>
 *     <artifactId>cglib</artifactId>
 *     <version>3.3.0</version>
 * </dependency>
 *
 * ПРОБЛЕМА:
 * java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @5d6f64b1
 * РЕШЕНИЕ:
 * требуется добавить аргумент для запуска JVM
 * --add-opens java.base/java.lang=ALL-UNNAMED
 */
public class CglibProxy {

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


    public static void main(String[] args) {
        User user = new User("Вася");

        MethodInterceptor handler = (obj, method, args1, proxy) -> {
            if (method.getName().equals("getName")) {
                return ((String) proxy.invoke(user, args1)).toUpperCase();
            }
            return proxy.invoke(user, args1);
        };

        User userProxy = (User) Enhancer.create(User.class, handler);
        System.out.println(userProxy.getName());
    }
}
