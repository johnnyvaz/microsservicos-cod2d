package br.com.cod2d.api.archtest;

import br.com.cod2d.api.archtest.config.ArchTestConfig;
import org.junit.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchPropertiesTest extends ArchTestConfig {

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
