package com.example.clientcontractor.serviceImpl;

import com.example.clientcontractor.Enum.ContractStatus;
import com.example.clientcontractor.dto.ContractRequestDto;
import com.example.clientcontractor.exceptions.JobOrContractNotFoundException;
//import com.example.clientcontractor.exceptions.UserNotFoundException;
import com.example.clientcontractor.model.Contract;
import com.example.clientcontractor.model.Profile;
import com.example.clientcontractor.pojos.ContractResponse;
import com.example.clientcontractor.repositories.ContractRepository;
import com.example.clientcontractor.repositories.ProfileRepository;
import com.example.clientcontractor.services.ContractService;
import com.example.clientcontractor.util.ResponseMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    private final ProfileRepository profileRepository;

    private final ContractResponse contractResponse;

    private final ContractRequestDto contractRequestDto;


    //Add logged in user
//    private Profile getLoggedInUser() {
//        var authentication = SecurityContextHolder.getC
//    }
    @Override
    public ContractResponse acceptContract(Long id) {
//            = new ContractResponse()
            Contract myContract = contractRepository.findById(id).orElseThrow(() -> new JobOrContractNotFoundException("Job or Contract does not exist"));

            if (contractRepository.existsById(id)) {

                return ResponseMappers.contractMap(myContract);

            }
            throw new JobOrContractNotFoundException("There is no such contract");

    }

    @Override
    public List<ContractResponse> viewAllContractsByStatus(ContractStatus status) {


        Profile profile = profileRepository.findById(id).orElse(null);

            allcontracts = contractRepository.findAllByClientOrContractorId(profile.getId()).parallelStream().map(ResponseMappers::contractMap).collect(Collectors.toList());
            return allcontracts;

    }


    private ContractResponse mapContract(Contract contract) {
        return ContractResponse.builder()
                .name(contractResponse.getName())
                .contractStatus(contractResponse.getContractStatus())
                .clientProfile(contractResponse.getClientProfile())
                .jobs(contractResponse.getJobs())
                .totalBudget(contractResponse.getTotalBudget())
                .build();

    }
}
