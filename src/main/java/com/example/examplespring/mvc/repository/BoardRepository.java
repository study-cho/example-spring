package com.example.examplespring.mvc.repository;

import com.example.examplespring.framework.data.domain.PageRequestParameter;
import com.example.examplespring.mvc.domain.Board;
import com.example.examplespring.mvc.parameter.BoardParameter;
import com.example.examplespring.mvc.parameter.BoardSearchParameter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 게시판 Repository
 */
@Repository
public interface BoardRepository {

    List<Board> getList(PageRequestParameter<BoardSearchParameter> pageRequestParameter);

    Board get(int boardSeq);

    void save(BoardParameter board);

    void saveList(Map<String, Object> paramMap);

    void update(BoardParameter board);

    void delete(int boardSeq);
}
