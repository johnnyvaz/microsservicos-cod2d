package br.com.cod2d.api.archtest;

import br.com.cod2d.api.archtest.config.ArchTestConfig;
import org.junit.Test;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchUseCaseTest extends ArchTestConfig {

    @Test
    public void shouldHaveSimpleNameEndingWithUseCase() {
        classes()
                .that().resideInAPackage(".usecase..")
                .and().resideOutsideOfPackage("..impl")
                .should().haveSimpleNameEndingWith("UseCase")
                .check(classes);

    }

    @Test
    public void shouldBeInterfacesUseCase() {
        classes()
                .that().resideInAPackage(".usecase..")
                .and().resideOutsideOfPackage("..impl")
                .should().beInterfaces()
                .check(classes);
    }

    @Test
    public void shouldHaveSimpleNameEndingWithUseCaseImpl() {
        classes()
                .that().resideInAPackage("..usecase.impl..")
                .should().haveSimpleNameEndingWith("UseCaseImpl")
                .check(classes);

    }

    @Test
    public void shouldBeAnnotatedWithComponentForUseCase() {
        classes()
                .that().resideInAPackage("..usecase.impl..")
                .should().beAnnotatedWith(Service.class)
                .check(classes);
    }
}
