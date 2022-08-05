package com.example.examplespring.mvc.domain;

import lombok.Data;

import java.util.Date;

/**
 * 게시물
 */
@Data
public class Board {

    private int boardSeq;
    private BoardType boardType;
    private String title;
    private String contents;
    private int viewCount;
    private Date regDate;
    private boolean delYn;

}
