package com.example.examplespring.mvc.parameter;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시물 검색 파라미터
 */
@Data
@NoArgsConstructor
public class BoardSearchParameter {

    private String keyword;

}
