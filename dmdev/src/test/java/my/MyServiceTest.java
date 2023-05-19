package my;

import my.annotation.MyAnnotationForInjecting;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class MyServiceTest extends TestBase {

    private MyService myService;

    @MyAnnotationForInjecting
    private String value;


    public MyServiceTest(TestInfo testInfo) {
        System.out.println(testInfo);
    }


    @BeforeAll
    void init() {
        System.out.println("General preparation started: " + this);
    }


    @BeforeEach
    void prepareForEach(MyService myService) {
        System.out.println("Start of: " + this);
        this.myService = myService;
    }


    @Test
    @Tags({@Tag("other"), @Tag("my")})
    void test1() {
        System.out.println(value);
        assertEquals("Result from my.MyService", myService.getResult());
    }


    @Test
    @Tag("my")
    @DisplayName("можно писать своё название тестового метода")
    void test2() {
        assertAll(
                () -> {
                    var exception = assertThrows(NullPointerException.class, () -> {
                        throw new NullPointerException("test");
                    });
                    assertEquals("test", exception.getMessage());
                },
                () -> assertEquals("Result from my.MyService", myService.getResult())
        );
    }


    @ParameterizedTest(name = ParameterizedTest.DEFAULT_DISPLAY_NAME)
//    @ArgumentsSource()
    @NullSource
    @EmptySource
    @ValueSource(strings = {"val1", "val2"})
    @MethodSource("getArgumentForThisTest")
    @CsvFileSource(resources = {"/parametrized-test.csv"}, numLinesToSkip = 1)
    @CsvSource({"csv1", "csv2"})
    void parametrizedTest(String expectedParam) {
        System.out.println(expectedParam);
    }


    static Stream<Arguments> getArgumentForThisTest() {
        return Stream.of(
                Arguments.of("arg1"),
                Arguments.of("arg2")
        );
    }


    @AfterEach
    void endForEach() {
        System.out.println("End of: " + this);
    }


    @AfterAll
    void end() {
        System.out.println("General preparation ends: " + this);
    }
}