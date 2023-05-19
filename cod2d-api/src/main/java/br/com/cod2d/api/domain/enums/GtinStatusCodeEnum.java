package br.com.cod2d.api.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum GtinStatusCodeEnum {

    ACTIVE,
    CANCELED,
    INACTIVE,
    REACTIVATED,
    SUSPENDED;

    private String status;

}
