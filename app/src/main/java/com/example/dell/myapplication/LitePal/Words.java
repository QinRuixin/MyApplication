package com.example.dell.myapplication.LitePal;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Words extends LitePalSupport {
    @Column(unique = true,defaultValue = "unknown",nullable = false)
    private String name;
    private String words;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
