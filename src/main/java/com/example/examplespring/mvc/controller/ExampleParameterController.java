package com.example.examplespring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/example/parameter")
public class ExampleParameterController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/example1")
    public void example1(@RequestParam String id,
                         @RequestParam String code,
                         Model model) {
        model.addAttribute("id", id);
        model.addAttribute("code", code);
    }

    /**
     * Map을 활용한 파리미터 받는 방법
     * @param paramMap
     * @param model
     */
    @GetMapping("/example2")
    public void example2(@RequestParam Map<String, Object> paramMap, Model model) {
        model.addAttribute("paramMap", paramMap);
    }

    /**
     * Class를 활용한 파라미터 받는 방법
     * @param parameter
     * @param model
     */
    @GetMapping("/example3")
    public void example3(ExampleParameter parameter, Model model) {
        model.addAttribute("parameter", parameter);
    }

    /**
     *  @PathVariable을 활용한 파라미터 받는 방법
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/example4/{id}/{code}")
    public String example4(@PathVariable String id,
                           @PathVariable String code, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("code", code);
        return "/example/parameter/example4";
    }

    /**
     * String[] 배열을 파라미터로 받는 방법
     * @param ids
     * @param model
     */
    @GetMapping("/example5")
    public void example5(@RequestParam String[] ids, Model model) {
        model.addAttribute("ids", ids);
    }


    @GetMapping("/example6/form")
    public void form() {
    }

    /**
     * JSON 받는 방법
     * @param requestBody
     * @return
     */
    @PostMapping("/example6/saveData")
    @ResponseBody
//    public Map<String, Object> example6(@RequestBody Map<String, Object> requestBody) {
    public Map<String, Object> example6(@RequestBody ExampleRequestBodyUser requestBody) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", true);
        logger.info("requestBody : {}", requestBody);
        return resultMap;
    }
}
