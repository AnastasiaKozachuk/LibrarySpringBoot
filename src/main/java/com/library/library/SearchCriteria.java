package com.library.library;

public class SearchCriteria {

    public SearchCriteria(String key,Object value) {
        this.key = key;
        this.value = value;
    }

    private String key;
    private Object value;

    String getKey() {
        return key;
    }

    Object getValue() {
        return value;
    }

}
