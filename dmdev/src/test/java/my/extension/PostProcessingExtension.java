package my.extension;

import my.annotation.MyAnnotationForInjecting;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;


public class PostProcessingExtension implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        System.out.println("post processing extension");
        var fields = testInstance.getClass().getDeclaredFields();
        for (Field declaredField : fields) {
            if (declaredField.isAnnotationPresent(MyAnnotationForInjecting.class)) {
                declaredField.setAccessible(true);
                declaredField.set(testInstance, "Injected from PostProcessingExtension");
            }
        }
    }
}
