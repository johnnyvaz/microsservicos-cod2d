package br.com.cod2d.redirect.archtest;

import br.com.cod2d.redirect.archtest.config.ArchTestConfig;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchTransportGatewayTest extends ArchTestConfig {

    @Test
    public void shouldHaveSimpleNameEndingWithGateway() {
        classes()
                .that().resideInAPackage("..gateway..")
                .and().resideInAPackage("..impl")
                .and().resideOutsideOfPackage("..mapper")
                .should().haveSimpleNameEndingWith("Gateway")
                .orShould().haveSimpleNameEndingWith("Listener")
                .orShould().haveSimpleNameEndingWith("Repository")
                .check(classes);

    }

    @Test
    public void shouldBeInterfaces() {
        classes()
                .that().resideInAPackage("..gateway..")
                .and().resideInAPackage("..impl")
                .and().resideOutsideOfPackage("..mapper")
                .and().resideOutsideOfPackage("..listener")
                .should().beInterfaces()
                .check(classes);

    }

    @Test
    public void shouldHaveSimpleNameEndingWithGatewayImpl() {
        classes()
                .that().resideInAPackage("..gateway.impl..")
                .and().resideOutsideOfPackage("..utils")
                .should().haveSimpleNameEndingWith("GatewayImpl")
                .orShould().haveSimpleNameEndingWith("Listener")
                .orShould().haveSimpleNameEndingWith("Repository")
                .orShould().haveSimpleNameEndingWith("Mapper")
                .check(classes);

    }

    @Test
    public void shouldBeAnnotatedWithComponent() {
        classes()
                .that().resideInAPackage("..gateway.impl..")
                .and().resideOutsideOfPackage("..utils")
                .should().beAnnotatedWith(Repository.class)
                .orShould().beAnnotatedWith(Component.class)
                .check(classes);
    }

}
