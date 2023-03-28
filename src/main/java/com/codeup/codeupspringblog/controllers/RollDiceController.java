package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rolldice() {
        return "roll-dice";
    }

//    @GetMapping("/roll-dice/{n}")
//    public String rollDiceCompared(@RequestParam int n){
//        int diceRoll = rollDice();
//
//    }

    public static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }


}
