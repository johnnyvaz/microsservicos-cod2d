package br.com.cod2d.consumer.archtest;

import br.com.cod2d.consumer.archtest.config.ArchTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchPropertiesTest extends ArchTest {

    @Test
    public void shouldHaveSimpleNameEndingWithProperties() {
        classes()
                .that().resideInAPackage("..properties..")
                .and().areNotMemberClasses()
                .should().haveSimpleNameEndingWith("Properties")
                .check(classes);
    }

    @Test
    public void shouldBeAnnotatedWithConfigurationProperties() {
        classes()
                .that().resideInAPackage("..properties..")
                .and().areNotMemberClasses()
                .should().beAnnotatedWith(ConfigurationProperties.class)
                .check(classes);
    }
}
