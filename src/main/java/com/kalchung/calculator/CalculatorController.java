package com.kalchung.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String add(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: Необходимо указать оба параметра";
        }
        double result = calculatorService.add(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String subtract(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: Необходимо указать оба параметра";
        }
        double result = calculatorService.subtract(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: Необходимо указать оба параметра";
        }
        double result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Double num1, @RequestParam(required = false) Double num2) {
        if (num1 == null || num2 == null) {
            return "Ошибка: Необходимо указать оба параметра";
        }
        if (num2 == 0) {
            return "Ошибка: деление на 0 невозможно";
        }
        double result = calculatorService.divide(num1, num2);
        return num1 + " / " + num2 + " = " + result;
    }
}