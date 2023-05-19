package my;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TagFilter;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;


public class TestLauncher {

    public static void main(String[] args) {
        var launcher = LauncherFactory.create();
//        launcher.registerLauncherDiscoveryListeners();
        var summaryGeneratingListener = new SummaryGeneratingListener();
//        launcher.registerTestExecutionListeners(summaryGeneratingListener);

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectClass(MyServiceTest.class))
//                .selectors(DiscoverySelectors.selectPackage(""))
                .filters( // фильтрация тестов по тегам
                        // можно запускать из командной строки mvn test -Dgroups=other
                        TagFilter.includeTags("other")
                )
                .build();
        launcher.execute(request, summaryGeneratingListener);

        try (var writer = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(writer);
        }
    }
}
