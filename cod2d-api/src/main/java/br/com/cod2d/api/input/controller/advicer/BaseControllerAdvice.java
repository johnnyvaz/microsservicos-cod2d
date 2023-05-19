package br.com.cod2d.api.input.controller.advicer;

import br.com.cod2d.api.config.base.ResponseBodyDTO;
import br.com.cod2d.api.config.base.error.ErrorCodeEnum;
import br.com.cod2d.api.config.base.error.ErrorDTO;
import br.com.cod2d.api.config.base.error.ErrorDTOFactory;
import br.com.cod2d.api.config.base.handle.HandleValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public abstract class BaseControllerAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(BaseControllerAdvice.class);

    public BaseControllerAdvice() {
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(final Exception ex, final WebRequest request) {
        return ResponseEntity.status(ErrorCodeEnum.findHttpStatus(ErrorDTOFactory
                .getInternalServerError(ex.getMessage()).getErrorCode()))
                .body(ResponseBodyDTO.with(ErrorDTOFactory.getInternalServerError(
                        ex.getMessage() == null ? ex.getClass().getName() : ex.getMessage())));
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity handleMissingServletRequestParameterException(
            final MissingServletRequestParameterException ex) {
        final ErrorDTO errorDTO = ErrorDTOFactory.getMissingParameter("value", ex.getParameterName());
        final HttpStatus httpStatus = ErrorCodeEnum.findHttpStatus(errorDTO.getErrorCode());

        assert httpStatus != null;

        return ResponseEntity.status(httpStatus).body(ResponseBodyDTO.with(errorDTO));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity handleApiException(final MethodArgumentNotValidException ex) {
        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        final HandleValidationError handleValidationError = new HandleValidationError();
        final List<ErrorDTO> errors = handleValidationError.createErrorsFromList(fieldErrors);
        final int httpcode = ErrorCodeEnum.MALFORMED_REQUEST_BODY.getHttpCode().value();
        return ResponseEntity.status(httpcode).body(ResponseBodyDTO.with(errors));
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity handleApiException(final HttpMessageNotReadableException ex) {
        final ErrorDTO errorDto = ErrorDTOFactory.getMalformedRequestBody(ex.getMessage());
        final HttpStatus httpStatus = ErrorCodeEnum.findHttpStatus(errorDto.getErrorCode());

        assert httpStatus != null;

        return ResponseEntity.status(httpStatus).body(ResponseBodyDTO.with(errorDto));
    }
}

