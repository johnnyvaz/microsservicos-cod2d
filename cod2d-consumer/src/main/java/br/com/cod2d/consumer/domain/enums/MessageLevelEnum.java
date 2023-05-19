package br.com.cod2d.consumer.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum MessageLevelEnum {
    INFO("#36a64f"),
    ERROR("#f94d4d"),
    ALERT("#EFF204");

    private String color;

}
