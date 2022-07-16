package com.example.examplespring.mvc.service;

import com.example.examplespring.mvc.domain.Board;
import com.example.examplespring.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 게시판 서비스
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    /**
     * 목록 리턴
     * @return
     */
    public List<Board> getList() {
        return repository.getList();
    }

    /**
     * 상세 정보 리턴
     * @param boardSeq
     * @return
     */
    public Board get(int boardSeq) {
        return repository.get(boardSeq);
    }

    /**
     * 등록/수정 처리
     * @param parameter
     */
    public void save(Board parameter) {
        //조회하여 리턴된 정보
        Board board = repository.get(parameter.getBoardSeq());
        if (board == null)
            repository.save(parameter);
        else
            repository.update(parameter);
    }


    /**
     * 삭제 처리
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        repository.delete(boardSeq);
    }
}
