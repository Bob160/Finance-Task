package com.example.clientcontractor.pojos;

import com.example.clientcontractor.Enum.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponse {

    private String name;

    private ProfileResponse clientProfile;

    private List<JobResponse> jobs;

    private ContractStatus contractStatus;
    private BigDecimal totalBudget;

    private ProfileResponse contractor;

}
