package br.com.cod2d.consumer.archtest;

import br.com.cod2d.consumer.archtest.config.ArchTest;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchUseCaseTest extends ArchTest {

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

    @Test
    public void shouldBeAnnotatedWithComponentForConvert() {
        classes()
                .that().resideInAPackage("..usecase.convert..")
                .should().beAnnotatedWith(Component.class)
                .check(classes);
    }

}
