package com.example.clientcontractor.services;

import com.example.clientcontractor.dto.DepositRequest;
import com.example.clientcontractor.pojos.PaymentResponse;

public interface BalanceService {

    PaymentResponse deposit (DepositRequest depositRequest);
}
