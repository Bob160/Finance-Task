package com.example.clientcontractor.services;

import com.example.clientcontractor.Enum.ContractStatus;
import com.example.clientcontractor.pojos.ContractResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {

    ContractResponse acceptContract(Long id);

    List<ContractResponse> viewAllContractsByStatus(ContractStatus status);
}
