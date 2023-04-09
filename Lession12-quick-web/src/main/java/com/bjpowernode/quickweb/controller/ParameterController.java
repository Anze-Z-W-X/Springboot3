package com.bjpowernode.quickweb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.Reader;

@RestController
public class ParameterController {
    @PostMapping("/param/json2")
    public String p1(Reader reader){
        StringBuffer content = new StringBuffer("");
        try(BufferedReader bin = new BufferedReader(reader)){
            var line = "";
            while((line = bin.readLine())!=null)
                content.append(line);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "p7,reader="+content;
    }
}
