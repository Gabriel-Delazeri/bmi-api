package com.delazeri.imc.controllers;

import com.delazeri.imc.models.IMCRequest;
import com.delazeri.imc.models.IMCResponse;
import com.delazeri.imc.services.IMCCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/imc")
public class IMCController {

    @Autowired
    IMCCalculatorService calculatorService;

    @PostMapping
    ResponseEntity<IMCResponse> calculateImc(@RequestBody IMCRequest request) {
        return ResponseEntity.ok().body(calculatorService.calculate(request));
    }
}
