package com.example.libraryapp2.controller.calculator;

import com.example.libraryapp2.dto.calculator.request.CalculatorAddRequest;
import com.example.libraryapp2.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addTwoNumbers(@RequestParam CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumber(@RequestBody CalculatorMultiplyRequest request){

        return request.getNumber1()* request.getNumber2();

    }
}
