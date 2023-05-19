package br.com.cod2d.api.archtest;

import br.com.cod2d.api.archtest.config.ArchTestConfig;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchConfigTest extends ArchTestConfig {

    @Test
    public void shouldHaveSimpleNameEndingWithConfig() {
        classes()
                .that().resideInAPackage("..config..")
                .and().resideOutsideOfPackage("..client")
                .should().haveSimpleNameEndingWith("Config")
                .check(classes);
    }

    @Test
    public void shouldBeAnnotatedWithConfiguration() {
        classes()
                .that().resideInAPackage("..config..")
                .and().resideOutsideOfPackages("..client")
                .and().resideOutsideOfPackages("..security")
                .should().beAnnotatedWith(Configuration.class)
                .check(classes);
    }
}
