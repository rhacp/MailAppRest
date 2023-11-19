package com.team.MailRestVariant.models;

public enum ValidDomain {

    GMAIL("gmail.com"),
    YAHOO("yahoo.com");

    private String value;

    ValidDomain(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
