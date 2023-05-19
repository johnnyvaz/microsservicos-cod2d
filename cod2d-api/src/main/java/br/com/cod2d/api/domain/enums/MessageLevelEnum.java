package br.com.cod2d.api.domain.enums;

public enum MessageLevelEnum {
    INFO("#36a64f"),
    ERROR("#f94d4d"),
    ALERT("#EFF204");

    private String color;

    MessageLevelEnum(final String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
