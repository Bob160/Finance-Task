package com.example.clientcontractor.pojos;

import com.example.clientcontractor.Enum.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    private Long id;

    private String name;

    private Long contractId;

    private String ContractName;

    private PaymentStatus paymentStatus;

    private BigDecimal jobBudget;

}
