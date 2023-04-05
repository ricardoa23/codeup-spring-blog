package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/roll-dice/{n}")
    public String rollAnswer(Model model, int guess) {
        int roll = rollDice();
        model.addAttribute("guess", guess);
        model.addAttribute("roll", roll);
        return"roll-dice-answer";
    }


}
