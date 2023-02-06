package com.example.clientcontractor.controllers;

import com.example.clientcontractor.Enum.ContractStatus;
import com.example.clientcontractor.pojos.ContractResponse;
import com.example.clientcontractor.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;

    @GetMapping("/{id}")
    public ResponseEntity<ContractResponse> getAContract(@PathVariable Long id) {
        return ResponseEntity.ok(contractService.acceptContract(id));
    }

    @GetMapping("/contracts/id/contracts")

    public ResponseEntity<List<ContractResponse>> viewAllContractsByStatus() {
        ContractStatus contractStatus = ContractStatus.IN_PROGRESS;
        return ResponseEntity.ok(contractService.viewAllContractsByStatus(contractStatus));
    }


}
