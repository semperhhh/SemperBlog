package com.zph.Utils;

import lombok.Data;

import java.util.List;

@Data
public class PageR<T> {
    Long total;
    List<T> lists;

    public PageR(Long total, List<T> lists) {
        this.total = total;
        this.lists = lists;
    }
}