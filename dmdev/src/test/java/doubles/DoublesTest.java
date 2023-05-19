package doubles;

import static org.assertj.core.api.Assertions.*;

import doubles.dao.UserDao;
import doubles.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class DoublesTest {

    static private UserService userService;
    static private UserDao userDao = Mockito.mock(UserDao.class);

    @BeforeAll
    static void init() {
        userService = new UserService(userDao);
    }

    @Test
    void shouldDeleteExistedUser() {
        // подготовили Stub - заготовка ответа на ожидаемое поведение
        Mockito.doReturn(true).when(userDao).delete(1);
        // используем Dummy - когда параметр нужен только для вызова правильного метода
        Mockito.doReturn(true).when(userDao).delete(Mockito.anyInt());

        // произвести запрос
        var deleteResult = userService.delete(1);
        // проверить результат запроса
        assertThat(deleteResult).isTrue();
    }
}
