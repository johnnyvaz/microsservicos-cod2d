package br.com.cod2d.api.archtest;

import br.com.cod2d.api.archtest.config.ArchTestConfig;
import org.junit.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchExceptionTest extends ArchTestConfig {

    @Test
    public void shouldHaveSimpleNameEndingWithException() {
        classes()
                .that().resideInAPackage("..exception..")
                .should().haveSimpleNameEndingWith("Exception")
                .check(classes);
    }
}
