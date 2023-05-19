package br.com.cod2d.redirect.config.base;

import br.com.cod2d.redirect.config.base.error.ErrorCodeEnum;
import br.com.cod2d.redirect.config.base.error.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseController {
    public BaseController() {
    }

    protected <T> ResponseEntity<ResponseBodyDTO<T>> buildSuccessPost(final T record) {
        return this.buildSuccessResponse(record, HttpStatus.CREATED);
    }

    protected <T> ResponseEntity<ResponseBodyDTO<T>> buildSuccessResponse(final T record, final HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(ResponseBodyDTO.of(record));
    }

    protected <T> ResponseEntity<ResponseBodyDTO<T>> buildResponse(final ResponseBodyDTO<T> responseBody,
                                                                   final HttpStatus httpStatusSuccess) {
        return responseBody.isSucess() ? ResponseEntity.status(httpStatusSuccess)
                .body(responseBody) : this.errorResponse(responseBody);
    }

    protected <T> ResponseEntity<ResponseBodyDTO<T>> errorResponse(final ResponseBodyDTO<T> responseBody) {
        return ResponseEntity.status(ErrorCodeEnum.findHttpStatus(
                ((ErrorDTO)responseBody.getErrors().get(0)).getErrorCode())).body(responseBody);
    }

    protected <T> ResponseEntity buildPostResponseBody(final T body) {
        return this.buildResponse(ResponseBodyDTO.of(body), HttpStatus.CREATED);
    }

    protected <T> ResponseEntity buildResponseBody(final T body, final HttpStatus httpStatus) {
        return this.buildResponse(ResponseBodyDTO.of(body), httpStatus);
    }

    protected <T> ResponseEntity buildResponseBody(final List<T> body, final HttpStatus httpStatus) {
        return this.buildResponse(ResponseBodyDTO.of(body), httpStatus);
    }
}
