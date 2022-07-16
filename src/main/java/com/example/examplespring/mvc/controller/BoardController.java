package com.example.examplespring.mvc.controller;

import com.example.examplespring.configuration.http.BaseResponse;
import com.example.examplespring.mvc.domain.Board;
import com.example.examplespring.mvc.parameter.BoardParameter;
import com.example.examplespring.mvc.repository.BoardRepository;
import com.example.examplespring.mvc.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시판 컨트롤러
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {

    private final BoardService boardService;

    /**
     * 목록 리턴
     * @return
     */
    @GetMapping
    @ApiOperation(value = "목록 조회", notes = "게시판 목록 정보를 조회할 수 있습니다.")
    public BaseResponse<List<Board>> getList() {
        return new BaseResponse<>(boardService.getList());
    }

    /**
     * 상세 정보 리턴
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    @ApiOperation(value = "상세 조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1")
    })
    public BaseResponse<Board> get(@PathVariable int boardSeq) {
        return new BaseResponse<>(boardService.get(boardSeq));
    }

    /**
     * 등록/수정 처리
     * @param parameter
     */
    @PutMapping("/save")
    @ApiOperation(value = "등록/수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name = "title", value = "제목", example = "spring"),
            @ApiImplicitParam(name = "contents", value = "내용", example = "spring 강좌")
    })
    public BaseResponse<Integer> save(BoardParameter parameter) {
        boardService.save(parameter);
        return new BaseResponse<>(parameter.getBoardSeq());
    }

    /**
     * 삭제 처리
     * @param boardSeq
     */
    @DeleteMapping("/{boardSeq}")
    @ApiOperation(value = "삭제 처리", notes = "게시물 번호에 해당하는 정보를 삭제합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1")
    })
    public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
        Board board = boardService.get(boardSeq);
        if (board == null)
            return new BaseResponse<>(false);
        boardService.delete(boardSeq);
        return new BaseResponse<>(true);
    }
}
