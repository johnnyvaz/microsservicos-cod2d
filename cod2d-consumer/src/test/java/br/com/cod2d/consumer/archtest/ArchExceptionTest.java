package br.com.cod2d.consumer.archtest;

import br.com.cod2d.consumer.archtest.config.ArchTest;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchExceptionTest extends ArchTest {

    @Test
    public void shouldHaveSimpleNameEndingWithException() {
        classes()
                .that().resideInAPackage("..exception..")
                .should().haveSimpleNameEndingWith("Exception")
                .check(classes);
    }
}
