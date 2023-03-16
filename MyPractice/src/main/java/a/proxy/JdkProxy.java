package a.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Проксирование с использованием интерфейса.
 * Недостаток: Требуется реализовывать интерфейс в проксируемом классе для доступа к проксируемому методу.
 */
public class JdkProxy {

    interface IUser {
        String getName();
    }

    static class User implements IUser {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        User user = new User("Вася");

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getName")) {
                    return ((String)method.invoke(user, args)).toUpperCase();
                }
                return method.invoke(user, args);
            }
        };

        IUser userProxy = (IUser) Proxy.newProxyInstance(
                user.getClass().getClassLoader(),
                User.class.getInterfaces(),
                handler);

        System.out.println(userProxy.getName());
    }
}
