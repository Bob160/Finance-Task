package com.example.clientcontractor.serviceImpl;

import com.example.clientcontractor.Enum.PaymentStatus;
import com.example.clientcontractor.dto.DepositRequest;
import com.example.clientcontractor.model.Job;
import com.example.clientcontractor.model.Profile;
import com.example.clientcontractor.pojos.PaymentResponse;
import com.example.clientcontractor.repositories.JobRepository;
import com.example.clientcontractor.repositories.ProfileRepository;
import com.example.clientcontractor.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@RequiredArgsConstructor
@Service
public class BalanceServiceImpl implements BalanceService {

    private final ProfileRepository profileRepository;

    private final JobRepository jobRepository;
    @Override
    public PaymentResponse deposit(DepositRequest depositRequest) {

        Profile profile = new Profile();
        BigDecimal outStandingPayment = jobRepository.findAllByIdOrPaymentStatus(profile.getId(), PaymentStatus.NOT_PAID)
                .stream()
                .map(Job::getBudget)
                .reduce(BigDecimal::add)
                .get();
        BigDecimal amountPayable = outStandingPayment.multiply(BigDecimal.valueOf(25/100));
        if (depositRequest.getDepositAmount().compareTo(amountPayable) < 0) {
            profile.setBalance(profile.getBalance().add(depositRequest.getDepositAmount()));
            return new PaymentResponse(true, "Your wallet has been credited successfully");
        }
        return new PaymentResponse(false, "Unsuccessful. Please contact the admin");
    }
}
