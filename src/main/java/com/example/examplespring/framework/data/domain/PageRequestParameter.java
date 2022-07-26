package com.example.examplespring.framework.data.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 페이지 요청정보와 파라미터 정보
 * @param <T>
 */
@Data
public class PageRequestParameter<T> {

    private MySQLPageRequest pageRequest;
    private T parameter;

    public PageRequestParameter(MySQLPageRequest pageRequest, T parameter) {
        this.pageRequest = pageRequest;
        this.parameter = parameter;
    }
}
