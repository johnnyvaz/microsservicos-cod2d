package br.com.cod2d.redirect.input.controller.advicer;

import br.com.cod2d.redirect.config.base.ResponseBodyDTO;
import br.com.cod2d.redirect.config.base.error.ErrorCodeEnum;
import br.com.cod2d.redirect.config.base.error.ErrorDTO;
import br.com.cod2d.redirect.config.base.error.ErrorDTOFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ResponseBodyDTO<ErrorDTO>> handleInternalServerException(
            final RuntimeException ex) {

        final var internalServerError = ErrorDTOFactory.getInternalServerError(ex.getMessage());
        return ResponseEntity.status(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getHttpCode())
                .body(ResponseBodyDTO.with(internalServerError));

    }
}