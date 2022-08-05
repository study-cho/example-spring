package com.example.examplespring.mvc.controller;

import com.example.examplespring.configuration.exception.BaseException;
import com.example.examplespring.configuration.http.BaseResponse;
import com.example.examplespring.configuration.http.BaseResponseCode;
import com.example.examplespring.framework.data.domain.MySQLPageRequest;
import com.example.examplespring.framework.data.domain.PageRequestParameter;
import com.example.examplespring.framework.web.bind.annotation.RequestConfig;
import com.example.examplespring.mvc.domain.Board;
import com.example.examplespring.mvc.parameter.BoardParameter;
import com.example.examplespring.mvc.parameter.BoardSearchParameter;
import com.example.examplespring.mvc.repository.BoardRepository;
import com.example.examplespring.mvc.service.BoardService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시판 컨트롤러
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {

    private final BoardService boardService;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 상세 정보 리턴
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    public String detail(@PathVariable int boardSeq, Model model) {
        Board board = boardService.get(boardSeq);
        // null 처리
        if(board == null)
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"});

        model.addAttribute("board", board);
        return "/board/detail";
    }

    /**
     * 목록 리턴
     * @param parameter
     * @param pageRequest
     * @return
     */
    @GetMapping("/list")
    public void list(BoardSearchParameter parameter, MySQLPageRequest pageRequest, Model model) {
        logger.info("pageRequest : {}", pageRequest);
        PageRequestParameter<BoardSearchParameter> pageRequestParameter = new PageRequestParameter<>(pageRequest, parameter);
        List<Board> boardList = boardService.getList(pageRequestParameter);
        model.addAttribute("boardList", boardList);
    }

    /**
     * 등록 화면
     * @param parameter
     * @param model
     */
    @GetMapping("/form")
    @RequestConfig(loginCheck = false)
    public void form(BoardParameter parameter, Model model) {
        model.addAttribute("parameter", parameter);
    }

    /**
     * 수정 화면
     * @param boardSeq
     * @param model
     */
    @GetMapping("/edit/{boardSeq}")
    @RequestConfig(loginCheck = false)
    public String edit(@PathVariable(required = true) int boardSeq, Model model) {
        Board board = boardService.get(boardSeq);
        // null 처리
        if (board == null)
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"} );
        model.addAttribute("board", board);
        return "/board/form";
    }


    /**
     * 등록/수정 처리
     * @param parameter
     */
    @PostMapping("/save")
    @RequestConfig(loginCheck = false)
    @ResponseBody
    @ApiOperation(value = "등록/수정 처리", notes = "신규 게시물 저장 및 기존 게시물 업데이트가 가능합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
            @ApiImplicitParam(name = "title", value = "제목", example = "spring"),
            @ApiImplicitParam(name = "contents", value = "내용", example = "spring 강좌")
    })
    public BaseResponse<Integer> save(BoardParameter parameter) {
        // 제목 필수 체크
        if(ObjectUtils.isEmpty(parameter.getTitle()))
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"title", "제목"});
        // 내용 필수 체크
        if(ObjectUtils.isEmpty(parameter.getContents()))
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] {"contents", "내용"});

        boardService.save(parameter);
        return new BaseResponse<>(parameter.getBoardSeq());
    }

    /**
     * 대용량 등록처리1
     * @return
     */
    @PutMapping("/saveList1")
    @ApiOperation(value = "대용량 등록처리1", notes = "대용량 등록처리1")
    public BaseResponse<Boolean> saveList1() {
        int count = 0;
        //테스트를 위한 랜덤 10000건의 데이터 생성
        List<BoardParameter> list = new ArrayList<>();
        while (true) {
            count++;
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);
            list.add(new BoardParameter(title, contents));
            if (count >= 10000)
                break;
        }
        long start = System.currentTimeMillis();
        boardService.saveList1(list);
        long end = System.currentTimeMillis();
        logger.info("실행 시간 : {}", (end - start) / 1000.0);
        return new BaseResponse<>(true);
    }

    /**
     * 대용량 등록처리2
     * @return
     */
    @PutMapping("/saveList2")
    @ApiOperation(value = "대용량 등록처리2", notes = "대용량 등록처리2")
    public BaseResponse<Boolean> saveList2() {
        int count = 0;
        //테스트를 위한 랜덤 10000건의 데이터 생성
        List<BoardParameter> list = new ArrayList<>();
        while (true) {
            count++;
            String title = RandomStringUtils.randomAlphabetic(10);
            String contents = RandomStringUtils.randomAlphabetic(10);
            list.add(new BoardParameter(title, contents));
            if (count >= 10000)
                break;
        }
        long start = System.currentTimeMillis();
        boardService.saveList2(list);
        long end = System.currentTimeMillis();
        logger.info("실행 시간 : {}", (end - start) / 1000.0);
        return new BaseResponse<>(true);
    }

    /**
     * 삭제 처리
     * @param boardSeq
     */
    @DeleteMapping("/{boardSeq}")
    @RequestConfig(loginCheck = true)
    @ResponseBody
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
