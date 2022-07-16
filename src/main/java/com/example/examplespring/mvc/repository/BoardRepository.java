package com.example.examplespring.mvc.repository;

import com.example.examplespring.mvc.domain.Board;
import com.example.examplespring.mvc.parameter.BoardParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 Repository
 */
@Repository
public interface BoardRepository {

    List<Board> getList();

    Board get(int boardSeq);

    void save(BoardParameter board);

    void update(BoardParameter board);

    void delete(int boardSeq);
}
