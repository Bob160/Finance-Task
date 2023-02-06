package com.example.clientcontractor.serviceImpl;

import com.example.clientcontractor.Enum.ContractStatus;
import com.example.clientcontractor.Enum.PaymentStatus;
import com.example.clientcontractor.exceptions.JobOrContractNotFoundException;
import com.example.clientcontractor.model.Job;
import com.example.clientcontractor.model.Profile;
import com.example.clientcontractor.pojos.JobResponse;
import com.example.clientcontractor.pojos.PaymentResponse;
import com.example.clientcontractor.repositories.JobRepository;
import com.example.clientcontractor.repositories.ProfileRepository;
import com.example.clientcontractor.services.JobService;
import com.example.clientcontractor.util.ResponseMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {



    private final JobRepository jobRepository;

//    public JobServiceImpl(JobRepository jobRepository) {
//        this.jobRepository = jobRepository;
//    }
    Profile profile = new Profile();

    @Transactional
    @Override
    public PaymentResponse payForAJob(Long id) {
        Job myJob = jobRepository.findById(id)
                .orElseThrow(() -> new JobOrContractNotFoundException("Job not found"));

        if (profile.getBalance().compareTo(myJob.getBudget()) >= 0) {
            profile.setBalance(profile.getBalance().subtract(myJob.getBudget()));
            myJob.getContract().getContractor().setBalance(myJob.getContract().getContractor().getBalance().add(myJob.getBudget()));

            return new PaymentResponse(true, "Your transaction was successful");
        }

        return new PaymentResponse(false, "Transaction unsuccessful. Insufficient Balance");
    }

    @Override
    public List<JobResponse> getUnpaidJobs() {

        Profile profile = new Profile();
        PaymentStatus paymentStatus = PaymentStatus.NOT_PAID;

        return jobRepository.findAllByIdOrPaymentStatus(profile.getId(), paymentStatus)
                .stream()
                .filter(job -> job.getContract().getStatus().equals(ContractStatus.IN_PROGRESS))
                .map(ResponseMappers::jobMap)
                .collect(Collectors.toList());
    }
}
