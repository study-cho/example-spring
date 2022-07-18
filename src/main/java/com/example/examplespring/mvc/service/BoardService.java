package com.example.examplespring.mvc.service;

import com.example.examplespring.mvc.domain.Board;
import com.example.examplespring.mvc.parameter.BoardParameter;
import com.example.examplespring.mvc.parameter.BoardSearchParameter;
import com.example.examplespring.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 게시판 서비스
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    /**
     * 목록 리턴
     * @param parameter
     * @return
     */
    public List<Board> getList(BoardSearchParameter parameter) {
        return repository.getList(parameter);
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
    public void save(BoardParameter parameter) {
        //조회하여 리턴된 정보
        Board board = repository.get(parameter.getBoardSeq());
        if (board == null)
            repository.save(parameter);
        else
            repository.update(parameter);
    }

    /**
     * 단순 반복문을 이용한 등록 처리
     */
    public void saveList1(List<BoardParameter> list) {
        for (BoardParameter parameter : list) {
            repository.save(parameter);
        }
    }

    /**
     * 100개씩 배열에 담아서 일괄 등록 처리
     */
    public void saveList2(List<BoardParameter> boardList) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("boardList", boardList);
        repository.saveList(paramMap);
    }

    /**
     * 삭제 처리
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        repository.delete(boardSeq);
    }
}
