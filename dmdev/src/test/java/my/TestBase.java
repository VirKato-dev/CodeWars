package my;

import my.extension.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;


@TestInstance(TestInstance.Lifecycle.PER_CLASS) // для PER_METHOD нужно использовать static BeforeAll/AfterAll
@TestMethodOrder(MethodOrderer.Random.class) // рандомный порядок вызова тестовых методов
@ExtendWith({ // требуется указать резолвер, предоставляющий зависимости
        MyServiceParamResolver.class,
        GlobalExtension.class,
        PostProcessingExtension.class,
        ConditionalExtension.class,
        ThrowableExtension.class
})
public abstract class TestBase {
}
