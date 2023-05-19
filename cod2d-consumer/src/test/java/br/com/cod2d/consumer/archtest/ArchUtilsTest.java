package br.com.cod2d.consumer.archtest;

import br.com.cod2d.consumer.archtest.config.ArchTest;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchUtilsTest extends ArchTest {

    @Test
    public void shouldHaveOnlyFinalFields() {
        classes()
                .that().resideInAPackage(".utils..")
                .should().haveOnlyFinalFields()
                .check(classes);
    }

    @Test
    public void shouldHaveOnlyPrivateConstructors() {
        classes()
                .that().resideInAPackage(".utils..")
                .should().haveOnlyPrivateConstructors()
                .check(classes);
    }

    @Test
    public void shouldHaveSimpleNameEndingWithUtils() {
        classes()
                .that().resideInAPackage(".utils..")
                .should().haveSimpleNameEndingWith("Utils")
                .check(classes);
    }
}
