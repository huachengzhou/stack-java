package com.blue.common.enums_common;

public enum PageEnum {
    PAGE_ENUM(10);
    private int size;

    PageEnum(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
