package com.example.examplespring.mvc.controller;

import com.example.examplespring.mvc.domain.Board;
import com.example.examplespring.mvc.repository.BoardRepository;
import com.example.examplespring.mvc.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 게시판 컨트롤러
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    /**
     * 목록 리턴
     * @return
     */
    @GetMapping
    public List<Board> getList() {
        return boardService.getList();
    }

    /**
     * 상세 정보 리턴
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq) {
        return boardService.get(boardSeq);
    }

    /**
     * 등록/수정 처리
     * @param board
     */
    @GetMapping("/save")
    public void save(Board board) {
        boardService.save(board);
    }

    /**
     * 삭제 처리
     * @param boardSeq
     */
    @GetMapping("/delete/{boardSeq}")
    public void delete(@PathVariable int boardSeq) {
        boardService.delete(boardSeq);
    }
}