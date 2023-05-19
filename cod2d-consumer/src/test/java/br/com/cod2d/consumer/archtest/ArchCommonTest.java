package br.com.cod2d.consumer.archtest;


import br.com.cod2d.consumer.archtest.config.ArchTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

public class ArchCommonTest extends ArchTest {
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
//                .layer("Controller").definedBy("..controller..")
//                .layer("UseCase").definedBy("..usecase..", "..usecases..")
//                .layer("Domain").definedBy("..domain..",
//                        "..domains..", "..entity..", "..entities..")
//                .whereLayer("Config").mayOnlyBeAccessedByLayers("Gateway")
//                .whereLayer("Gateway").mayOnlyBeAccessedByLayers("UseCase", "Config", "Controller")
//                .whereLayer("Domain").mayOnlyBeAccessedByLayers("UseCase", "Gateway",
//                "Controller", "Client", "Config")
//                .check(classes);
//    }
}
