package com.example.clientcontractor.repositories;

import com.example.clientcontractor.model.Contract;
import com.example.clientcontractor.pojos.ContractResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query(nativeQuery = true, value = "SELECT * from contracts WHERE client_id=id OR contractor_id=id AND contract_status=status")
   List<Contract> findAllByClientOrContractorIdAndStatus(Long id);

    List<Contract> findAllByClientOrContractorId(Long id);

    Optional<Contract> findById(Long profileId);

}
