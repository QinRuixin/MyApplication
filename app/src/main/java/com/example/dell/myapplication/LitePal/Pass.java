package com.example.dell.myapplication.LitePal;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class Pass extends LitePalSupport {
    @Column(unique = true,defaultValue = "unknown",nullable = false)
    private String name;
    private boolean passed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
