package com.example.examplespring.mvc.controller;

import com.example.examplespring.mvc.domain.BoardType;
import com.example.examplespring.mvc.parameter.BoardSearchParameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example/taglib")
public class ExampleTaglibController {

    @RequestMapping("/search")
    public void search(BoardSearchParameter parameter, Model model) {
        model.addAttribute("boardTypes", BoardType.values());
        model.addAttribute("parameter", parameter);
    }
}
