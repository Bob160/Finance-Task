package com.example.clientcontractor.dto;

import com.example.clientcontractor.Enum.ContractStatus;
import com.example.clientcontractor.pojos.JobResponse;
import com.example.clientcontractor.pojos.ProfileResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractRequestDto {

    private String name;

    private ProfileResponse clientProfile;

    private List<JobResponse> jobs;

    private ContractStatus contractStatus;
    private BigDecimal totalBudget;

    private ProfileResponse contractor;
}
