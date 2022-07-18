package com.example.examplespring.mvc.parameter;

import lombok.Data;

import java.util.Date;

@Data
public class BoardParameter {

    private int boardSeq;
    private String title;
    private String contents;

    public BoardParameter() {
    }

    public BoardParameter(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
