package com.codeup.codeupspringblog.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/{operation}/{firstNum}/{fillerWord}/{secondNum}")
    @ResponseBody
    public String basicArithmetic(@PathVariable String operation, @PathVariable int firstNum, @PathVariable String fillerWord, @PathVariable int secondNum) {
        if(operation.equalsIgnoreCase("add") && fillerWord.equals("and")) {
            return "<h1>Equals" + firstNum + secondNum + "</h1>";

        } else if (operation.equals("subtract") && fillerWord.equals("from")) {
            return "<h1>Equals" + (firstNum - secondNum) + "</h1>";

        } else if(operation.equals("multiply") && fillerWord.equals("and")) {
            return "<h1>Equals" + firstNum * secondNum + "</h1>";

        } else if (operation.equals("divide") && fillerWord.equals("by")) {
            return "<h1>Equals" + firstNum / secondNum + "</h1>";
        }
        return "something went wrong";
    }

}
