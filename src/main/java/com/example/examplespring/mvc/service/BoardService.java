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
     * 등록 처리
     * @param board
     */
    public void save(Board board) {
        repository.save(board);
    }

    /**
     * 수정 처리
     * @param board
     */
    public void update(Board board) {
        repository.update(board);
    }

    /**
     * 삭제 처리
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        repository.delete(boardSeq);
    }
}
