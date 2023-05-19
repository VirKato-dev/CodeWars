package my.extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class GlobalExtension implements BeforeAllCallback, AfterTestExecutionCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("BeforeAllCallback");
    }


    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("AfterTestExecution");
    }
}
