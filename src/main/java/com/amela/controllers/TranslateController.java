package com.amela.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    @RequestMapping("/")
    public String getForm(){
        return "index";
    }

    @PostMapping("/translate")
    public ModelAndView translate(@RequestParam("txtSearch") String search){
        ModelAndView modelAndView = null;

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String result = dictionary.get(search);

        if(result != null){
            modelAndView = new ModelAndView("translate");
            modelAndView.addObject("search", search);
            modelAndView.addObject("result", result);
        } else {
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("message", "Not found");
        }
        return modelAndView;
    }
}
