package a.proxy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;

/**
 * Избавляет от необходимости создания интерфейса доступа к методам проксируемого объекта.
 * Прокрсирование через библиотеку ByteBuddy:
 * <dependency>
 * <groupId>net.bytebuddy</groupId>
 * <artifactId>byte-buddy</artifactId>
 * <version>1.13.0</version>
 * </dependency>
 */
public class ByteBuddyProxy {

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
        assert "ВАСЯ".equals(what()) : "Что-то пошло не так";
    }

    public static String what() {
        User user = new User("Вася");
        User userProxy;

        try {
            userProxy = new ByteBuddy()
                    .subclass(User.class)
                    .method(ElementMatchers.named("getName"))
                    .intercept(MethodDelegation.to(new MyInterceptor(user)))
                    .make()
                    .load(User.class.getClassLoader())
                    .getLoaded()
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return userProxy.getName();
    }


    public static class MyInterceptor {
        User user;

        public MyInterceptor(User user) {
            this.user = user;
        }

        public String getName() {
            return user.getName().toUpperCase();
        }
    }
}
