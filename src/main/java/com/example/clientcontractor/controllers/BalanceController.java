package com.example.clientcontractor.controllers;

import com.example.clientcontractor.dto.DepositRequest;
import com.example.clientcontractor.pojos.PaymentResponse;
import com.example.clientcontractor.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/balance")
@RestController
public class BalanceController {

    private final BalanceService balanceService;

    @PostMapping("/deposit")
    public ResponseEntity<PaymentResponse> creditWallet (@RequestBody DepositRequest depositRequest) {
        return ResponseEntity.ok(balanceService.deposit(depositRequest));
    }
}
