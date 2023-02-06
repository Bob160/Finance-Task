package com.example.clientcontractor.util;

import com.example.clientcontractor.Enum.PaymentStatus;
import com.example.clientcontractor.Enum.UserType;
import com.example.clientcontractor.model.Contract;
import com.example.clientcontractor.model.Job;
import com.example.clientcontractor.model.Profession;
import com.example.clientcontractor.model.Profile;
import com.example.clientcontractor.repositories.ContractRepository;
import com.example.clientcontractor.repositories.JobRepository;
import com.example.clientcontractor.repositories.ProfessionRepository;
import com.example.clientcontractor.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class DbPopulator implements CommandLineRunner {
    private final ProfileRepository profileRepository;
    private final JobRepository jobRepository;
    private final ContractRepository contractRepository;
    private final ProfessionRepository professionRepository;

    private void createObjectSamples(){
        Profile sampleClient = profileRepository.save(Profile.builder()
                .firstName("Clark")
                .lastName("Kent")
                .email("k.clark@woven.com")
                .password("1234")
                .userType(UserType.CLIENT)
                .balance(BigDecimal.valueOf(100))
                .build());

        Profile sampleContractor = profileRepository.save(Profile.builder()
                .firstName("Kelly")
                .lastName("Hilson")
                .email("h.kelly@woven.com")
                .password("password")
                .userType(UserType.CONTRACTOR)
                .balance(BigDecimal.valueOf(100))
                .build());

        Contract contract=contractRepository.save(Contract.builder().client(UserType.valueOf()).contractor(sampleContractor).status(ContractStatus.IN_PROGRESS).build());

        Profession profession=professionRepository.save(Profession.builder().build());

        Job sampleJob = jobRepository.save( Job.builder()
                .name("Sample Job")
                .budget(BigDecimal.valueOf(100))
                .started(Date.now())
                .completed(Date.now().plusDays(7))
                .paymentStatus(PaymentStatus.NOT_PAID)
                .contract(myContract)
                .profession(profession)
                .build());

    }
}
