package br.com.cod2d.consumer.domain.enums;

public enum ShortLinkType {
    PERSON("p"),
    ORGANIZATION("o");

    private String description;

    ShortLinkType(final String type) {
        this.description = type;
    }

}
