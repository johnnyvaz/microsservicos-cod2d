package br.com.cod2d.redirect.archtest;

import br.com.cod2d.redirect.archtest.config.ArchTestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

public class ArchCommonTest extends ArchTestConfig {
    @Test
    public void shouldFieldsNotBeAnnotatedWithAutowired() {
        fields().should()
                .notBeAnnotatedWith(Autowired.class)
                .check(classes);
    }

//    @Test
//    public void shouldOnlyAllowTheseInteractionsBetweenLayers() {
//        layeredArchitecture()
//                .withOptionalLayers(true)
//                .layer("Config").definedBy("..config..",
//                        "..configs..", "..conf..", "..conf..", "..configuration..", "..configurations..")
//                .layer("Gateway").definedBy("..gateway..", "..gateways..")
//                .layer("Client").definedBy("..config.client..")
//                .layer("Repository").definedBy("..repository..", "..repositories..")
//                .layer("Input").definedBy("..input..")
//                .layer("UseCase").definedBy("..usecase..", "..usecases..")
//                .layer("Domain").definedBy("..domain..",
//                        "..domains..", "..entity..", "..entities..")
//                .whereLayer("Config").mayOnlyBeAccessedByLayers("Gateway")
//                .whereLayer("Gateway").mayOnlyBeAccessedByLayers("UseCase")
//                .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Input")
//                .whereLayer("Domain").mayOnlyBeAccessedByLayers("UseCase", "Gateway", "Input", "Client")
//                .check(classes);
//    }
}
