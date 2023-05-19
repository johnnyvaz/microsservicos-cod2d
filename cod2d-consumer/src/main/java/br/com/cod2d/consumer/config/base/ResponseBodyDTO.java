package br.com.cod2d.consumer.config.base;

import br.com.cod2d.consumer.config.base.error.ErrorDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseBodyDTO<T> implements Serializable {

    protected MetaDTO meta;
    protected List<ErrorDTO> errors;
    protected List<T> records;

    public ResponseBodyDTO() {
    }

    public ResponseBodyDTO(final List<ErrorDTO> errors) {
        this.meta = null;
        this.errors = errors;
    }

    public ResponseBodyDTO(final ErrorDTO error) {
        this.meta = null;
        this.errors = new ArrayList<>();
        this.errors.add(error);
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }
    public void setErrors(final List<ErrorDTO> errors) {
        this.errors = errors;
    }

    public void addError(final ErrorDTO error) {
        if (errors == null) {
            errors = new ArrayList<>();
        }

        errors.add(error);

    }

    public void addErrors(final List<ErrorDTO> errors) {
        if ((this.errors == null) || this.errors.isEmpty()) {
            this.errors = errors;
        } else {
            errors.forEach(error -> {
                this.errors.add(error);
            });
        }
    }

    public void setMeta(final MetaDTO meta) {
        this.meta = meta;
    }

    public MetaDTO getMeta() {

        if (meta == null) {
            String hostName = "";
            try {
                hostName = InetAddress.getLocalHost().getHostName();
            } catch (final UnknownHostException e) {
                hostName = "UnknownHost";
            }

            return MetaDTO.builder()
                    .server(hostName)
                    .limit(this.records == null ? 0 : this.records.size())
                    .offset(0L)
                    .recordCount(this.records == null ? 0 : this.records.size())
                    .build();
        } else {
            return meta;
        }
    }

    public boolean isSucess() {
        if ((errors == null) || errors.isEmpty()) {
            return true;
        }

        return false;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(final List<T> records) {
        this.records = records;
    }

    public void addRecord(final T record) {
        if (this.records == null) {
            records = new ArrayList<>();
        }

        records.add(record);

    }

    public static <T, R> ResponseBodyDTO<?> of(final List<R> list, final Long offSet, final Integer size,
                                               final Integer totalPages, final Long totalElements,
                                               final Integer numberOfElements) {
        final ResponseBodyDTO<R> response = new ResponseBodyDTO<>();
        addMetaOnResponse(response, offSet, size, totalPages, totalElements, numberOfElements);
        response.setRecords(list);
        return response;
    }

    public static <T> ResponseBodyDTO<T> of(final List<T> list) {
        final ResponseBodyDTO<T> response = new ResponseBodyDTO<>();
        response.getMeta().setRecordCount(list.size());
        list.forEach(response::addRecord);
        return response;
    }

    public static <T> ResponseBodyDTO<T> of(final T t) {
        final ResponseBodyDTO<T> response = new ResponseBodyDTO<>();
        response.getMeta().setRecordCount(1);
        response.addRecord(t);
        return response;
    }

    public static ResponseBodyDTO<ErrorDTO> with(final ErrorDTO error) {
        final ResponseBodyDTO<ErrorDTO> response = new ResponseBodyDTO<>();
        response.addError(error);
        return response;
    }

    public static ResponseBodyDTO<ErrorDTO> with(final List<ErrorDTO> errors) {
        final ResponseBodyDTO<ErrorDTO> response = new ResponseBodyDTO<>();
        response.setErrors(errors);
        return response;
    }

    public static <T> ResponseBodyDTO<T> with(final T t, final ErrorDTO error) {
        final ResponseBodyDTO<T> response = new ResponseBodyDTO<>();
        response.addRecord(t);
        response.addError(error);
        return response;
    }

    public static <T> ResponseBodyDTO<T> with(final List<T> list, final ErrorDTO error) {
        final ResponseBodyDTO<T> response = new ResponseBodyDTO<>();
        response.setRecords(list);
        response.addError(error);
        return response;
    }

    private static void addMetaOnResponse(final ResponseBodyDTO<?> response,
                                          final Long offSet,
                                          final Integer size,
                                          final Integer totalPages,
                                          final Long totalElements,
                                          final Integer numberOfElements) {
        response.setMeta(response.getMeta());
        response.getMeta().setOffset(offSet);
        response.getMeta().setLimit(size);
        response.getMeta().setTotalPages(totalPages);
        response.getMeta().setRecordCountTotal(totalElements);
        response.getMeta().setRecordCount(numberOfElements);
    }
}