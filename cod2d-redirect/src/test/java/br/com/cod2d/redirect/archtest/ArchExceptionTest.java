package br.com.cod2d.redirect.archtest;

import br.com.cod2d.redirect.archtest.config.ArchTestConfig;
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
