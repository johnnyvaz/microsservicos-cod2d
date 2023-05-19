package br.com.cod2d.api.unit.controller;

import br.com.cod2d.api.config.base.error.ErrorCodeEnum;
import br.com.cod2d.api.input.controller.advicer.ApiControllerAdvice;
import br.com.cod2d.api.unit.config.UnitTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ApiClientControllerAdviceTest extends UnitTestConfig {

    public ApiControllerAdvice apiControllerAdvice;

    @Before
    public void setup() {
        apiControllerAdvice = new ApiControllerAdvice();
    }


    @Test
    public void shouldHandleRuntimeExceptions() {
        final var responseEntity = apiControllerAdvice
                .handleInternalServerException(new RuntimeException("test"));
        Assertions.assertEquals(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getHttpCode(), responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity);
    }

}
