package com.example.clientcontractor.services;

import com.example.clientcontractor.pojos.JobResponse;
import com.example.clientcontractor.pojos.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    PaymentResponse payForAJob(Long id);

    List<JobResponse> getUnpaidJobs();
}
