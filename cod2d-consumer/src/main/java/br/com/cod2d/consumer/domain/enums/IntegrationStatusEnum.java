package br.com.cod2d.consumer.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IntegrationStatusEnum {

    ABORTED("A"),
    ERROR("E"),
    INTEGRATED("S"),
    PENDING("N"),
    PROCESS("P"),
    REPROCESS("R");

    private final String status;
}