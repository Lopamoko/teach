package me.teach.lopamoko.TeachMe.utils;

import lombok.Data;

@Data
public class PageRequest {
    private int size;
    private int page;

    public PageRequest(int size, int page) {
        this.size = size;
        this.page = page;
    }
}
